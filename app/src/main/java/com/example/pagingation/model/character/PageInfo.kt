package com.example.pagingation.model.character

data class PageInfo(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String
)