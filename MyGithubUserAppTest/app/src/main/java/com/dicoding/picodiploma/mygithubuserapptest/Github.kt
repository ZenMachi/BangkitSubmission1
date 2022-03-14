package com.dicoding.picodiploma.mygithubuserapptest

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Github(
    val name: String,
    val follower: String,
    val repositories: String,
    val avatar: Int,
    val following: String,
    val username: String,
    val location: String,
    val company:String
) : Parcelable
