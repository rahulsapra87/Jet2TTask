package com.reasearch.jet2ttask.api

import Blog
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Jet2ApiHandler {
    private val service: Jet2Service

    companion object {
        const val BASE_URL = "https://5e99a9b1bc561b0016af3540.mockapi.io/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(Jet2Service::class.java)
    }

    fun getBlogs(callback: Callback<List<Blog>>) { //5
        val call = service.searchBlogs()
        call.enqueue(callback)
    }
}
