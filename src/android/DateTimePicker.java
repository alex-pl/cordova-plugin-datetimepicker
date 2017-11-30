package com.alexanderploner.datetimepicker;

import android.os.Bundle;
import android.util.Log;

import com.alexanderploner.datetimepicker.picker.DatePickerFragment;
import com.alexanderploner.datetimepicker.picker.TimePickerFragment;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DateTimePicker extends CordovaPlugin {

    private static final String TAG = DateTimePicker.class.getSimpleName();

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("pick")) {
            PickerOptions pickerOptions = parseOptions(args);

            if ("date".equals(pickerOptions.getType())) {
                selectDate(pickerOptions, callbackContext);
            } else if ("time".equals(pickerOptions.getType())) {
                selectTime(pickerOptions, callbackContext);
            } else {
                Log.e(TAG, "picker type doesn't exist");
            }
        }
        return true;
    }

    private PickerOptions parseOptions(JSONArray args) {
        PickerOptions pickerOptions = new PickerOptions();
        JSONObject json = null;

        try {
            json = args.getJSONObject(0);
            pickerOptions.setType(json.getString("type"));
            pickerOptions.setDate(json.getLong("date"));
        } catch (JSONException e) {
            Log.e(TAG, "couldn't parse picker options");
        }

        if (json != null) {
            try {
                pickerOptions.setMinDate(json.getLong("minDate"));
            } catch (JSONException e) {
                pickerOptions.setMinDate(null);
            }

            try {
                pickerOptions.setMaxDate(json.getLong("maxDate"));
            } catch (JSONException e) {
                pickerOptions.setMaxDate(null);
            }
        }

        return pickerOptions;
    }

    private void selectTime(PickerOptions options, CallbackContext callbackContext) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("options", options);

        TimePickerFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.setArguments(bundle);
        timePickerFragment.setCallbackContext(callbackContext);
        timePickerFragment.show(cordova.getActivity().getFragmentManager(), "timePicker");
    }

    private void selectDate(PickerOptions options, CallbackContext callbackContext) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("options", options);

        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setArguments(bundle);
        datePickerFragment.setCallbackContext(callbackContext);
        datePickerFragment.show(cordova.getActivity().getFragmentManager(), "datePicker");
    }

}
