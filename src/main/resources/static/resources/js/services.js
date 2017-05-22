materialAdmin

    // =========================================================================
    // 头部消息
    // =========================================================================

    .service('messageService', ['$http', function($http){
        this.getTopNotificationMessage = function(callback) {
            $http({
            	method: 'GET',
            	url: '../zx.msg/messages-notifications'
            }).then(function successCallback(response) {
            	typeof callback == 'function' && callback(response.data)
            }, function errorCallback(response) {
            	console.error(response)
            })
        }
    }])

    // =========================================================================
    // 系统权限相关服务
    // =========================================================================

    .service('permissionService', ['$http', '$resource', function($http, $resource){
    	var _url_prefix = "../tx.permission/";
    	
    	this.getById = function(permissionId) {
            return $resource(_url_prefix + "get-by-id").get({
            	permissionId: permissionId
            });
        }
    	
    	this.getByAll = function(permissionId) {
            return $resource(_url_prefix + "get-all").get();
        }
    	
    	this.save = function(permission, callback) {
            $http({
            	method: 'POST',
            	url: _url_prefix + 'save',
            	data: {
            		permissionName: permission.permissionName,
            		permissionCode: permission.permissionCode,
            		permissionDescript: permission.permissionDescript
            	}
            }).then(function successCallback(response) {
            	typeof callback == 'function' && callback(response.data)
            }, function errorCallback(response) {
            	console.error(response)
            })
        }
    	
    }])
    
    // =========================================================================
    // 滚动
    // =========================================================================
    .service('scrollService', function() {
        var ss = {};
        ss.malihuScroll = function scrollBar(selector, theme, mousewheelaxis) {
            $(selector).mCustomScrollbar({
                theme: theme,
                scrollInertia: 100,
                axis:'yx',
                mouseWheel: {
                    enable: true,
                    axis: mousewheelaxis,
                    preventDefault: true
                }
            });
        }
        
        return ss;
    })


    //==============================================
    // 提醒弹框
    //==============================================

    .service('growlService', function(){
        var gs = {};
        gs.growl = function(message, type) {
            $.growl({
                message: message
            },{
                type: type,
                allow_dismiss: false,
                label: 'Cancel',
                className: 'btn-xs btn-inverse',
                placement: {
                    from: 'top',
                    align: 'right'
                },
                delay: 2500,
                animate: {
                    enter: 'animated bounceIn',
                    exit: 'animated bounceOut'
                },
                offset: {
                    x: 20,
                    y: 85
                }
            });
        }
        return gs;
    })
