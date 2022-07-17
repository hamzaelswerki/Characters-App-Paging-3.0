package com.example.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagingation.model.character.Character
import com.example.pagingation.model.character.CharactersPagingDataSource
import kotlinx.coroutines.flow.Flow

class HomeViewModel :ViewModel() {

    val characters2: Flow<PagingData<Character>> =
        Pager(config = PagingConfig(pageSize = 1, prefetchDistance = 2),
            pagingSourceFactory = { CharactersPagingDataSource() }
        ).flow.cachedIn(viewModelScope)
}