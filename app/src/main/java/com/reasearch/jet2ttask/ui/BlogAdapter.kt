package com.reasearch.jet2ttask.ui

import Blog
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.reasearch.jet2ttask.R
import com.reasearch.jet2ttask.databinding.ItemBlogBinding

class BlogAdapter(var blogs: MutableList<Blog>) : RecyclerView.Adapter<BlogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val binding = ItemBlogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlogViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return blogs.size
    }

    fun addBlogs(list : List<Blog>){
        blogs.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val blog: Blog? = blogs[position]

        with(holder.itemBlogBinding) {
            tvLikes.text = blog?.likes?.toString().plus(" Likes")
            tvComments.text = blog?.comments?.toString().plus(" Comments")
            tvDesignation.text = blog?.user?.get(0)?.designation
            tvName.text = blog?.user?.get(0)?.name
            tvContent.text = blog?.content
            tvTitle.text = blog?.media?.get(0)?.title
            tvUri.text = blog?.media?.get(0)?.url

            if (!TextUtils.isEmpty(blog?.user?.get(0)?.avatar)) {
                loadAvatar(imvAvatar, blog?.user?.get(0)?.avatar)
            }

            if (!TextUtils.isEmpty(blog?.media?.get(0)?.image)) {
                loadArticleMedia(imvArticleMedia, blog?.media?.get(0)?.image)
            }
        }
    }

    private fun loadAvatar(imvAvatar : ImageView, avtarUrl : String?){
        Glide.with(imvAvatar.context)
            .load(avtarUrl)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .override(100, 100).priority(Priority.IMMEDIATE)
            )
            .apply(RequestOptions().circleCrop())
            .into(imvAvatar)
    }

    private fun loadArticleMedia(imvArticleMediar : ImageView, articleMedia : String?){
        Glide.with(imvArticleMediar.context)
            .load(articleMedia)
            .apply(
                RequestOptions().placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .override(300, 300).priority(Priority.IMMEDIATE)
            )
            .apply(RequestOptions.bitmapTransform(RoundedCorners(5)))
            .into(imvArticleMediar)
    }
}