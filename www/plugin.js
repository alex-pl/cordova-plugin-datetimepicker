var exec = require('cordova/exec');

var PLUGIN_NAME = 'DateTimePicker';

function getTimestampOrNull(date) {
    if (date) {
        if (typeof date === 'object') {
            // convert Date to timestamp
            return date.getTime();
        } else {
            return date;
        }
    }
    return null;
}

// options {
//     type: 'date' | 'time',
//     date: Date | number,
//     minDate: Date | number,
//     maxDate: Date | number
// }
var DateTimePicker = {
    pick: function (options, cb) {
        options.date = getTimestampOrNull(options.date || new Date());
        options.minDate = getTimestampOrNull(options.minDate);
        options.maxDate = getTimestampOrNull(options.maxDate);

        function callback(timestamp) {
            cb(parseInt(timestamp));
        }

        exec(callback, null, PLUGIN_NAME, 'pick', [options]);
    }
};

module.exports = DateTimePicker;
