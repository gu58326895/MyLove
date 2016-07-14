(function(angular) {

    angular.module('myApp.picker').directive('datePicker', ['$parse', 'dateFilter', function($parse, dateFilter) {

        return {
            restrict: 'E',
            template: '<input type="text"/>',
            scope: {
                ngModel: '=ngModel'
            },
            link: function(scope, element) {
                if (scope.ngModel) {
                    $('input', element).val(dateFilter(new Date(scope.ngModel), 'yyyy-MM-dd HH:mm'));
                } else {
                    $('input', element).val(dateFilter(new Date(), 'yyyy-MM-dd HH:mm'));
                }

                $('input', element).datepicker({
                    timepicker: true,
                    autoclose: false
                }).on("hide", function(event) {
                    var date = null;
                    if (event.delegateTarget.value) {
                        date = new Date(event.delegateTarget.value.replace(/-/g, "/")).getTime();
                        date = date || null;
                    }

                    scope.$apply(function(){
                        scope.ngModel = date;
                    });
                });

                scope.$watch('ngModel', function(value){
                    value = value ? dateFilter(new Date(value), 'yyyy/MM/dd HH:mm') : '';
                    if (value) {
                        $('input', element).datepicker('update', value);
                    } else {
                        $('input', element).val(value);
                    }
                });
            }
        }
    }]);
}(angular));

