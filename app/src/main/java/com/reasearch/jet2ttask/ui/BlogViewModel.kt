package com.reasearch.jet2ttask.ui

import Blog
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlogViewModel : ViewModel() {
     var blogList = MutableLiveData<List<Blog>>()



}