package com.example.telview.viewmodel.posts

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.telview.model.PostDTO
import com.example.telview.model.Users

class PostListViewModel : ViewModel() {

    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()
    private val postByUser = MutableLiveData<String>()

    fun bind(post: PostDTO) {
        postTitle.value = post.title
        postBody.value = post.body
        postByUser.value = "- by " + Users.getUsername(post.userId!!).toString()
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }

    fun getPostByUser(): MutableLiveData<String> {
        return postByUser
    }
}