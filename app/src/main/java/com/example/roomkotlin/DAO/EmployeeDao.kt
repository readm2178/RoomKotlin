package com.example.roomkotlin.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomkotlin.entity.Employee

@Dao

interface EmployeeDao {
    @Insert
    fun insert(employee : Employee)
    @Query("SELECT * FROM EmployeTable ORDER BY employeeName ASC")
    fun getAllEmployee():List<Employee>
    @Query("DELETE FROM EmployeTable")
    fun delAll()



}