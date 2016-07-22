package net.gxl.thread;

/**
 * Created by GXL on 2016/7/20.
 */
public class Ticket {
    private static int num = 100;
    public static void setNum(int num) {
        Ticket.num = num;
    }
    // 这是一个买票的方法
    public static  int getTicket(){
        if(num < 1){
            return 0;
        }
        return num --;
    }
}
