package com.howto.invest2021.dataservice

import com.howto.invest2021.model.DetailsModel
import retrofit2.Response
import retrofit2.http.GET

interface FetchData {

    @GET("monkeymaking")
    suspend fun getTopic(): List<DetailsModel>
}