import ng from 'base/ngRequire'
import template from './routeDemo.html'

function RouteDemo() {
  let self = this;
  self.msg = 'route demo';
}

ng.defaultRoute('/route', RouteDemo, template, 'vm');