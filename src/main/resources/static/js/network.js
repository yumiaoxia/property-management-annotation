
var requestHandler = {
    url: '',
    data: {},
    success: function () {

    },
    error: function () {

    }
}

function post(requestHandler) {
    $.ajax({
        url: requestHandler.url,
        data: requestHandler.data,
        type: 'POST',
        success: function (response) {
            if (response.success) {
                return response.data;
            } else {
                alert(response.message)
            }
            requestHandler.success()
        },
        error: function (error) {
            window.location.href = "../error.page"
        }
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

