package com.example.flavorsdemo.feature.applicationtype.data.model

import com.example.flavorsdemo.feature.applicationtype.domain.entity.ApplicationTypeEntity

fun ApplicationTypeResponse.toEntity(): ApplicationTypeEntity {
    return ApplicationTypeEntity(
        name = greeting
    )
}