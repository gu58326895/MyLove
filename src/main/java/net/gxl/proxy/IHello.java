package net.gxl.proxy;

import net.gxl.exception.MyException;

/**
 * Created by GXL on 2016/7/20.
 */
public interface IHello {

    void hello();
    void hi();
    void bye() throws MyException;

}
