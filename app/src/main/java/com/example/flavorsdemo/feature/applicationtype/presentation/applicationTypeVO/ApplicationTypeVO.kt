package com.example.flavorsdemo.feature.applicationtype.presentation.applicationTypeVO

import com.example.flavorsdemo.feature.applicationtype.domain.entity.ApplicationTypeEntity

sealed class ApplicationTypeVO {
    data class Error(val message: String) : ApplicationTypeVO()
    object Progress : ApplicationTypeVO()
    data class Loaded(val applicationType: ApplicationTypeEntity) : ApplicationTypeVO()
}
