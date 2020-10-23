package com.reasearch.jet2ttask.ui

import Blog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.reasearch.jet2ttask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding : ActivityMainBinding
    private var blogList  = ArrayList<Blog>()
    private lateinit var blogAdapter: BlogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupBlogList()

        val viewModel = ViewModelProvider(this)[BlogViewModel::class.java]
        viewModel.blogList.observe(this,  Observer {
            blogAdapter.blogs = it
        })
    }

    private fun setupBlogList(){
        linearLayoutManager = LinearLayoutManager(this)
        binding.rvBlog.layoutManager = linearLayoutManager
        blogAdapter = BlogAdapter(blogList)
        binding.rvBlog.adapter = blogAdapter
    }
}