const api = require("./api");
var app = getApp();

//获取缓存值方法 
function GetStorage(keyRequestHandler) {
    keyRequest(keyRequestHandler)
}

var keyRequestHandler = {
    success: function (res) {
    },
    fail: function () {
    },
}

function keyRequest(keyRequestHandler) {
    wx.getStorage({
        key: "access_token",
        success: function (res) {
            keyRequestHandler.success(res)
            console.log("获取storage值成功")
        },
        fail: function (res) {
            keyRequestHandler.fail(res)
            console.log("获取storage值失败" + res.errMsg)
        }
    })
}

var requestHandler = {
    params: {},
    url: api,
    notShowLoading: false,
    success: function (res) {
        console.log("请求数据成功返回", res)
    },
    fail: function (res) {
        console.log("请求数据失败返回", res)
    },
}

//GET请求  
function GET(requestHandler) {
    request('GET', requestHandler)
}

//POST请求
function POST(requestHandler) {
    request('POST', requestHandler)
}

function request(method, requestHandler) {
    var params = requestHandler.params;
    var url = requestHandler.url;
    //access_token值获取
    GetStorage({
        success: function (res) {
            console.log("本地存储access_token值获取成功", res)
            if (!requestHandler.notShowLoading) {
                wx.showLoading({
                    title: '加载中',
                    mask: true
                })
            }
            wx.request({
                url: url,
                data: params,
                header: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + res.data,
                },
                method: method, // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
                // header: {}, // 设置请求的 header
                success: function (res) {
                    console.log(res);
                    if (res.statusCode == "200") {
                        if (res.data.code == "0") {
                            if (requestHandler.success) {
                                requestHandler.success(res)
                            }
                        } else if (res.data.code == "0003") {
                            const pages = getCurrentPages();
                            const currentPage = pages[pages.length - 1]
                            //用户登录被踢，需要重新登录
                            console.log("用户被踢，需要重新登录");
                            wx.clearStorage({
                                key: 'access_token',
                                success: function (res) {
                                    wx.redirectTo({
                                        url: '/pages/login/login?from=' + currentPage.route + '&ops=' + JSON.stringify(currentPage.options),
                                    })
                                },
                            })
                        } else {
                            if (requestHandler.fail) {
                                requestHandler.fail(res)
                            } else {
                                console.log("接口异常", res)
                                wx.showModal({
                                    title: '温馨提醒',
                                    content: res.data.message,
                                    showCancel: false,
                                })
                            }
                        }
                    } else {
                        if (requestHandler.fail) {
                            requestHandler.fail(res)
                        } else {
                            console.log("网络异常", res)
                            wx.showModal({
                                title: '温馨提醒',
                                content: '系统出错，请联系管理员',
                                showCancel: false,
                            })
                        }
                    }
                },
                fail: function (res) {
                    if (requestHandler.fail) {
                        requestHandler.fail(res)
                    } else {
                        // wx.getNetworkType({
                        //   success: function (res) {
                        //     console.log("返回网络类型", res.networkType)
                        //     // 返回网络类型, 有效值：
                        //     // wifi/2g/3g/4g/unknown(Android下不常见的网络类型)/none(无网络)
                        //     let networkType = res.networkType;
                        //     if (networkType == 'none' || networkType == 'unknown') {
                        //       wx.navigateTo({
                        //         url: '../noNet/noNet',
                        //       })
                        //     } else {
                        //       console.log("网络异常", res)
                        //       wx.showModal({
                        //         title: '温馨提醒',
                        //         content: res.errMsg,
                        //         showCancel: false,
                        //       })
                        //     }
                        //   }
                        // })

                    }
                },
                complete: function (res) {
                    if (!requestHandler.notShowLoading) {
                        wx.hideLoading()
                    }
                    if (requestHandler.complete) {
                        requestHandler.complete(res)
                    }
                }
            })
        },
        fail: res => {
            console.log("本地存储access_token值获取失败", res)
            wx.redirectTo({
                url: '/pages/login/login',
            })
        }
    });
}

function chooseImageAndUpload(requestHandler) {
    wx.chooseImage({
        count: 1,
        sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
        success: function (res) {
            // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
            var tempFilesSize = res.tempFiles[0].size;
            if (tempFilesSize <= 2000000) {
                var tempFilePaths = res.tempFilePaths
                requestHandler.filePath = tempFilePaths[0]
                requestHandler.fileType = 'image'
                uploadFile(requestHandler)
            } else {
                wx.showToast({
                    title: '上传图片不能大于2M!', // 标题
                });
            }
        }
    })
}

