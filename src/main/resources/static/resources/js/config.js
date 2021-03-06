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
            url: '/role',
            templateUrl: _url_prefix + 'system-role'
        })
        .state('system.permission-group', {
            url: '/permission-group',
            templateUrl: _url_prefix + 'system-permission-group'
        })
        .state('system.permission-dictionary', {
            url: '/permission-dictionary',
            templateUrl: _url_prefix + 'system-permission-dictionary'
        })
        .state('system.menu', {
            url: '/menu',
            templateUrl: _url_prefix + 'system-menu'
        })
});