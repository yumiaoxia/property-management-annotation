
var requestHandler = {
    url: '',
    data: {},
    success: function (response) {
        console.log(JSON.stringify(response));
    },
    error: function (error) {
        console.log(JSON.stringify(error));
    }
}

function post(requestHandler) {
    $.ajax({
        url: requestHandler.url,
        data: requestHandler.data,
        type: 'POST',
        success: requestHandler.success,
        error: requestHandler.error
    })
}

function get(requestHandler) {
    $.ajax({
        url: requestHandler.url,
        data: requestHandler.data,
        type: 'GET',
        success: requestHandler.success,
        error: requestHandler.error
    })
}

const network = {
    post: post,
    get: get
}

