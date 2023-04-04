package com.example.flavorsdemo.feature.userlist.presentation.userVO.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.userlist.domain.usecase.UserUseCase
import com.example.flavorsdemo.feature.userlist.presentation.userVO.UserVo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {

    val userView = MutableLiveData<UserVo>(UserVo.Progress)

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {

            val view = when (val resource = userUseCase()) {
                is Resource.Error -> UserVo.Error(resource.error.message ?: "Something went wrong")
                Resource.Pending -> UserVo.Progress
                is Resource.Success -> UserVo.Loaded(resource.data)
            }
            userView.postValue(view)
        }
    }
}