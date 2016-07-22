package net.gxl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.gxl.exception.MyException;

/**
 * Created by GXL on 2016/7/20.
 */
public class ProxyTest {

    public static void main(String[] args) throws MyException {
        IHello hello = new Hello();
        MyHandler handler = new MyHandler(hello);



        IHello proxy = (IHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),handler);
        proxy.hello();
        proxy.hi();
        proxy.bye();

    }
}
