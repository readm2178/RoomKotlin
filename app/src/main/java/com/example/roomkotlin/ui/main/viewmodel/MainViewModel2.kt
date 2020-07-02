package com.example.roomkotlin.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomkotlin.data.model.ProductObject
import com.example.roomkotlin.data.repository.MainRepository2
import com.example.roomkotlin.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel2(private val mainRepository2: MainRepository2) : ViewModel() {

    private val customers = MutableLiveData<Resource<ProductObject>>()


    private val compositeDisposable = CompositeDisposable()

    fun fetchCustomers() {
        customers.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository2.getCustomers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ customerslist ->
                    customers.postValue(Resource.success(customerslist))
                }, {
                    customers.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getCustomers(): MutableLiveData<Resource<ProductObject>> {
        return customers
    }

}