package com.bangkit.travellabel.data.api


import com.bangkit.travellabel.data.response.ForumResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiService {
    @GET("/location/:locationId/discussion")
    suspend fun getForum(
//        @Header("Authorization") token: String,
        @Query("location") location : Int = 1,
    ): ForumResponse
}