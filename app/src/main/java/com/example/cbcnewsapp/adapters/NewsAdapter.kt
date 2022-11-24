package com.example.cbcnewsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cbcnewsapp.R
import com.example.cbcnewsapp.models.NewsResponseItem
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsResponseItemViewHolder>() {

    inner class NewsResponseItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<NewsResponseItem>() {
        override fun areItemsTheSame(
            oldItem: NewsResponseItem,
            newItem: NewsResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NewsResponseItem,
            newItem: NewsResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }
    // AsynchronousList differ will run in the background

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsResponseItemViewHolder {
        return NewsResponseItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NewsResponseItemViewHolder, position: Int) {
        val newsResponseItem = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(newsResponseItem.images).into(ivArticleImage)
            tvSource.text = newsResponseItem.source
            tvTitle.text = newsResponseItem.title
            tvDescription.text = newsResponseItem.description
            tvPublishedAt.text = newsResponseItem.readablePublishedAt
            setOnClickListener {
                onItemClickListener?.let { it(newsResponseItem) }
            }

        }
    }

    private var onItemClickListener: ((NewsResponseItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (NewsResponseItem) -> Unit) {
        onItemClickListener = listener
    }


}