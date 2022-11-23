package com.example.cbcnewsapp.adapters

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cbcnewsapp.R
import com.example.cbcnewsapp.models.MainContent
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.MainContentViewHolder>() {

    inner class MainContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<MainContent>() {
        override fun areItemsTheSame(oldItem: MainContent, newItem: MainContent): Boolean {
            return oldItem.sourceId == newItem.sourceId
        }

        override fun areContentsTheSame(oldItem: MainContent, newItem: MainContent): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainContentViewHolder {
        return MainContentViewHolder(
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

    override fun onBindViewHolder(holder: MainContentViewHolder, position: Int) {
        val mainContent = differ.currentList[position]
        holder.itemView.apply {

            tvSource.text = mainContent.source.toString()
            tvTitle.text = mainContent.title
            tvDescription.text = mainContent.description
            tvPublishedAt.text = mainContent.readablePublishedAt
            setOnClickListener {
                onItemClickListener?.let { it(mainContent) }
            }

        }
    }

    private var onItemClickListener: ((MainContent) -> Unit)? = null

    fun setOnItemClickListener(listener: (MainContent) -> Unit) {
        onItemClickListener = listener
    }
}