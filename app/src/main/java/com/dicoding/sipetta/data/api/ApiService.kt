package com.dicoding.sipetta.data.api

import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun register (
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): SignUpResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("user")
    suspend fun getDetailUser(
        @Header("Authorization") token: String,
    ): DetailUserResponse

    @GET("form-farm-issue")
    suspend fun getListFarm(
        @Header("Authorization") token: String,
        @Query("fvAgricode") fvAgricode: String
    ): DetailAllAgriResponse

    @GET("form-farm-issue/question/{agricode}")
    suspend fun getQuestionListFarm(
        @Header("Authorization") token: String,
        @Path("agricode") agricode: String
    ): QuestionFormResponse

}