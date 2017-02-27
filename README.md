[![npm version](https://badge.fury.io/js/cordova-plugin-datetimepicker.svg)](https://www.npmjs.com/package/cordova-plugin-datetimepicker)

# Cordova Plugin DateTimePicker

Native date and time picker for Android.

## Installation

```sh
cordova plugins add cordova-plugin-datetimepicker --save
```

## Usage

```js
var options = {
    type: 'date',         // 'date' or 'time', required
    date: new Date(),     // date or timestamp, default: current date
    minDate: new Date(),  // date or timestamp
    maxDate: new Date()   // date or timestamp
};

window.DateTimePicker.pick(options, function (timestamp) {
    window.alert(timestamp);
});
```

## Screenshots

The following screenshots were made on a device with Android 6.0. The plugin uses the default styles of the device it's running on.

<img src="https://alex-pl.github.io/cordova-plugin-datetimepicker/images/screenshot_date.png" alt="Date Picker" width="200px">   <img src="https://alex-pl.github.io/cordova-plugin-datetimepicker/images/screenshot_time.png" alt="Time Picker" width="200px">

## Development

```sh
# uninstall old version if present
cordova plugins remove cordova-plugin-datetimepicker

# by using --link the Java files are updated instantly (doesn't work for JavaScript)
cordova plugins add --link ../cordova-plugin-datetimepicker

cordova run android --device
```
