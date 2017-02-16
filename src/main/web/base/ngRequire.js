import angular from 'angular';
import angularRoute from 'angular-route';

console.log(angularRoute);

const application = angular.module('myLove', ['ngRoute']);
const app = () => application;

const exportApp = {};
app().run(['$rootScope', '$q', '$http', '$location', '$timeout', '$compile',
  ($rootScope, $q, $http, $location, $timeout, $compile) => {
    exportApp.$rootScope = $rootScope;
    exportApp.$q = $q;
    exportApp.$http = $http;
    exportApp.$location = $location;
    exportApp.$timeout = $timeout;
    exportApp.$compile = $compile;
  }]);
app().config(['$locationProvider', function($locationProvider) {
  $locationProvider.hashPrefix('');
}]);

const bootstrap = () => {
  angular.bootstrap(document.body, ['myLove']);
}

const componentAs = (componentName, controller, template, alias, scope) => {
  app().directive(componentName, () => {
    return {
      restrict: 'EA',
      scope: scope || {},
      bindToController: true,
      controller: controller,
      template: template,
      controllerAs: alias || 'vm'
    }
  });
}

const defaultRoute = (url = '/', controller, template, alias) => {
  if (!url.startsWith('/')) {
    throw '路由必须以 / 开头';
  }
  app().config(['$routeProvider', ($routeProvider) => {
    $routeProvider.when(url, {
      controller: controller,
      template: template,
      controllerAs: alias || 'vm',
      reoadOnSearch: true
    }).otherwise({redirectTo: url});
  }]);
}

const route = (url = '', controller, template, alias) => {
  if (!url.startsWith('/')) {
    throw '路由必须以 / 开头';
  }
  app().config(['$routeProvider', ($routeProvider) => {
    $routeProvider.when(url, {
      controller: controller,
      template: template,
      controllerAs: alias || 'vm',
      reloadOnSearch: true
    })
  }]);
}

Object.assign(exportApp, {
  app: app,
  bootstrap: bootstrap,
  componentAs: componentAs,
  route: route,
  defaultRoute: defaultRoute
});

export default exportApp;