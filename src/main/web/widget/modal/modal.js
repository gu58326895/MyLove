import ng from 'base/ngRequire';
import angular from 'angular';
import $ from 'jquery'

/**
 * 无footer弹框,默认会带上组件名一致的class样式
 * Option: {
 *    option: {},//用以控制弹框的显示样式等
 *    param: {} || '' || []//用以外部传参
 * }
 * @param directiveName
 * @param option
 */
const openComponent = (title = "", directiveName, option, parentScope) => {
  let directive = '<' + directiveName + ' param="param" option="option" class="'+ directiveName + '"/>';
  let scope = (parentScope || ng.$rootScope).$new();
  scope.param = option.param;
  scope.option = option.option;
  let dom = angular.element(directive);
  ng.$compile(dom)(scope);
  $('body').append(dom);
}

/**
 * 有footer弹框
 * @param directiveName
 * @param option
 */
const openDialog = (directiveName, option) => {

}

export default {
  openComponent
}