package com.example.telview.view.albums

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.telview.R
import com.example.telview.databinding.ActivityAlbumDetailBinding
import com.example.telview.viewmodel.albums.AlbumDetailViewModel


class AlbumDetailActivity : AppCompatActivity() {

    private lateinit var albumDetailBinding: ActivityAlbumDetailBinding
    private lateinit var albumDetailViewModel: AlbumDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        albumDetailViewModel = ViewModelProviders.of(this).get(AlbumDetailViewModel::class.java)
        albumDetailBinding =
            DataBindingUtil.setContentView<ActivityAlbumDetailBinding>(this, R.layout.activity_album_detail)
        albumDetailBinding.albumdetailviewmodel = albumDetailViewModel
        albumDetailViewModel.initImage(intent)
    }
}
