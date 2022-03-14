package com.dicoding.picodiploma.mygithubuserapptest

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvGithubs: RecyclerView
    private val list = ArrayList<Github>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGithubs = findViewById(R.id.rv_githubs)
        rvGithubs.setHasFixedSize(true)

        list.addAll(listGithubs)
        showRecyclerList()
    }

    private val listGithubs: ArrayList<Github>
    get() {
        val dataName = resources.getStringArray(R.array.name)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataRepositories = resources.getStringArray(R.array.repository)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataUsernames = resources.getStringArray(R.array.username)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataCompany = resources.getStringArray(R.array.company)
        val listGithub = ArrayList<Github>()
        for(i in dataName.indices) {
            val github = Github(dataName[i], dataFollowers[i] + " Followers",dataRepositories[i] + " Repository", dataPhoto.getResourceId(i, -1), dataFollowing[i] + " Following", dataUsernames[i], dataLocation[i], dataCompany[i])
            listGithub.add(github)
        }
        return listGithub
    }

    private fun showSelectedGithub(github: Github) {
        val detailActivityIntent = Intent(this@MainActivity, DetailActivity::class.java)
        detailActivityIntent.putExtra(DetailActivity.EXTRA_GITHUB, github)
        startActivity(detailActivityIntent)
    }
    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvGithubs.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvGithubs.layoutManager = LinearLayoutManager(this)
        }
        val listGithubAdapter = ListGithubAdapter(list)
        rvGithubs.adapter = listGithubAdapter

        listGithubAdapter.setOnItemCallback(object : ListGithubAdapter.OnItemCallback {
            override fun onItemClicked(data: Github) {
                showSelectedGithub(data)
            }
        })
    }
}