materialAdmin

// 权限字
.controller('permissionCtrl', ['$state', '$stateParams', '$location', 'permissionService', 'swalService', 'ngTableParams', 
	function($state, $stateParams, $location, permissionService, swalService, ngTableParams) {
	
	var _this = this;
	var path = $location.path();
	
	// 权限字列表
	if(path === "/system/system-permission-wd") {
		// 获取所有权限字数据
		permissionService.getByAll(function(resource){
			if(resource.status === 0) {
				_this.permissions = resource.data
				_this.datatable = new ngTableParams({
		            page: 1,
		            count: 10
		        }, {
		            total: _this.permissions.length,
		            getData: function ($defer, params) {
		            	var list = _this.permissions.slice((params.page() - 1) * params.count(), params.page() * params.count());
		            	if(list.length === 0 && params.page() > 1) {
		            		params.page(params.page() - 1);
		            		list = _this.permissions.slice((params.page() - 1) * params.count(), params.page() * params.count());
		            	}
	            		$defer.resolve(list);
		            }
		        })
			}
		});

		// 跳转至编辑页面
		_this.to_edit = function(permissionId) {
			$state.go('system.permission-wd-change', {permissionId: encodeURIComponent(permissionId)});
		}
		
		_this.del_it = function(permissionId, permissionName){
			swalService.confirm("确认要删除权限字：" + permissionName + " 吗？", function(){
				permissionService.remove(permissionId, function(resource){
					if(resource.status === 0) {
						angular.forEach(_this.datatable.data, function(value, key) {
							  if(value.permissionId === permissionId){
								  _this.permissions.splice(key, 1);
								  _this.datatable.reload();
								  swalService.success("已成功删除 [" + permissionName + "] 权限字。");
								  return;
							  }
						});
					}
				});
	        });
		}
		return;
	}
	
	_this.permission = {};

	if(path.indexOf("/system/system-permission-wd-") > -1) {
		function initErrorMsg(){
			_this.formError = {
				permissionName : '',
				permissionCode : '',
				permissionDescript : ''
			}
		}
		// 初始化表单错误提示
		initErrorMsg();
		// 修改权限字
		if(path.indexOf("/system/system-permission-wd-change") > -1) {
			if($stateParams.permissionId) {
				var permissionId = '';
				try {
					permissionId = decodeURIComponent($stateParams.permissionId);
				} catch (e) {
					console.info(e);
					swalService.error("无效的权限字ID");
					return;
				}
				permissionService.getById(permissionId, function(resource){
					if(resource.status === 0) {
						_this.permission = resource.data
					}
				})
				_this.update = function() {
					initErrorMsg();
					var hasError = false;
					if(!_this.permission.permissionId) {
						swalService.error("无效的表单数据");
						return;
					}
					if(!_this.permission.permissionName) {
						hasError = true;
						_this.formError.permissionName = '请输入权限字名称';
					}
					if(!_this.permission.permissionCode) {
						hasError = true;
						_this.formError.permissionCode = '请输入权限字名称';
					}
					if(!_this.permission.permissionDescript) {
						hasError = true;
						_this.formError.permissionDescript = '请输入权限字名称';
					}
					!hasError && permissionService.update(_this.permission, function(response){
						if(response.status === 0) {
							swalService.success("修改权限字成功");
							$state.go('system.permission-wd');
						} else {
							swalService.alert(response.msg + "（错误代码：" + response.status + "）");
						}
					})
				}
			} else {
				swalService.error("无效的权限字ID");
				return;
			}
		} else {
			_this.save = function() {
				initErrorMsg();
				var hasError = false;
				if(!_this.permission.permissionName) {
					hasError = true;
					_this.formError.permissionName = '请输入权限字名称';
				}
				if(!_this.permission.permissionCode) {
					hasError = true;
					_this.formError.permissionCode = '请输入权限字名称';
				}
				if(!_this.permission.permissionDescript) {
					hasError = true;
					_this.formError.permissionDescript = '请输入权限字名称';
				}
				!hasError && permissionService.save(_this.permission, function(response){
					if(response.status === 0) {
						_this.permission = {};
						swalService.success("保存权限字成功"); 
					} else {
						swalService.alert(response.msg + "（错误代码：" + response.status + "）");
					}
				})
			}
		}
	}
	
}])
