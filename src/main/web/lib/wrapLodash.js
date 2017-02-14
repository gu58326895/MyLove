import _set from 'lodash/set'
import _get from 'lodash/get'
import _map from 'lodash/map'
import _each from 'lodash/each'
import _compact from 'lodash/compact'
import _uniq from 'lodash/uniq'
import _find from 'lodash/find'

const obj = {
   set: _set,
   get: _get,
   map: _map,
   each: _each,
   compact: _compact,
   uniq: _uniq,
   find: _find
}

const chain = (value) => {
   let chain = new Object();
   chain.currentValue = value;
   _each(obj, (v, k) => {
      chain[k] = (arg1, arg2) => {
         let val = v(chain.currentValue, arg1, arg2);
         chain.currentValue = val || chain.currentValue;
         return chain;
      }
   });
   chain.value = () => chain.currentValue;
   return chain;
}

let wrap = new Object();
_each(obj, (v, k) => {
   wrap[k] = obj[k];
});
wrap.chain = chain;

export default wrap;