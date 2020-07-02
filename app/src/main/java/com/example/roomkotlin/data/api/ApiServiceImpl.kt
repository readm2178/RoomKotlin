package com.example.roomkotlin.data.api

import com.example.roomkotlin.data.model.ProductObject
import io.reactivex.Single

class ApiServiceImpl : ApiService {
    private val apiService2 = RetrofitInstance.createService2(ApiService::class.java)

    override fun getCustomers(): Single<ProductObject> {
        return apiService2.getCustomers();
    }
}