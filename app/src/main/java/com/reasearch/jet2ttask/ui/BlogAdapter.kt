package com.reasearch.jet2ttask.ui

import Blog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reasearch.jet2ttask.databinding.ItemBlogBinding

class BlogAdapter(private val blogs : List<Blog>) : RecyclerView.Adapter<BlogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val binding = ItemBlogBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return BlogViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return blogs.size
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val blog : Blog? = blogs[position]
        holder.itemBlogBinding.tvLikes.text = blog?.likes?.toString()
        holder.itemBlogBinding.tvComments.text = blog?.comments?.toString()
        holder.itemBlogBinding.tvDesignation.text = blog?.user?.get(0)?.designation
        holder.itemBlogBinding.tvName.text = blog?.user?.get(0)?.name
        holder.itemBlogBinding.tvContent.text = blog?.content
        holder.itemBlogBinding.tvTitle.text = blog?.media?.get(0)?.title
        holder.itemBlogBinding.tvUri.text = blog?.media?.get(0)?.url
        if(blog?.media?.get(0)?.image == null){
            holder.itemBlogBinding.imvArticleMedia.visibility = View.GONE
        }
    }
}