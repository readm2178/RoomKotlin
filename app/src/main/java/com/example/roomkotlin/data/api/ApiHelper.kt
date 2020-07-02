package com.example.roomkotlin.data.api

class ApiHelper(private val apiService: ApiService) {
    fun getCustomers()=apiService.getCustomers()
}