function uploadFile(requestHandler) {
    var fileType = requestHandler.fileType;
    var filePath = requestHandler.filePath;
    var url = api.uploadFile;
    //access_token值获取
    GetStorage({
        success: function (res) {
            console.log("本地存储access_token值获取成功", res)
            if (!requestHandler.notShowLoading) {
                wx.showLoading({
                    title: '上传中',
                    mask: true
                })
            }
            wx.uploadFile({
                url: url,
                filePath: filePath,
                name: 'file',
                formData: {
                    'fileType': fileType
                },
                header: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + res.data,
                },
                success: function (res) {
                    if (res.statusCode == "200") {
                        var response = JSON.parse(res.data);
                        if (response.code == "0") {
                            if (requestHandler.success) {
                                response.wxFilePath = filePath
                                requestHandler.success(response)
                            }
                        } else {
                            if (requestHandler.fail) {
                                requestHandler.fail(response)
                            } else {
                                console.log("接口异常", response)
                                wx.showModal({
                                    title: '温馨提醒',
                                    content: response.message,
                                    showCancel: false,
                                })
                            }
                        }
                    } else {
                        if (requestHandler.fail) {
                            requestHandler.fail(res)
                        } else {
                            console.log("网络异常", res)
                            wx.showModal({
                                title: '温馨提醒',
                                content: '系统繁忙，请稍候再试',
                                showCancel: false,
                            })
                        }
                    }
                },
                fail: function (res) {
                    if (requestHandler.fail) {
                        requestHandler.fail(res)
                    } else {
                        console.log("网络异常", res)
                        wx.showModal({
                            title: '温馨提醒',
                            content: res.errMsg,
                            showCancel: false,
                        })

                    }
                },
                complete: function (res) {
                    if (!requestHandler.notShowLoading) {
                        wx.hideLoading()
                    }
                    if (requestHandler.complete) {
                        requestHandler.complete(res)
                    }
                }
            })
        },
        fail: res => {
            console.log("本地存储access_token值获取失败", res)
        }
    });
}

//  获取token值
function getToken(requestHandler) {
    wx.request({
        url: api.getToken,
        method: 'POST',
        data: {
            'grant_type': 'miniprogram_code',
            'ex_fmt': 'daoben',
            'code': requestHandler.code, //发送code到后台接口，获取access_token
            'encryptedData': requestHandler.encryptedData,
            'iv': requestHandler.iv,
            'userType': requestHandler.userType,
            'formId': requestHandler.formId,
        },
        header: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        success: res => {
            console.log("请求获取token接口返回成功", res)
            if (res.data.code == "0") {
                var access_token = res.data.data.access_token;
                var uid = res.data.data.uid;
                // 把access_token保存到本地存储中
                wx.setStorage({
                    key: "access_token",
                    data: access_token
                });
                // 把uid保存到本地存储中
                wx.setStorage({
                    key: "uid",
                    data: uid
                })
                if (requestHandler && requestHandler.success) {
                    requestHandler.success(res)
                }
            } else {
                wx.showModal({
                    title: '温馨提醒',
                    content: res.data.message,
                    showCancel: false,
                })
            }
        },
        fail: res => {
            console.log("请求获取token接口返回失败", res)
            wx.showModal({
                title: '温馨提醒',
                content: '系统异常，请与管理员联系',
                showCancel: false,
            })
        },
        complete: function (res) {
            if (!requestHandler.notShowLoading) {
                wx.hideLoading()
            }
            if (requestHandler.complete) {
                requestHandler.complete(res)
            }
        }
    })
}

// 保存formId
function saveFormId(formId) {
    POST({
        params: {
            "data": {
                "formId": formId
            }
        },
        url: api.formId,
        success: (res) => {
            console.log("成功保存一个 formId:" + formId)
        }
    })
}

function stopPullDown(startTime, minDelay) {
    if (!minDelay || minDelay < 0) {
        minDelay = 1500
    }
    var usedTime = new Date() - startTime
    var delay = 0
    if (usedTime < minDelay) {
        delay = minDelay - usedTime
    }
    setTimeout(function () {
        wx.stopPullDownRefresh()
    }, delay)
}

module.exports = {
    API: api,
    GET: GET,
    POST: POST,
    UPLOAD_FILE: uploadFile,
    CHOOSE_IMAGE_UPLOAD: chooseImageAndUpload,
    GetStorage: GetStorage,
    getToken: getToken,
    stopPullDown: stopPullDown,
    saveFormId: saveFormId
}