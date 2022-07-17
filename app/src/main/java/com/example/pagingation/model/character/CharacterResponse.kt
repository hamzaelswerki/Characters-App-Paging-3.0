package com.example.pagingation.model.character

data class CharacterResponse(
        val pagePageInfo: PageInfo,
        val results: List<Character>
)