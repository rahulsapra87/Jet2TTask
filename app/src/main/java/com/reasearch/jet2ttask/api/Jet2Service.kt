package com.reasearch.jet2ttask.api

import Blog
import retrofit2.Call
import retrofit2.http.GET

interface Jet2Service {

    @GET("/jet2/api/v1/blogs?page=1&limit=10")
    fun searchBlogs(): Call<List<Blog>>
}