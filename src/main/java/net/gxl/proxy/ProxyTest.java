package net.gxl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by GXL on 2016/7/20.
 */
public class ProxyTest {



    public static void main(String[] args) {
        final IHello hello = new Hello();
        IHello proxy = (IHello) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{IHello.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("---开始");

                        Object object = method.invoke(hello,args);

                        System.out.println("---结束");

                        return object;

                    }
                });

        proxy.hi();
        proxy.hello();
    }
}
