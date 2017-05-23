materialAdmin
    // =========================================================================
    // 后台主框架
    // =========================================================================

    .controller('materialadminCtrl', function($timeout, $state, $scope, swalService){
    	var _this = this;
        // 欢迎消息
        // swalService.growl('欢迎使用后台管理系统2')
        
        
        // 检测是否是移动端浏览器
        if( /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {
           angular.element('html').addClass('ismobile');
        }

        // 是否隐藏左右sidebar（侧边）
        _this.sidebarToggle = {
            left: false,
            right: false
        }

        // 读取左侧sidebar开启状态
        _this.layoutType = localStorage.getItem('ma-layout-status');
        
        // 主菜单激活状态
        _this.$state = $state;
        
        //点击关闭左侧sidebar
        _this.sidebarStat = function(event) {
            if (!angular.element(event.target).parent().hasClass('active')) {
                _this.sidebarToggle.left = false;
            }
        }

        // 默认主题皮肤色
        _this.currentSkin = 'green';

        _this.skinList = [
            'lightblue',
            'bluegray',
            'cyan',
            'teal',
            'green',
            'orange',
            'blue',
            'purple'
        ]

        // 皮肤切换
        _this.skinSwitch = function (color) {
            _this.currentSkin = color;
        }
    
    })


    // =========================================================================
    // 头部信息
    // =========================================================================
    .controller('headerCtrl', function($timeout, messageService){
    	var _this = this;
        // 点击打开搜索
    	_this.openSearch = function(){
            angular.element('#header').addClass('search-toggled');
            angular.element('#top-search-wrap').find('input').focus();
        }
        // 关闭搜索
    	_this.closeSearch = function(){
            angular.element('#header').removeClass('search-toggled');
        }
    	_this.messageResult = [];
        // 获取头部通知消息
        messageService.getTopNotificationMessage(function(response) {
        	_this.messageResult = response
        });
        
        // 清除通知消息
        _this.clearNotification = function($event) {
            $event.preventDefault();
            
            var x = angular.element($event.target).closest('.listview');
            var y = x.find('.lv-item');
            var z = y.size();
            
            angular.element($event.target).parent().fadeOut();
            
            x.find('.list-group').prepend('<i class="grid-loading hide-it"></i>');
            x.find('.grid-loading').fadeIn(1500);
            var w = 0;
            
            y.each(function(){
                var z = $(this);
                $timeout(function(){
                    z.addClass('animated fadeOutRightBig').delay(1000).queue(function(){
                        z.remove();
                    });
                }, w+=150);
            })
            
            _this.messageResult.data = [];
            
            $timeout(function(){
                angular.element('#notifications').addClass('empty');
            }, (z*150)+200);
        }
        
        // 清除缓存信息
        this.clearLocalStorage = function() {
            swal({
                title: "确认清除缓存",
                text: "确认要移除所有的浏览器缓存数据吗？",
                type: "warning",
                showCancelButton: true,   
                confirmButtonColor: "#4caf50",
                cancelButtonText: "取消",
                confirmButtonText: "确认",
                closeOnConfirm: false
            }, function(){
                localStorage.clear();
                swal("完成", "缓存清除完成", "success"); 
            });
        }
        
        // 全屏显示
        this.fullScreen = function() {
            // 全屏
            function launchIntoFullscreen(element) {
                if(element.requestFullscreen) {
                    element.requestFullscreen();
                } else if(element.mozRequestFullScreen) {
                    element.mozRequestFullScreen();
                } else if(element.webkitRequestFullscreen) {
                    element.webkitRequestFullscreen();
                } else if(element.msRequestFullscreen) {
                    element.msRequestFullscreen();
                }
            }

            // 退出全屏
            function exitFullscreen() {
                if(document.exitFullscreen) {
                    document.exitFullscreen();
                } else if(document.mozCancelFullScreen) {
                    document.mozCancelFullScreen();
                } else if(document.webkitExitFullscreen) {
                    document.webkitExitFullscreen();
                }
            }

            if (exitFullscreen()) {
                launchIntoFullscreen(document.documentElement);
            }
            else {
                launchIntoFullscreen(document.documentElement);
            }
        }
    
    })