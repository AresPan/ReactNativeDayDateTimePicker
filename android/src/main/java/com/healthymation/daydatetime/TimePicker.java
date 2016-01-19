package com.healthymation.daydatetime;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;

import android.text.format.DateFormat;

public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private ReadableMap mProps;
    private Callback mCallback;
    private boolean isCalled;

    public TimePicker(ReadableMap props, Callback callback) {
        isCalled = false;
        mProps = props;
        mCallback = callback;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        TimePickerDialog picker = new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        picker.setButton(TimePickerDialog.BUTTON_POSITIVE, mProps.getString("ok"), picker);
        picker.setButton(TimePickerDialog.BUTTON_NEGATIVE, mProps.getString("cancel"), picker);

        return picker;
    }

    @Override
    public void onTimeSet(android.widget.TimePicker datePicker, int hour, int minute) {
        if(!isCalled) {
            mCallback.invoke(hour, minute);
        }
        isCalled = true;
    }
}
