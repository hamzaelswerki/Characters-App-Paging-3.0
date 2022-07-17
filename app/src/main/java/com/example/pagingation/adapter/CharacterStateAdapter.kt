package com.example.pagingation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingation.databinding.ItemLoadStateFooterBinding

class CharacterStateAdapter(val retry:()->Unit)  :
    LoadStateAdapter<CharacterStateAdapter.CharacterStateViewHolder>() {


    override fun onBindViewHolder(holder: CharacterStateViewHolder, loadState: LoadState) {
            holder.bind(loadState)
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): CharacterStateViewHolder {
        val binding=ItemLoadStateFooterBinding.
        inflate(LayoutInflater.from(parent.context),parent,false)
        return  CharacterStateViewHolder(binding)

        }
    inner class CharacterStateViewHolder(val binding: ItemLoadStateFooterBinding):
        RecyclerView.ViewHolder(binding.root) {

      init {
          binding.retryButton.setOnClickListener { retry.invoke() }

      }
            fun  bind(loadState: LoadState){

                binding.apply {
                    progress.isVisible=loadState is LoadState.Loading
                    retryButton.isVisible=loadState !is LoadState.Loading
                }


            }
        }

}