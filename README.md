# Cordova Plugin DateTimePicker

Native date and time picker for Android.

## Installation

```Shell
cordova plugins add https://github.com/alex-pl/cordova-plugin-datetimepicker.git
```

## Usage

```JavaScript
var options = {
    type: 'date',         // 'date' or 'time', required
    date: new Date(),     // date or timestamp, required
    minDate: new Date(),  // date or timestamp
    maxDate: new Date()   // date or timestamp
};

window.DateTimePicker.pick(options, function (timestamp) {
    window.alert(timestamp);
});
```

## Development

```Shell
# uninstall old version if present
cordova plugins remove cordova-plugin-datetimepicker

# by using --link the Java files are updated instantly (doesn't work for JavaScript)
cordova plugins add --link ../cordova-plugin-datetimepicker

cordova run android --device
```
