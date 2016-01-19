'use strict'

import { NativeModules } from 'react-native'

const DayDateTimePickerAndroid = NativeModules.DayDateTimePickerAndroid

//{ title: "This is a custom title.", ok: "OK", cancel: "Cancel" }

export function showTimePicker(props, callback) {
  if (!props.ok) {
    props.ok = "OK_BUTTON"
  }
  if (!props.cancel) {
    props.cancel = "CANCEL_BUTTON"
  }
  DayDateTimePickerAndroid.showTimePicker(props, callback)
}

export function showDatePicker(props, callback) {
  if (!props.ok) {
    props.ok = "OK_BUTTON"
  }
  if (!props.cancel) {
    props.cancel = "CANCEL_BUTTON"
  }
  DayDateTimePickerAndroid.showDatePicker(props, callback)
}

export function showDayPicker(props, callback) {
  if (!props.title) {
    props.title = "EXAMPLE_TITLE"
  }
  if (!props.ok) {
    props.ok = "OK_BUTTON"
  }
  if (!props.cancel) {
    props.cancel = "CANCEL_BUTTON"
  }
  if (!props.items) {
    props.items = ["EXAMPLE_ITEM"]
  }
  DayDateTimePickerAndroid.showDayPicker(props, callback)
}
