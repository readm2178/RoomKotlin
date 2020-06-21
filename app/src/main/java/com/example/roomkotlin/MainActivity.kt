package com.example.roomkotlin

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.roomkotlin.Room.EmployeeDb
import com.example.roomkotlin.entity.Employee
import com.example.roomkotlin.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Attributes
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {


    private var employeeDb: EmployeeDb? = null
    private var viewModel: MainViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        var dataBaseInstance = EmployeeDb.getDatabasenIstance(this)
        viewModel?.setInstanceOfDb(dataBaseInstance)

        btnSave.setOnClickListener {
            if (!etEnterText.text.toString().isEmpty()) {

                val employeeobj = Employee(etEnterText.text.toString())
                var employeeDetails = (employeeobj)
//                viewModel?.saveDataIntoDb(employeeDetails)


//                InsertTask(this, employeeobj).execute()
            }
        }
        btnDisplay.setOnClickListener {
            tvDatafromDb.setText("")
            GetDataFromDb(this).execute()
        }
        btnDelAll.setOnClickListener {
            deleteAll(this).execute()
        }
    }


    private class InsertTask(var context: MainActivity, var employee: Employee) :
        AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean {
            context.employeeDb!!.employeeDao().insert(employee)
            return true
        }

        override fun onPostExecute(bool: Boolean?) {
            if (bool!!) {
                Toast.makeText(context, "Added to Database", Toast.LENGTH_LONG).show()
            }
        }
    }

    private class GetDataFromDb(var context: MainActivity) :
        AsyncTask<Void, Void, List<Employee>>() {
        override fun doInBackground(vararg params: Void?): List<Employee> {
            return context.employeeDb!!.employeeDao().getAllEmployee()
        }

        override fun onPostExecute(employeelist: List<Employee>?) {
            if (employeelist!!.size > 0) {
                context.tvDatafromDb.setText("")
                for (i in 0..employeelist.size - 1) {
                    context.tvDatafromDb.append(employeelist[i].employeeName)
                }
            } else {
                Toast.makeText(context, " Database Empty", Toast.LENGTH_LONG).show()

            }
        }
    }

    private class deleteAll(var context: MainActivity) :
        AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean {
            context.employeeDb!!.employeeDao().delAll()
//            Toast.makeText(context, " Database deleted", Toast.LENGTH_LONG).show()
            return true
        }

    }


}