package net.gxl.proxy;

/**
 * Created by GXL on 2016/7/20.
 */
public class Hello implements IHello {
    @Override
    public void hello() {
        System.out.println("hello  my proxy");
    }

    @Override
    public void hi() {
        System.out.println("hi");
    }
}
