materialAdmin

// =========================================================================
    // SWEATALERT
    // =========================================================================

    //Basic
    .directive('swalBasic', function(){
        return {
            restrict: 'A',
            link: function(scope, element, attrs) {
                element.click(function(){
                    swal("Here's a message!");
                });
            }
        }
    })

