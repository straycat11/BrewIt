package com.roasloa.brewit.Utilities

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.text.format.DateFormat
import android.widget.TimePicker
import java.util.*
import com.roasloa.brewit.MainActivity
import kotlinx.android.synthetic.main.content_main.*

open class TimePicker : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    var minutes: Int = 0
    var seconds: Int = 0

    var isPicked: Boolean = false




    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current time as the default values for the picker
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        // Create a new instance of TimePickerDialog and return it
        return TimePickerDialog(activity, this, hour, minute, DateFormat.is24HourFormat(activity))

    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        minutes = hourOfDay
        seconds = minute
        isPicked = true
    }


}