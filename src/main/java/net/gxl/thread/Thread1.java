package net.gxl.thread;





public class Thread1 implements Runnable {



    @Override
    public void run() {
        // 打印哪个窗口（线程），买到哪张票
        System.out.println(Thread.currentThread() +":"+Ticket.getTicket());
    }
}