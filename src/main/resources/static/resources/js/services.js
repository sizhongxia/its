materialAdmin
    
    // =========================================================================
    // 滚动
    // =========================================================================
    .service('scrollService', function() {
        return {
        	malihuScroll : function scrollBar(selector, theme, mousewheelaxis) {
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
        };
    })


    //==============================================
    // 提醒弹框
    //==============================================

    .service('swalService', function(){
    	return {
    		// 提示警告弹框
    		alert : function(message) {
        		swal({
                    title: "提示",
                    text: message,
                    type: "warning",
                    showConfirmButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "关闭"
                });
        	},
    		// 提示错误弹框
    		error : function(message) {
        		swal({
                    title: "提示",
                    text: message,
                    type: "error",
                    showConfirmButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "关闭"
                });
        	},
        	// 操作成功弹框
        	success : function(message) {
        		swal({
                    title: "提示",
                    text: message,
                    type: "success",
                    showConfirmButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "关闭"
                });
        	},
        	// 弹出确认框
        	confirm : function(message, confirmCallback) {
        		swal({
                    title: "确认？",
                    text: message,
                    type: "warning",
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "确认",
                    showCancelButton: true,
                    cancelButtonText: "取消",
                    closeOnConfirm: false
                }, function(){
                	typeof confirmCallback === 'function' && confirmCallback();
                });
        	},
        	// 右上角提示弹框 TYPE:[inverse, info, success, warning, danger]
        	growl : function(message, type) {
        		$.growl({
                    message: message
                },{
                    type: type || 'inverse',
            		z_index: 1068,
            		allow_dismiss: true,
                    delay: 2500,
                    className: 'btn-xs btn-inverse',
                    animate: {
                        enter: 'animated bounceIn'
                    },
                    offset: {
                        x: 20,
                        y: 85
                    }
                });
        	}
    	};
    })
    
    // =========================================================================
    // 网络请求相关服务
    // =========================================================================
    .service('httpService', ['$http', '$resource', 'swalService', function($http, $resource, swalService){
    	var errCallback = function(response) {
          	console.info(response);
         	var msg = "请求数据失败，如果一直出现，请联系管理员";
         	if(response.data && response.data.status) {
         		swalService.error(msg + "（错误代码：" + response.data.status + "）");
         	} else {
         		swalService.error(msg);
         	}
        }
    	return {
    		get : function(url, data, callback) {
        		$http({
                 	method: "GET",
                 	url: url,
                 	params: data
                 }).then(function (response) {
                	if(response.data && response.data.status > 0) {
                      	console.info("GET:"+url+"#"+JSON.stringify(data), response);
             			swalService.growl(response.data.msg + " （错误代码：" + response.data.status + "）", "danger")
             		} else {
             			typeof callback == 'function' && callback(response.data)
             		}
                 }, errCallback)
    		}, 
    		post : function(url, data, callback) {
    			$http({
                 	method: "POST",
                 	url: url,
                 	data: data
                 }).then(function (response) {
                	if(response.data && response.data.status > 0) {
                      	console.info("POST:"+url+"#"+JSON.stringify(data), response);
             			swalService.growl(response.data.msg + " （错误代码：" + response.data.status + "）", "danger")
             		} else {
             			typeof callback == 'function' && callback(response.data)
             		}
                 }, errCallback)
    		}
    	};
    }])

    // =========================================================================
    // 头部消息
    // =========================================================================

    .service('messageService', ['httpService', function(httpService){
        return {
        	getTopNotificationMessage : function(callback) {
        		httpService.get('../zx.msg/messages-notifications', {}, callback)
	        }
        }
    }])

    // =========================================================================
    // 系统权限相关服务
    // =========================================================================

    .service('permissionService', ['httpService', function(httpService){
    	var _url_prefix = "../tx.permission/";
    	return {
    		// 分页获取权限字
            getByPage : function(page, perPage, callback) {
                httpService.get(_url_prefix + "get-by-page", {
                	page: page || 1,
                	perPage: perPage || 20
                }, callback);
            },
    		// 通过ID获取权限字
    		getById : function(permissionId, callback) {
                httpService.get(_url_prefix + "get-by-id", {
                	permissionId: permissionId
                }, callback);
            },
    		// 保存权限字
            save : function(permission, callback) {
            	httpService.post(_url_prefix + 'save', {
            		permissionName: permission.permissionName,
            		permissionCode: permission.permissionCode,
            		permissionDescript: permission.permissionDescript
                }, callback);
            },
    		// 修改权限字
            update : function(permission, callback) {
            	httpService.post(_url_prefix + 'update', {
            		permissionId: permission.permissionId,
            		permissionName: permission.permissionName,
            		permissionCode: permission.permissionCode,
            		permissionDescript: permission.permissionDescript
                }, callback);
            },
    		// 删除权限字
            remove : function(permissionId, callback) {
            	httpService.post(_url_prefix + 'delete', {
            		permissionId: permissionId
                }, callback);
            }
    	};
    }])
    
    .service('menuService', ['httpService', function(httpService){
    	var _url_prefix = "../tx.menu/";
    	return {
    		// 获取所有菜单
            getAll : function(callback) {
                httpService.get(_url_prefix + "get-all", {}, callback);
            },
    		// 获取所有父级菜单
            getParentMenus : function(callback) {
                httpService.get(_url_prefix + "get-parent-menus", {}, callback);
            },
    		// 通过ID获取菜单
    		getById : function(menuId, callback) {
                httpService.get(_url_prefix + "get-by-id", {
                	menuId: menuId
                }, callback);
            },
    		// 保存菜单
            save : function(menu, callback) {
            	httpService.post(_url_prefix + 'save', {
            		menuPid: menu.menuPid,
            		menuName: menu.menuName,
            		menuSerialNumber: menu.menuSerialNumber,
            		menuIcon: menu.menuIcon,
            		menuPrefix: menu.menuPrefix,
            		menuUiSref: menu.menuUiSref,
            		menuStatus: menu.menuStatus
                }, callback);
            },
    		// 修改菜单
            update : function(menu, callback) {
            	httpService.post(_url_prefix + 'update', {
            		menuId: menu.menuId,
            		menuPid: menu.menuPid,
            		menuName: menu.menuName,
            		menuSerialNumber: menu.menuSerialNumber,
            		menuIcon: menu.menuIcon,
            		menuPrefix: menu.menuPrefix,
            		menuUiSref: menu.menuUiSref,
            		menuStatus: menu.menuStatus
                }, callback);
            },
    		// 删除菜单
            remove : function(menuId, callback) {
            	httpService.post(_url_prefix + 'delete', {
            		menuId: menuId
                }, callback);
            }
    	};
    }])