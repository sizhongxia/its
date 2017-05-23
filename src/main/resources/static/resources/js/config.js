materialAdmin.config(function ($stateProvider, $urlRouterProvider){
	var _url_prefix = "../zx.m/";
	
	$urlRouterProvider.otherwise("main");
    
    $stateProvider
    
        //------------------------------
        // 主面板
        //------------------------------
        .state ('main', {
            url: '/main',
            templateUrl: _url_prefix + 'main',
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load ([
                        {
                            name: 'vendors',
                            insertBefore: '#app-level-js',
                            files: [
                                '../resources/vendors/sparklines/jquery.sparkline.min.js',
                                '../resources/vendors/components/jquery.easy-pie-chart/dist/jquery.easypiechart.min.js'
                            ]
                        }
                    ])
                }
            }
        })


        //------------------------------
        // 侧边栏导航
        //------------------------------
        .state ('system', {
            url: '/system',
            templateUrl: _url_prefix + 'common'
        })
        .state('system.role', {
            url: '/system-role',
            templateUrl: _url_prefix + 'system-role'
        })
        .state('system.permission-group', {
            url: '/system-permission-group',
            templateUrl: _url_prefix + 'system-permission-group'
        })
        .state('system.permission-wd', {
            url: '/system-permission-wd',
            templateUrl: _url_prefix + 'system-permission-wd'
        })
        .state('system.permission-wd-create', {
            url: '/system-permission-wd-create',
            templateUrl: _url_prefix + 'system-permission-wd-create'
        })
        .state('system.permission-wd-change', {
            url: '/system-permission-wd-change/:permissionId',
            templateUrl: _url_prefix + 'system-permission-wd-change'
        })
        .state('system.menu', {
            url: '/system-menu',
            templateUrl: _url_prefix + 'system-menu'
        })
        
});