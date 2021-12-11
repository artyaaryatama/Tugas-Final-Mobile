package com.d121191042artiaaudrianaryatama.tugasfinal.Model

data class DaftarResep(
    val method: String,
    val results: List<result>,
    val status: Boolean
)

data class result(
    val dificulty: String,
    val key: String,
    val portion: String,
    val thumb: String,
    val times: String,
    val title: String
)