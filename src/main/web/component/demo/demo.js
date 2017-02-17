import ng from 'base/ngRequire'
import template from './demo.html'
import demoService from 'service/demoService'
import modal from 'widget/modal/modal.js';
import './modalDemo.js'
import './routeDemo.js'
import './route2.js'
import 'css/demo/index2.css'

function Demo() {
  let self = this;
  self.msg = 'Demo msg';
  ng.$rootScope.authors = ['Fnix', 'gxl'];
  demoService.queryDemo({name: 1}).then().catch(() => console.log('queryDemo出错了'));
  modal.openComponent('自定义弹框', 'modal-demo', {param: 'open modal'});
}

function getMsg() {
  let self = this;
  return self.msg;
}

Demo.prototype = {
  getMsg: getMsg
}

ng.componentAs('demo', Demo, template, 'vm', {});