package com.healthymation.daydatetime;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;

public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private ReadableMap mProps;
    private Callback mCallback;
    private boolean isCalled;

    public DatePicker(ReadableMap props, Callback callback) {
        isCalled = false;
        mProps = props;
        mCallback = callback;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog picker = new DatePickerDialog(getActivity(), this, year, month, day);
        picker.setButton(DatePickerDialog.BUTTON_POSITIVE, mProps.getString("ok"), picker);
        picker.setButton(DatePickerDialog.BUTTON_NEGATIVE, mProps.getString("cancel"), picker);

        return picker;
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
        if(!isCalled) {
            mCallback.invoke(year, month, day);
        }
        isCalled = true;
    }
}
