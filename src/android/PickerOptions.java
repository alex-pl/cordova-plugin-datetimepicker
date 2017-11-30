package com.alexanderploner.datetimepicker;

import java.io.Serializable;

public class PickerOptions implements Serializable {

    private String type;
    private long date;
    private Long minDate;
    private Long maxDate;

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

    public Long getMinDate() {
        return minDate;
    }

    public void setMinDate(Long minDate) {
        this.minDate = minDate;
    }

    public Long getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Long maxDate) {
        this.maxDate = maxDate;
    }

}
