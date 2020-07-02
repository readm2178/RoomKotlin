package com.example.roomkotlin.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomkotlin.data.api.ApiHelper
import com.example.roomkotlin.data.repository.MainRepository2
import com.example.roomkotlin.ui.main.viewmodel.MainViewModel2

class ViewModelFactory2  (private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel2::class.java)) {
            return MainViewModel2(MainRepository2(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}