import template from './modalDemo.html'
import ng from 'base/ngRequire'

function ModalDemo() {
  let self = this;
  self.msg = 'modal Demo';
}

ng.componentAs('modalDemo', ModalDemo, template, 'vm', {param: '='});