import _ from 'lodash'

const write = () => {
  let a = {};
  _.set(a, 'msg', 'hello world');
  document.write(a.msg);
};

export default {
  write: write
}