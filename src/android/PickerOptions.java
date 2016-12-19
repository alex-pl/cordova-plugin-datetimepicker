package com.alexanderploner.datetimepicker;

import java.io.Serializable;

public class PickerOptions implements Serializable {

    private String type;
    private long date;
    private long minDate;
    private long maxDate;

    public PickerOptions() {
        // empty constructor
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getMinDate() {
        return minDate;
    }

    public void setMinDate(long minDate) {
        this.minDate = minDate;
    }

    public long getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(long maxDate) {
        this.maxDate = maxDate;
    }

}
