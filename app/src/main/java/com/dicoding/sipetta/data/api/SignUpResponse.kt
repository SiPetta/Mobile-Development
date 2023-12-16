package com.dicoding.sipetta.data.api

import com.google.gson.annotations.SerializedName

data class SignUpResponse(

	@field:SerializedName("access_token")
	val accessToken: String? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("token_type")
	val tokenType: String? = null,

	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class Data(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)
