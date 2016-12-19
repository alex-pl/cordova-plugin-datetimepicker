package com.alexanderploner.datetimepicker.picker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import com.alexanderploner.datetimepicker.PickerOptions;

import java.util.Calendar;
import java.util.Date;

public class TimePickerFragment extends BasePickerFragment
        implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        PickerOptions options = (PickerOptions) getArguments().getSerializable("options");

        Date date = new Date();
        date.setTime(options.getDate());
        c.setTime(date);

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        sendResult();
    }

}
