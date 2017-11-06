package mytest.lang3.test;

import com.google.common.util.concurrent.AtomicDouble;

/**
 * Created by guxiaoli on 30/08/2017.
 */
public class Account {
    private AtomicDouble balance = new AtomicDouble()  ;     // 账户余额

    /**
     * 存款
     * @param money 存入金额
     */
    public void deposit(double money) {
        balance.addAndGet(money) ;
        try {
            Thread.sleep(10);   // 模拟此业务需要一段处理时间
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance.doubleValue();
    }
}