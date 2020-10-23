package com.reasearch.jet2ttask.ui

import Blog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reasearch.jet2ttask.databinding.ItemBlogBinding

class BlogAdapter(var blogs: List<Blog>) : RecyclerView.Adapter<BlogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val binding = ItemBlogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlogViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return blogs.size
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val blog: Blog? = blogs[position]
        with(holder.itemBlogBinding) {
            tvLikes.text = blog?.likes?.toString()
            tvComments.text = blog?.comments?.toString()
            tvDesignation.text = blog?.user?.get(0)?.designation
            tvName.text = blog?.user?.get(0)?.name
            tvContent.text = blog?.content
            tvTitle.text = blog?.media?.get(0)?.title
            tvUri.text = blog?.media?.get(0)?.url
            if (blog?.media?.get(0)?.image == null) {
                imvArticleMedia.visibility = View.GONE
            }
        }

    }
}