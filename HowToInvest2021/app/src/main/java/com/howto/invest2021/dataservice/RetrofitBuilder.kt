package com.howto.invest2021.dataservice

import com.howto.invest2021.model.DetailsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val BASE_URL = "http://45.66.164.9:7568/api/"

    private val buildRetrofit: FetchData = Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FetchData::class.java)


    suspend fun requestDetailList(): List<DetailsModel> =
            withContext(Dispatchers.IO) {
                buildRetrofit.getTopic()
            }
}