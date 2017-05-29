materialAdmin
// 权限字
.controller('permissionCtrl', ['permissionService', '$uibModal', 'swalService', function(permissionService, $uibModal, swalService) {
	var _this = this;
	// 权限字列表
	_this.table = {
		headers: ['#', '权限字名称', '权限字代码', '权限字描述', '操作'],
		perPages: [10, 20, 50, 100],
		datas: [],
		totalItems: 0,
		currentPage: 1,
		perPage: 10
	}
	_this.changePage = function(){
		loadPermissionWdDatas();
	}
	_this.changePerPage = function(perPage){
		if(_this.table.perPage !== perPage) {
			_this.table.perPage = perPage;
			loadPermissionWdDatas();
		}
	}
	// 获取所有权限字数据
	function loadPermissionWdDatas() {
		permissionService.getByPage(_this.table.currentPage, _this.table.perPage, function(resource){
			if(resource.status === 0) {
				_this.table.datas = resource.data.list;
				_this.table.totalItems = resource.data.totalItems;
			}
		});
	}
	loadPermissionWdDatas();
	// 打开新增权限字页面
	_this.open_create_window = function() {
		var $modalInstance = $uibModal.open({
            animation: true,
            templateUrl: '../template/form-permission-dictionary.html',
            controller: 'permissionCreateCtrl',
            backdrop: 'static',
            keyboard: true
        });
		$modalInstance.result.then(function (obj) {
			obj && loadPermissionWdDatas();
		});
	}
	
	// 打开编辑页面
	_this.open_change_window = function(permissionId) {
		var $modalInstance = $uibModal.open({
            animation: true,
            templateUrl: '../template/form-permission-dictionary.html',
            controller: 'permissionChangeCtrl',
            backdrop: 'static',
            keyboard: true,
            resolve: {
                permissionId: function () {
                    return permissionId;
                }
            }
        });
		$modalInstance.result.then(function (obj) {
			if(obj) {
				angular.forEach(_this.table.datas, function(value, key) {
					  if(value.permissionId === obj.permissionId) {
						  _this.table.datas[key] = obj;
					  }
				});
			}
		});
	}
	
	_this.del_it = function(permissionId, permissionName){
		swalService.confirm("确认要删除权限字：" + permissionName + " 吗？", function(){
			permissionService.remove(permissionId, function(resource){
				if(resource.status === 0) {
					loadPermissionWdDatas();
					swalService.success("已成功删除 [" + permissionName + "] 权限字。");
					return;
				}
			});
        });
	}
}])

// 新增权限字
.controller('permissionCreateCtrl', ['$scope', 'permissionService', '$uibModalInstance', 'swalService', 
	function($scope, permissionService, $uibModalInstance, swalService) {
	$scope.title = "新增";
	$scope.permission = {};
	$scope.close = function() {
		$uibModalInstance.close(false);
	}
	// 表单错误信息处理
	function initErrorMsg(){
		$scope.formError = {
			permissionName : '',
			permissionCode : '',
			permissionDescript : ''
		}
	}
	// 初始化表单错误提示
	initErrorMsg();
	// 提交表单处理
	$scope.submit = function() {
		initErrorMsg();
		var hasError = false;
		if(!$scope.permission.permissionName) {
			hasError = true;
			$scope.formError.permissionName = '请输入权限字名称';
		}
		if(!$scope.permission.permissionCode) {
			hasError = true;
			$scope.formError.permissionCode = '请输入权限字代码';
		}
		if(!$scope.permission.permissionDescript) {
			hasError = true;
			$scope.formError.permissionDescript = '请输入权限字描述';
		}
		!hasError && permissionService.save($scope.permission, function(response) {
			if(response.status === 0) {
				$scope.permission = {};
				$uibModalInstance.close(response.data);
				swalService.success("保存权限字成功");
			} else {
				swalService.growl(response.msg + "（错误代码：" + response.status + "）");
			}
		})
	}
}])

// 修改权限字
.controller('permissionChangeCtrl', ['$scope', '$timeout', '$uibModalInstance', 'permissionService', 'swalService', 'permissionId',
	function($scope, $timeout, $uibModalInstance, permissionService, swalService, permissionId) {
	$scope.title = "修改";
	$scope.permission = {};
	
	$scope.close = function() {
		$uibModalInstance.close(false);
	}
	
	// 表单错误信息处理
	function initErrorMsg(){
		$scope.formError = {
			permissionName : '',
			permissionCode : '',
			permissionDescript : ''
		}
	}
	// 初始化表单错误提示
	initErrorMsg();
	
	if(permissionId) {
		permissionService.getById(permissionId, function(resource){
			if(resource.status === 0) {
				$scope.permission = resource.data;
			}
		});
		$scope.submit = function() {
			initErrorMsg();
			var hasError = false;
			if(!$scope.permission.permissionId) {
				$timeout(function(){
					$uibModalInstance.close(false);
				})
				swalService.error("无效的表单数据");
				return;
			}
			if(!$scope.permission.permissionName) {
				hasError = true;
				$scope.formError.permissionName = '请输入权限字名称';
			}
			if(!$scope.permission.permissionCode) {
				hasError = true;
				$scope.formError.permissionCode = '请输入权限字代码';
			}
			if(!$scope.permission.permissionDescript) {
				hasError = true;
				$scope.formError.permissionDescript = '请输入权限字描述';
			}
			!hasError && permissionService.update($scope.permission, function(response){
				if(response.status === 0) {
					$uibModalInstance.close(response.data);
					swalService.success("修改权限字成功");
				} else {
					swalService.alert(response.msg + "（错误代码：" + response.status + "）");
				}
			});
		}
	} else {
		$timeout(function(){
			$uibModalInstance.close(false);
		})
		swalService.error("无效的权限字ID");
		return;
	}
}])