package com.sample.gilebeautysalon.api

import com.sample.gilebeautysalon.models.Services
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("challenge-services/")
    suspend fun getServices() : Response<Services>

}