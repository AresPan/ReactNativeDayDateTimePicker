package com.healthymation.daydatetime;

import com.healthymation.daydatetime.R;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.DialogFragment;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.Spinner;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableArray;

public class DayPicker extends DialogFragment {

  private ReadableMap mProps;
  private Callback mCallback;
  private boolean isCalled;
  private int selectedIndex;

  public DayPicker(ReadableMap props, Callback callback) {
      isCalled = false;
      mProps = props;
      mCallback = callback;
      selectedIndex = -1;
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {

      ReadableArray rItems = mProps.getArray("items");
      final CharSequence[] items = new CharSequence[rItems.size()];
      for (int i = 0; i < rItems.size(); i++) {
        items[i] = rItems.getString(i);
      }

      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      builder.setTitle(mProps.getString("title"));
      builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
          selectedIndex = which;
        }
      });
      builder.setPositiveButton(mProps.getString("ok"), new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
          if(!isCalled) {
              mCallback.invoke(selectedIndex);
          }
          isCalled = true;
        }
      });
      builder.setNegativeButton(mProps.getString("cancel"), new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {

        }
      });

      return builder.create();
  }
}
