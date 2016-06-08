/**
 * Created by user on 08.06.2016.
 */
function showAlert(response) {
    showSimpleAlert(response.data.success, response.data.message);
}

function showSimpleAlert(success, message) {
    if (success) {
        $('#alert_div').append(
            '<div class="alert alert-success alert-dismissable">' +
            '<button type="button" class="close" ' +
            'data-dismiss="alert" aria-hidden="true">' +
            '&times;' +
            '</button>' +
            message +
            '</div>');
    } else {
        $('#alert_div').append(
            '<div class="alert alert-danger alert-dismissable">' +
            '<button type="button" class="close" ' +
            'data-dismiss="alert" aria-hidden="true">' +
            '&times;' +
            '</button>' +
            '<strong>Ошибка!</strong>   ' +
            message +
            '</div>');
    }
}

function isInteger(x) {
    return !!(Math.floor(x) == x && $.isNumeric(x));
}

function isFilled(str){
    return str.replace(/^\s+/g, '').length;
}

function isEmpty(str) {
    return str == null ? true : !str.replace(/^\s+/g, '').length;
}

function isValidFloat(x, min, max) {
    if (x == null) return false;
    if (typeof x === 'string') {
        if (isEmpty(x)) return false;
        var num = Number(x);
        if (num == 'NaN') return false;
        if (min != null) {
            if (num < min) return false;
        }
        if (max != null) {
            if (num > max) return false;
        }
    } else {
        if (min != null) {
            if (x < min) return false;
        }
        if (max != null) {
            if (x > max) return false;
        }
    }
    return true;
}

function isValidInt(x, min, max) {
    if (x == null) return false;
    if (typeof x === 'string') {
        if (isEmpty(x)) return false;
        var num = Number(x);
        if (num == 'NaN') return false;
        if (!isInteger(num)) return false;
        if (min != null) {
            if (num < min) return false;
        }
        if (max != null) {
            if (num > max) return false;
        }
    } else {
        if (!isInteger(x)) return false;
        if (min != null) {
            if (x < min) return false;
        }
        if (max != null) {
            if (x > max) return false;
        }
    }
    return true;
}