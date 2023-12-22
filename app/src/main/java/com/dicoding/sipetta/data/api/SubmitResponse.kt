package com.dicoding.sipetta.data.api

import com.google.gson.annotations.SerializedName

data class SubmitResponse(

	@field:SerializedName("data")
	val data: List<DataSubmitItem?>? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class DataSubmitItem(

	@field:SerializedName("fv_result_similiarity")
	val fvResultSimiliarity: Any? = null,

	@field:SerializedName("fc_replierid")
	val fcReplierid: Any? = null,

	@field:SerializedName("fv_agricode")
	val fvAgricode: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("expertise")
	val expertise: Any? = null,

	@field:SerializedName("fc_repliedstatus")
	val fcRepliedstatus: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("fc_issuedescription")
	val fcIssuedescription: String? = null,

	@field:SerializedName("fc_issuetitle")
	val fcIssuetitle: String? = null,

	@field:SerializedName("fc_issueid")
	val fcIssueid: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("fd_issuereleasedate")
	val fdIssuereleasedate: String? = null,

	@field:SerializedName("fv_result_systempakar")
	val fvResultSystempakar: String? = null,

	@field:SerializedName("fc_userid")
	val fcUserid: String? = null,

	@field:SerializedName("ft_useranswer")
	val ftUseranswer: String? = null,

	@field:SerializedName("user")
	val user: DataUser? = null
)

data class DataUser(

	@field:SerializedName("fc_role")
	val fcRole: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("email_verified_at")
	val emailVerifiedAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)
