package com.darcytech.controller;

/**
 * Created by guxiaoli on 14/07/2017.
 */
public class Run implements Runnable {
    @Override
    public void run() {

        try {
            Thread.sleep(3000);
            System.out.println("睡醒了");
        } catch (Exception e){
            //
        }

    }
}
