package com.dicoding.sipetta.data.api

import com.google.gson.annotations.SerializedName

data class SignUpResponse(

	@field:SerializedName("password")
	val password: List<String>,

	@field:SerializedName("name")
	val name: List<String>,

	@field:SerializedName("email")
	val email: List<String>,

	@field:SerializedName("error")
	val status: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)
