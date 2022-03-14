package com.dicoding.picodiploma.mygithubuserapptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dicoding.picodiploma.mygithubuserapptest.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val github = intent.getParcelableExtra<Github>(EXTRA_GITHUB) as Github
        Log.d("Detail Data", github.name)

        val name = github.name
        val following = github.following
        val follower = github.follower
        val username = github.username
        val avatar = github.avatar
        val repository = github.repositories
        val location = github.location
        val company = github.company


        binding.imgItemPhoto.setImageResource(avatar)
        binding.tvItemName.text = name
        binding.tvItemFollowing.text = following
        binding.tvItemFollowers.text = follower
        binding.tvItemUsername.text = username
        binding.tvItemRepositories.text = repository
        binding.tvItemCompany.text = company
        binding.tvItemLocation.text = location
    }
    companion object {
        const val EXTRA_GITHUB = "extra_github"
    }
}