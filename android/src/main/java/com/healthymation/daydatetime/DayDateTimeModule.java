package com.healthymation.daydatetime;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;

import java.util.Map;
import java.util.HashMap;

import android.app.DialogFragment;
import android.app.Activity;

public class DayDateTimeModule extends ReactContextBaseJavaModule {
  private Activity mActivity = null;

  public DayDateTimeModule(ReactApplicationContext reactContext, Activity activity) {
    super(reactContext);
    mActivity = activity;
  }

  @Override
  public String getName() {
    return "DayDateTimePickerAndroid";
  }

  @ReactMethod
  public void showDayPicker(ReadableMap props, Callback callback) {
    DialogFragment dayDialog = new DayPicker(props, callback);
    dayDialog.show(mActivity.getFragmentManager(), "dayPicker");
  }

  @ReactMethod
  public void showDatePicker(ReadableMap props, Callback callback) {
    DialogFragment dateDialog = new DatePicker(props, callback);
    dateDialog.show(mActivity.getFragmentManager(), "datePicker");
  }

  @ReactMethod
  public void showTimePicker(ReadableMap props, Callback callback) {
    DialogFragment dateDialog = new TimePicker(props, callback);
    dateDialog.show(mActivity.getFragmentManager(), "timePicker");
  }
}
