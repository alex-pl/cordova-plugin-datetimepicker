package com.alexanderploner.datetimepicker.picker;

import android.app.DialogFragment;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import java.util.Calendar;

public class BasePickerFragment extends DialogFragment {

    protected final Calendar c = Calendar.getInstance();
    protected CallbackContext callbackContext;

    public void setCallbackContext(CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
    }

    public void sendResult() {
        final PluginResult result = new PluginResult(PluginResult.Status.OK, String.valueOf(c.getTimeInMillis()));
        callbackContext.sendPluginResult(result);
    }

}
