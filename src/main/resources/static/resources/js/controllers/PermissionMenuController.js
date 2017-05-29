materialAdmin
// 菜单
.controller('menuCtrl', ['$scope', 'menuService', '$q', '$uibModal', 'ngTreetableParams', 'swalService', function($scope, menuService, $q, $uibModal, ngTreetableParams, swalService) {
	// 菜单列表
	$scope.table = {
		headers: ['菜单名称', '菜单图标', '前缀地址', '访问地址', '排序序号', '启用状态', '操作']
	};
	
	$scope.menuTreeTable = new ngTreetableParams({
        getNodes: function(parent) {
        	if(!parent) {
	        	var deferred = $q.defer();
	            menuService.getAll(function(resource){
	    			if(resource.status === 0) {
	    				deferred.resolve(resource.data);
	    			}
	    		});
	            return deferred.promise;
        	}
        	if(parent.children && parent.children.length > 0) {
        		return parent.children;
        	}
        	return [];
        },
        getTemplate: function(node) {
            return 'menu_tree_node.html';
        },
        options: {
        	// 展开节点
        	onNodeExpand: function() {},
        	// 默认展开
        	initialState: 'expanded'
        }
    });
	
	// 打开新增菜单页面
	$scope.open_create_window = function() {
		var $modalInstance = $uibModal.open({
            animation: true,
            templateUrl: '../template/form-system-menu.html',
            controller: 'menuCreateCtrl',
            backdrop: 'static',
            keyboard: true
        });
		$modalInstance.result.then(function (obj) {
			obj && $scope.menuTreeTable.refresh();
		});
	}
	
	// 打开编辑页面
	$scope.open_change_window = function(menuId) {
		var $modalInstance = $uibModal.open({
            animation: true,
            templateUrl: '../template/form-system-menu.html',
            controller: 'menuChangeCtrl',
            backdrop: 'static',
            keyboard: true,
            resolve: {
                menuId: function () {
                    return menuId;
                }
            }
        });
		$modalInstance.result.then(function (obj) {
			if(obj) {
				$scope.menuTreeTable.refresh();
			}
		});
	}
	
	$scope.del_it = function(menuId, menuName){
		swalService.confirm("确认要删除菜单：" + menuName + " 吗？", function(){
			menuService.remove(menuId, function(resource){
				if(resource.status === 0) {
					$scope.menuTreeTable.refresh();
					swalService.success("已成功删除 [" + menuName + "] 菜单。");
					return;
				}
			});
        });
	}
}])

// 新增菜单
.controller('menuCreateCtrl', ['$scope', 'menuService', '$uibModalInstance', 'swalService', 
	function($scope, menuService, $uibModalInstance, swalService) {
	$scope.title = "新增";
	$scope.menu = {};
	$scope.parentMenus = [];
	menuService.getParentMenus(function(resource){
		if(resource.status === 0) {
			$scope.parentMenus = resource.data;
		}
	});

	$scope.icons = ['airplane', 'album', 'archive', 'label', 'lamp', 'landscape', 'layers', 'library', 'mail-reply-all', 'screen-rotation', 'search', 'seat', 'settings', 'ticket-star', 'toll', 'toys', 'traffic', 'translate', 'wrench'];
	
	$scope.close = function() {
		$uibModalInstance.close(false);
	}
	// 表单错误信息处理
	function initErrorMsg(){
		$scope.formError = {
			menuName : '',
			menuIcon : '',
			menuPrefix : '',
			menuUiSref : '',
			menuSerialNumber : ''
		}
	}
	// 初始化表单错误提示
	initErrorMsg();
	// 提交表单处理
	$scope.submit = function() {
		initErrorMsg();
		var hasError = false;
		if(!$scope.menu.menuName) {
			hasError = true;
			$scope.formError.menuName = '请输入菜单名称';
		}
		if(!$scope.menu.menuIcon) {
			hasError = true;
			$scope.formError.menuIcon = '请选择一个菜单图标';
		}
		if(!$scope.menu.menuPrefix) {
			hasError = true;
			$scope.formError.menuPrefix = '请输入菜单前缀';
		}
		if(!$scope.menu.menuUiSref) {
			hasError = true;
			$scope.formError.menuUiSref = '请输入菜单路径';
		}
		if(!$scope.menu.menuSerialNumber) {
			hasError = true;
			$scope.formError.menuSerialNumber = '请输入菜单排序编号';
		}
		!hasError && menuService.save($scope.menu, function(response) {
			if(response.status === 0) {
				$scope.menu = {};
				$uibModalInstance.close(response.data);
				swalService.success("保存菜单成功");
			} else {
				swalService.growl(response.msg + "（错误代码：" + response.status + "）");
			}
		})
	}
}])

// 修改菜单
.controller('menuChangeCtrl', ['$scope', '$timeout', '$uibModalInstance', 'menuService', 'swalService', 'menuId',
	function($scope, $timeout, $uibModalInstance, menuService, swalService, menuId) {
	$scope.title = "修改";
	$scope.menu = {};
	$scope.parentMenus = [];
	menuService.getParentMenus(function(resource){
		if(resource.status === 0) {
			$scope.parentMenus = resource.data;
		}
	});
	
	$scope.icons = ['airplane', 'album', 'archive', 'label', 'lamp', 'landscape', 'layers', 'library', 'mail-reply-all', 'screen-rotation', 'search', 'seat', 'settings', 'ticket-star', 'toll', 'toys', 'traffic', 'translate', 'wrench'];
	
	$scope.close = function() {
		$uibModalInstance.close(false);
	}
	
	// 表单错误信息处理
	function initErrorMsg(){
		$scope.formError = {
			menuName : '',
			menuIcon : '',
			menuPrefix : '',
			menuUiSref : '',
			menuSerialNumber : ''
		}
	}
	// 初始化表单错误提示
	initErrorMsg();
	
	if(menuId) {
		menuService.getById(menuId, function(resource){
			if(resource.status === 0) {
				$scope.menu = resource.data;
			}
		});
		$scope.submit = function() {
			initErrorMsg();
			var hasError = false;
			if(!$scope.menu.menuId) {
				$timeout(function(){
					$uibModalInstance.close(false);
				})
				swalService.error("无效的表单数据");
				return;
			}
			if(!$scope.menu.menuName) {
				hasError = true;
				$scope.formError.menuName = '请输入菜单名称';
			}
			if(!$scope.menu.menuIcon) {
				hasError = true;
				$scope.formError.menuIcon = '请选择一个菜单图标';
			}
			if(!$scope.menu.menuPrefix) {
				hasError = true;
				$scope.formError.menuPrefix = '请输入菜单前缀';
			}
			if(!$scope.menu.menuUiSref) {
				hasError = true;
				$scope.formError.menuUiSref = '请输入菜单路径';
			}
			if(!$scope.menu.menuSerialNumber) {
				hasError = true;
				$scope.formError.menuSerialNumber = '请输入菜单排序编号';
			}
			!hasError && menuService.update($scope.menu, function(response){
				if(response.status === 0) {
					$uibModalInstance.close(response.data);
					swalService.success("修改菜单成功");
				} else {
					swalService.alert(response.msg + "（错误代码：" + response.status + "）");
				}
			});
		}
	} else {
		$timeout(function(){
			$uibModalInstance.close(false);
		})
		swalService.error("无效的菜单ID");
		return;
	}
}])