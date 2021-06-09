package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttondatepicker.setOnClickListener {view->
            clickDatePicker(view)
             }


    }

    fun clickDatePicker(view: View?) {
        val myCalender=Calendar.getInstance()
        val year =myCalender.get(Calendar.YEAR)
        val month =myCalender.get(Calendar.MONTH)
        val day= myCalender.get(Calendar.DAY_OF_MONTH)

      val dpd=  DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedyear, selectedmonth, selecteddayOfMonth ->

            val selectedDate="$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
            tvselecteddate.setText(selectedDate)

            val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate=sdf.parse(selectedDate)

            var selectedDateInMinutes=theDate!!.time/60000
            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
            var CurrentdateInMinutes=currentDate!!.time/60000

            val differenceInMinutes=CurrentdateInMinutes-selectedDateInMinutes

            tvageinminutes.setText(differenceInMinutes.toString())
        }
            ,year
            ,month
            ,day)

        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()
    }

}