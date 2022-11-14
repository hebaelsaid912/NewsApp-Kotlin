package com.hebaelsaid.android.newsapp_kotlin.ui.feature.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hebaelsaid.android.newsapp_kotlin.databinding.NewsFeedListItemBinding
import com.hebaelsaid.android.newsapp_kotlin.domain.model.ui.NewsFeedUiModel

class NewsListAdapter(private val onItemClickListener: NewsListViewHolder.OnItemClickListener): ListAdapter<NewsFeedUiModel, NewsListAdapter.NewsListViewHolder>(ProductsModelDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        return NewsListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(getItem(position),onItemClickListener)
    }

    class ProductsModelDiffCallback : DiffUtil.ItemCallback<NewsFeedUiModel>() {
        override fun areItemsTheSame(oldItem: NewsFeedUiModel, newItem: NewsFeedUiModel): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: NewsFeedUiModel, newItem: NewsFeedUiModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onViewRecycled(holder: NewsListViewHolder) {
        super.onViewRecycled(holder)
        holder.recycle()
    }

    class NewsListViewHolder(binding: NewsFeedListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private var itemRowBinding: NewsFeedListItemBinding = binding
        companion object {
            fun create(parent: ViewGroup): NewsListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NewsFeedListItemBinding.inflate(layoutInflater, parent, false)
                return NewsListViewHolder(binding)
            }
        }
        fun bind(obj: NewsFeedUiModel,onItemClickListener:OnItemClickListener) {
            itemRowBinding.model = obj
            itemRowBinding.executePendingBindings()
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(obj)
            }
        }
        fun recycle() {
            itemView.setOnClickListener(null)
        }
        interface OnItemClickListener {
            fun onItemClick(newsFeedUiModel: NewsFeedUiModel?)
        }
    }

}
