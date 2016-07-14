
(function(angular) {

    angular.module('myApp.pagination').directive("paginationControls", [function () {

        return {
            scope: {
                size: '@pageSize',
                totalCount: '=itemCount',
                onPageChange: '=onPageChange'
            },
            restrict: 'AE',
            template: '<div class="sui-pagination pagination-large pagination-right">' +
            '<ul ng-if="1 < pages.length">' +
            '<li ng-class="{disabled: pagination.current == 1, prev: pagination.current == 1}">' +
            '<a href="" ng-click="setCurrent(pagination.current - 1)">«上一页</a>' +
            '</li>' +
            '<li class="prev disabled">' +
            '<a href="" ng-click="setCurrent(pageNumber)"' +
            'ng-class="{\'pagination-margin-left\': pagination.current == 1, \'pagination-margin-right\': pagination.current == pagination.last}">' +
            '{{pagination.current}}/{{pages.length}}' +
            '</a>' +
            '</li>' +

            '<li ng-class="{disabled: pagination.current == pagination.last, prev: pagination.current == pagination.last}">' +
            '<a href="" ng-click="setCurrent(pagination.current + 1)">下一页»</a>' +
            '</li>' +
            '</ul>' +
            '</div>',
            link: function (scope, element, attrs) {
                scope.pages = [];
                scope.pagination = {last: 1, current: 1};
                if (attrs.ngClass) {
                    $('.sui-pagination', element).addClass(attrs.ngClass);
                }

                scope.$watch("totalCount", function (value) {
                    if (0 <= parseInt(value)) {
                        goToPage(1);
                    }
                });

                scope.setCurrent = function (num) {
                    if (isValidPageNumber(num)) {
                        scope.onPageChange(num);
                        goToPage(num);
                    }
                };

                function goToPage(num) {
                    scope.pages = generatePagesArray(scope.size, scope.totalCount);
                    scope.pagination = {last: scope.pages[scope.pages.length - 1], current: num};
                }

                function isValidPageNumber(num) {
                    var numberRegex = /^\d+$/;
                    return (numberRegex.test(num) && (0 < num && num <= scope.pagination.last));
                }

                function generatePagesArray(pageSize, totalCount) {
                    var pages = [];
                    var totalPages = Math.ceil(totalCount / pageSize);

                    var i = 1;
                    while (i <= totalPages) {
                        pages.push(i);
                        i++;
                    }
                    return pages;
                }
            }
        }
    }]);
}(angular));