package com.example.flavorsdemo.feature.multipleview.presentation.multipleviewVO.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.multipleview.domain.entity.MultipleViewEntity
import com.example.flavorsdemo.feature.multipleview.domain.usecase.MultipleViewUseCase
import com.example.flavorsdemo.feature.multipleview.presentation.multipleviewVO.MultipleViewVO
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

class MultipleViewModelTest {

    private lateinit var viewModel: MultipleViewModel

    val useCase = mockk<MultipleViewUseCase>()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        MockKAnnotations.init(this)

        //viewModel = MultipleViewModel(useCase)
    }


    @Test
    fun `test creating viewmodel calls usecase`() {

        runBlocking {
            //arrange
            coEvery { useCase.invoke() }.returns(Resource.Success(emptyList()))


            //act
            MultipleViewModel(useCase)

            //assert
            coVerify(exactly = 1) { useCase.invoke() }
        }


    }

    @Test
    fun `test creating viewmodel with successful usecase updates livedata`() {
        runBlocking {
            //arrange
            val useCaseResult = Resource.Success<List<MultipleViewEntity>>(emptyList())
            coEvery { useCase.invoke() }.returns(useCaseResult)


            //act
            val viewModel = MultipleViewModel(useCase)

            //assert
            val value = viewModel.dataView.value
            assert(value is MultipleViewVO.Loaded && value.users == useCaseResult.data)
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
            val viewModel = MultipleViewModel(useCase)

            //assert
            val value = viewModel.dataView.value as? MultipleViewVO.Error
            assert(value != null)
            assert(value?.message == errorMessage)
        }
    }

    @Test
    fun `test creating viewmodel with pending usecase updates livedata`() {
        runBlocking {
            //arrange
            val errorMessage = "This is an error message"
            val useCaseResult = Resource.Pending
            coEvery { useCase.invoke() }.returns(useCaseResult)


            //act
            val viewModel = MultipleViewModel(useCase)

            //assert
            val value = viewModel.dataView.value as? MultipleViewVO.Progress
            assert(value is MultipleViewVO.Progress)
        }
    }

    @Test
    fun `test creating viewmodel with error as null usecase updates livedata`() {
        runBlocking {
            //arrange
            val errorMessage = null
            val useCaseResult = Resource.Error(Exception(errorMessage as String?))
            coEvery { useCase.invoke() }.returns(useCaseResult)


            //act
            val viewModel = MultipleViewModel(useCase)

            //assert
            val value = viewModel.dataView.value as? MultipleViewVO.Error
            assert(value != null)
            assert(value?.message == "Something went wrong")
        }
    }

    @After
    fun tearDown() {
    }
}