package com.example.roomkotlin.viewmodel


import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.roomkotlin.Room.EmployeeDb
import com.example.roomkotlin.entity.Employee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()
    //DB instance
    private var dataBaseInstance: EmployeeDb?= null
    //implement Entity class in to the MutableLiveData
    var employeeList = MutableLiveData<List<Employee>>()



    fun setInstanceOfDb(dataBaseInstance: EmployeeDb) {
        this.dataBaseInstance = dataBaseInstance

}
//    fun saveDataIntoDb(data: Employee){
//
//        dataBaseInstance?.employeeDao()?.insert(data)
//            ?.subscribeOn(Schedulers.io())
//            ?.observeOn(AndroidSchedulers.mainThread())
//            ?.subscribe({
//            }, {
//
//            })?.let {
//                compositeDisposable.add()
//            }
//    }
}