package com.example.flavorsdemo.feature.multipleview.presentation.multipleviewVO.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.multipleview.domain.usecase.MultipleViewUseCase
import com.example.flavorsdemo.feature.multipleview.presentation.multipleviewVO.MultipleViewVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MultipleViewModel @Inject constructor(val useCase: MultipleViewUseCase) : ViewModel() {
    val dataView = MutableLiveData<MultipleViewVO>(MultipleViewVO.Progress)

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {

            val view = when (val resource = useCase()) {
                is Resource.Error -> MultipleViewVO.Error(
                    resource.error.message ?: "Something went wrong"
                )
                Resource.Pending -> MultipleViewVO.Progress
                is Resource.Success -> MultipleViewVO.Loaded(resource.data)
            }
            dataView.postValue(view)
        }
    }
}