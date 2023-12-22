package com.dicoding.sipetta.data.api

import com.google.gson.annotations.SerializedName

data class DetailAllAgriResponse(

	@field:SerializedName("data")
	val data: List<DataListItem?>? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class DataListItem(

	@field:SerializedName("fv_agriname")
	val fvAgriname: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("fv_agricode")
	val fvAgricode: String? = null,

	@field:SerializedName("updated_by")
	val updatedBy: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("created_by")
	val createdBy: String? = null
)
