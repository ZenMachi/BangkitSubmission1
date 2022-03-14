package com.dicoding.picodiploma.mygithubuserapptest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.mygithubuserapptest.databinding.ItemRowGithubsBinding

class ListGithubAdapter(private val listGithub: ArrayList<Github>) : RecyclerView.Adapter<ListGithubAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemRowGithubsBinding) :RecyclerView.ViewHolder(binding.root)
    private lateinit var onItemClickCallback: OnItemCallback

    fun setOnItemCallback(onItemClickCallback: OnItemCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemCallback {
        fun onItemClicked(data: Github)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowGithubsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, follower, repository, avatar) = listGithub[position]
        holder.binding.imgItemPhoto.setImageResource(avatar)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemFollowers.text = follower
        holder.binding.tvItemRepositories.text = repository
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listGithub[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listGithub.size
}