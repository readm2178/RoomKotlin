package com.example.roomkotlin.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EmployeTable")
data class Employee(
    @PrimaryKey
    @ColumnInfo(name = "employeeName") val employeeName: String
)