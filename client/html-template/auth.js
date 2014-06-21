/**
 * Created by Crabar on 22.05.2014.
 */
var _action;

function initOAuthIO() {
    OAuth.initialize('w5lnaZLTxqd0EeBl99PrcUK3UBo');
}

function socialLogin(provider, action) {
    _action = action;
    OAuth.popup(provider, getProfile);
}

function onSuccessGetProfile(result) {
    document.${application}.onSocialLogin(result);
}

function getProfile(error, result) {
    result.get(_action).done(onSuccessGetProfile);
}

function sendRequest(method, address, queryParams, bodyParams, headers, expectedStatus, requestID) {
    var xmlhttp = new XMLHttpRequest();
    var target;

    if (queryParams != null)
        target = address + '?' + queryParams;
    else
        target = address;

    xmlhttp.open(method, target, true);

    if (headers != null) {
        for (var i = 0; i < headers.length; i++) {
            if (headers[i] != null)
                xmlhttp.setRequestHeader(headers[i].name, headers[i].value);
        }
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == expectedStatus) {
                document.${application}.onRequestComplete(xmlhttp.responseText, requestID);
            }
            else if (xmlhttp.status == 401) {
                document.${application}.processAuth(xmlhttp.getResponseHeader('WWW-Authenticate'), address, requestID);
            }
            else {
                document.${application}.onError(xmlhttp.responseText);
            }
        }
    };

    xmlhttp.send(bodyParams);
}