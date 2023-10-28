package com.example.zoobereketmarket.data.models.categories

data class CategoriesItemData(
    val id: Int,
    val name: String,
    val description: Any,
    val splash: String,
    val type: String,
    val translate : TranslateData,
    val created_at : Int,
    val updated_at : Int
)
