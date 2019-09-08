package com.example.telview.view.posts

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.telview.model.PostCommentsDTO
import com.example.telview.viewmodel.posts.PostCommentsListViewModel
import com.example.telview.R
import com.example.telview.databinding.PostCommentsItemBinding
import java.util.*

class PostCommentsAdapter : RecyclerView.Adapter<PostCommentsAdapter.ItemRowHolder>() {

    private lateinit var dataList: ArrayList<PostCommentsDTO>

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemRowHolder {
        val binding: PostCommentsItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.post_comments_item, viewGroup, false
        )
        return ItemRowHolder(binding)
    }

    override fun onBindViewHolder(itemRowHolder: ItemRowHolder, position: Int) {
        itemRowHolder.bind(dataList[position])
    }

    fun updateDataList(list: ArrayList<PostCommentsDTO>) {
        dataList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (::dataList.isInitialized) dataList.size else 0
    }

    inner class ItemRowHolder(val view: PostCommentsItemBinding) : RecyclerView.ViewHolder(view.root) {
        private var postCommentsListViewModel: PostCommentsListViewModel = PostCommentsListViewModel()
        fun bind(data: PostCommentsDTO) {
            postCommentsListViewModel.bind(data)
            view.postcommentlistviewmodel = postCommentsListViewModel
        }
    }
}