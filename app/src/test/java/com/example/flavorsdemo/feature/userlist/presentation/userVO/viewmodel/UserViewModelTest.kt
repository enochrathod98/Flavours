package com.example.flavorsdemo.feature.userlist.presentation.userVO.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.userlist.domain.entity.UserEntity
import com.example.flavorsdemo.feature.userlist.domain.usecase.UserUseCase
import com.example.flavorsdemo.feature.userlist.presentation.userVO.UserVo
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserViewModelTest {
    val useCase = mockk<UserUseCase>()


    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `test creating viewmodel calls usecase`() {
        runBlocking {
            coEvery { useCase.invoke() } returns (Resource.Success(emptyList()))

            //act
            UserViewModel(useCase)

            //assert
            coVerify(exactly = 1) { useCase.invoke() }
        }
    }

    @Test
    fun `test creating viewmodel with successful usecase updates livedata`() {
        runBlocking {
            //arrange
            val useCaseResult = Resource.Success<List<UserEntity>>(emptyList())
            coEvery { useCase.invoke() }.returns(useCaseResult)


            //act
            val viewModel = UserViewModel(useCase)

            //assert
            val value = viewModel.userView.value
            assert(value is UserVo.Loaded && value.users == useCaseResult.data)
        }
    }


    @Test
    fun `test creating viewmodel with error usecase updates livedata`() {
        runBlocking {
            //arrange
            val errorMessage = "This is an error message"
            val useCaseResult = Resource.Error(Exception(errorMessage))
            coEvery { useCase.invoke() }.returns(useCaseResult)


            //act
            val viewModel = UserViewModel(useCase)

            //assert
            val value = viewModel.userView.value as? UserVo.Error
            assert(value != null)
            assert(value?.message == errorMessage)
        }
    }
}