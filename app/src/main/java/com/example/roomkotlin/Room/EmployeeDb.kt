package com.example.roomkotlin.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomkotlin.DAO.EmployeeDao
import com.example.roomkotlin.entity.Employee

@Database(entities = arrayOf(Employee::class), version = 1)
abstract class EmployeeDb : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao
    companion object {
        @Volatile
        private var databseInstance: EmployeeDb? = null

        fun getDatabasenIstance(mContext: Context): EmployeeDb =
            databseInstance ?: synchronized(this) {
                databseInstance ?: buildDatabaseInstance(mContext).also {
                    databseInstance = it
                }
            }

        private fun buildDatabaseInstance(mContext: Context) =
            Room.databaseBuilder(mContext, EmployeeDb::class.java, "employee.db")
                .fallbackToDestructiveMigration()
                .build()

    }
}


//companion object object{
//        private var INSTANCE: EmployeeDb? = null
//        fun getDatabase(context: Context): EmployeeDb? {
//            if (INSTANCE == null) {
//                synchronized(EmployeeDb::class) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.getApplicationContext(),
//                        EmployeeDb::class.java, "employee.db"
//                    ).build()
//                }
//            }
//            return INSTANCE
//        }
//    }
