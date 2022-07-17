package com.example.pagingation.model.character

import android.net.Uri
import androidx.paging.PagingSource
import com.example.movieappkotlin.network.ApiClient

class CharactersPagingDataSource() :
        PagingSource<Int, Character>() {


    override suspend fun load(params: LoadParams<Int>):LoadResult<Int, Character> {

        return try {
            val currentPage = params.key ?: 1
            val response = ApiClient.getClient().getAllCharacters(currentPage)
            val responseData = mutableListOf<Character>()
            val data = response.body()?.results ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                    data = responseData,
                    prevKey = if (currentPage == 1) null else -1,
                    nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}