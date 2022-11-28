package com.example.cbcnewsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cbcnewsapp.R
import com.example.cbcnewsapp.models.NewsResponse
import com.example.cbcnewsapp.models.NewsResponseItem
import com.example.cbcnewsapp.ui.loadUrl
import com.example.cbcnewsapp.util.Resource

class NewsAdapter(private val newsResponseItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsResponseItemViewHolder>() {

    private var newsResponseItem: List<NewsResponseItem> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsResponseItemViewHolder {
        return NewsResponseItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsResponseItemViewHolder, position: Int) {
        holder.bind(newsResponseItem[position])
    }

    override fun getItemCount() = newsResponseItem.size

    fun submitList(newList: List<NewsResponseItem>) {
        newsResponseItem = newList
        notifyDataSetChanged()
    }

    class NewsResponseItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val headline = itemView.findViewById<TextView>(R.id.tvTitle)
        private val description_item = itemView.findViewById<TextView>(R.id.tvDescription)
        private val publishedate = itemView.findViewById<TextView>(R.id.tvPublishedAt)
        private val images_news = itemView.findViewById<ImageView>(R.id.ivArticleImage)


        fun bind(newsResponseItem: NewsResponseItem) {
            with(newsResponseItem) {
                headline.text = title
                description_item.text = description
                publishedate.text = publishedAt.toString()
                images.let { images_news.loadUrl(it.square_140) }
            }
        }

    }
}
