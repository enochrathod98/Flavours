package com.example.flavorsdemo.feature.applicationtype.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.applicationtype.domain.usecase.ApplicationTypeUseCase
import com.example.flavorsdemo.feature.applicationtype.presentation.applicationTypeVO.ApplicationTypeVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApplicationTypeViewModel @Inject constructor(private val applicationTypeUseCase: ApplicationTypeUseCase) :
    ViewModel() {

    val viewType = MutableLiveData<ApplicationTypeVO>(ApplicationTypeVO.Progress)

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val view = when (val resource = applicationTypeUseCase()) {
                is Resource.Error -> ApplicationTypeVO.Error(
                    resource.error.message ?: "Something went wrong"
                )
                Resource.Pending -> ApplicationTypeVO.Progress
                is Resource.Success -> ApplicationTypeVO.Loaded(resource.data)
            }
            Log.e("$$$$", view.toString())

            viewType.postValue(view)
        }
    }
}