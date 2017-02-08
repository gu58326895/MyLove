package net.gxl.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sun.awt.windows.ThemeReader;

/**
 * Created by GXL on 2016/7/20.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        ExecutorService ex = Executors.newFixedThreadPool(10);
        // 通过线程池， 模拟有3个窗口（线程），当然你可以建立不同的Thread 1 2 3
        // 多执行几次
        for(int i = 0;i<3;i++){
            ex.execute(new Thread1());
            ex.execute(new Thread1());
            ex.execute(new Thread1());
        }
        ex.shutdown();
    }
}
