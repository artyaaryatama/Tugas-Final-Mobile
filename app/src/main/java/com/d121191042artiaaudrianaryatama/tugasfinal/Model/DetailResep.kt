package com.d121191042artiaaudrianaryatama.tugasfinal.Model

data class DetailResep(
    val method: String,
    val results: results,
    val status: Boolean
)

data class results(
    val author: Author,
    val desc: String,
    val dificulty: String,
    val ingredient: List<String>,
    val needItem: List<NeedItem>,
    val servings: String,
    val step: List<String>,
    val thumb: String,
    val times: String,
    val title: String
)

data class Author(
    val datePublished: String,
    val user: String
)

data class NeedItem(
    val item_name: String,
    val thumb_item: String
)