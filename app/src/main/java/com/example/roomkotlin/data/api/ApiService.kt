package com.example.roomkotlin.data.api

import com.example.roomkotlin.data.model.ProductObject
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("5def7b172f000063008e0aa2")

    fun getCustomers(): Single<ProductObject>
}