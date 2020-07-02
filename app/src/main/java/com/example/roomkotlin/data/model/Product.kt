package com.example.roomkotlin.data.model


data class Product(
    val description: String,
    val href: String,
    val id: String,
    val image: String,
    val images: List<Any>,
    val name: String,
    val options: List<Any>,
    val price: String,
    val product_id: String,
    var quantity: Int,
    val sku: String,
    val special: String,
    val thumb: String,
    val zoom_thumb: String
)