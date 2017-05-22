materialAdmin

// 权限字
.controller('permissionCtrl', [ 'permissionService', function(permissionService) {
	var _this = this;
	// 获取所有权限字数据
	_this.permissions = permissionService.getByAll();

	_this.permission = {};

	function initErrorMsg(){
		_this.formError = {
			permissionName : '',
			permissionCode : '',
			permissionDescript : ''
		}
	}

	// 初始化表单错误提示
	initErrorMsg();
	
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
				swal("完成", "保存权限字成功", "success"); 
			} else {
				swal({
                    title: "错误",
                    text: response.msg + "（错误代码：" + response.status + "）",
                    showConfirmButton: true
                });
			}
		})
	}
}])
