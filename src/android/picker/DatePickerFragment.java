package com.alexanderploner.datetimepicker.picker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import com.alexanderploner.datetimepicker.PickerOptions;

import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends BasePickerFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        PickerOptions options = (PickerOptions) getArguments().getSerializable("options");

        Date date = new Date();
        date.setTime(options.getDate());
        c.setTime(date);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);
        DatePicker datePicker = datePickerDialog.getDatePicker();
        if (options.getMinDate() != null) {
            datePicker.setMinDate(options.getMinDate());
        }
        if (options.getMaxDate() != null) {
            datePicker.setMaxDate(options.getMaxDate());
        }
        return datePickerDialog;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        sendResult();
    }

}
