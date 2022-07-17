package com.example.pagingation.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagingation.databinding.ItemCharBinding
import com.example.pagingation.model.character.Character

class CharacterAdapter : PagingDataAdapter
       <Character,CharacterAdapter.CharacterViewHolder>(CharacterComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterViewHolder(
            ItemCharBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }



    inner class CharacterViewHolder(private val binding: ItemCharBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Character) = with(binding) {
            Glide.with(ivAvatar).load(item.image).into(ivAvatar)
            tvName.text=item.name
            tvStatus.text=item.status
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Character, newItem: Character) =
            oldItem == newItem
    }
}