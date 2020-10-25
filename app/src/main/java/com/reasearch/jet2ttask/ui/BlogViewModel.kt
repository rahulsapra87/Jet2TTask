package com.reasearch.jet2ttask.ui

import Blog
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reasearch.jet2ttask.api.Jet2ApiHandler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlogViewModel : ViewModel() {
     var blogList = MutableLiveData<MutableList<Blog>>()

     private val apiHandler = Jet2ApiHandler()

     private val callback = object : Callback<List<Blog>> {
          override fun onFailure(call: Call<List<Blog>>?, t:Throwable?) {
               Log.e("MainActivity", "Problem calling Github API {${t?.message}}")
          }

          override fun onResponse(call: Call<List<Blog>>?, response: Response<List<Blog>>?) {
               response?.isSuccessful.let {
                    blogList.value = response?.body()?.toMutableList()
               }
          }
     }

     fun getBlogs() {
          apiHandler.getBlogs(callback)
     }


}