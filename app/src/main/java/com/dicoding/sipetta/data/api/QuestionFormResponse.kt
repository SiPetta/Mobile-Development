package com.dicoding.sipetta.data.api

import com.google.gson.annotations.SerializedName

data class QuestionFormResponse(

	@field:SerializedName("data")
	val data: List<DataQuestionItem?>? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class DataQuestionItem(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("fv_qcode")
	val fvQcode: String? = null,

	@field:SerializedName("fv_diseasequestion")
	val fvDiseasequestion: String? = null,

	@field:SerializedName("updated_by")
	val updatedBy: Any? = null,

	@field:SerializedName("list_options")
	val listOptions: List<ListOptionsItem?>? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("created_by")
	val createdBy: String? = null
)

data class AgriFarm(

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

data class ListOptionsItem(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("fv_qcode")
	val fvQcode: String? = null,

	@field:SerializedName("fv_agricode")
	val fvAgricode: String? = null,

	@field:SerializedName("updated_by")
	val updatedBy: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("fv_indicatorcode")
	val fvIndicatorcode: String? = null,

	@field:SerializedName("agri_farm")
	val agriFarm: AgriFarm? = null,

	@field:SerializedName("fv_indicatorname")
	val fvIndicatorname: String? = null,

	@field:SerializedName("created_by")
	val createdBy: String? = null
)
