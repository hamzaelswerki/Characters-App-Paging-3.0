package com.example.pagingation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.whenCreated
import androidx.paging.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappkotlin.network.ApiClient
import com.example.pagingation.adapter.CharacterAdapter
import com.example.pagingation.adapter.CharacterStateAdapter
import com.example.pagingation.databinding.ActivityMainBinding
import com.example.pagingation.model.character.Character
import com.example.pagingation.model.character.CharactersPagingDataSource
import com.example.viewModel.HomeViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {

    val characterAdapter by lazy {
        CharacterAdapter()
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        observeData()

    }

    private fun observeData() {
        val homeViewModel = HomeViewModel()
        lifecycleScope.launchWhenCreated {
            homeViewModel.characters2.collectLatest { pagingData ->
                characterAdapter.submitData(pagingData)
            }
        }
    }
    private fun initAdapter() {
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = characterAdapter.withLoadStateHeaderAndFooter(
                        header =     CharacterStateAdapter{characterAdapter.retry()},
                        footer =     CharacterStateAdapter{characterAdapter.retry()}
            )
        }
    }
}