package com.example.flavorsdemo.feature.userlist.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("users")
	val users: List<UsersItem>
)

data class UsersItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("status")
	val status: Status
)
