package com.reasearch.jet2ttask.ui

import Blog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.reasearch.jet2ttask.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*

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
            Log.d("TAG",it.toString())
            blogAdapter.addBlogs(it)
        })

        if (isNetworkConnected()) {
            for (i in 1..5){
                viewModel.getBlogs()
                viewModel.getBlogsUsingCoroutine()
            }

        } else {
            AlertDialog.Builder(this).setTitle("No Internet Connection")
                .setMessage("Please check your internet connection and try again")
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }
    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    private fun setupBlogList(){
//        linearLayoutManager = LinearLayoutManager(this)
//        binding.rvBlog.layoutManager = linearLayoutManager
//        blogAdapter = BlogAdapter(blogList)
//        binding.rvBlog.adapter = blogAdapter

        // using scope function apply
        binding.rvBlog.apply {
            layoutManager = LinearLayoutManager(this.context)
            blogAdapter = BlogAdapter(blogList)
            adapter = blogAdapter
        }
    }
}