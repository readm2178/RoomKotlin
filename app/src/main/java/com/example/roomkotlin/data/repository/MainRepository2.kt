package com.example.roomkotlin.data.repository

import com.example.roomkotlin.data.api.ApiHelper
import com.example.roomkotlin.data.model.ProductObject
import io.reactivex.Single

class MainRepository2(private val apiHelper: ApiHelper) {

    fun getCustomers(): Single<ProductObject> {
        return apiHelper.getCustomers()
    }

}