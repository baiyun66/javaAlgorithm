package Javase. Windows;

/*
 synchronized (obj)
 同步代码块：包裹需要操作共享资源的代码，加obj锁，obj需要只有一把锁，表示只能同时一个线程操作该资源。
            过程：等待阻塞的线程执行完后，其余线程才可以和结束的线程一起再来执行改代码块
 */


public class ExampleThreads {
    public static void main(String[] args) {
        Window w1 = new  Window();
        Window w2 = new  Window();
        Window w3 = new  Window();
        w1.start();
        w2.start();
        w3.start();
    }
}


class Window extends  Thread{
    private static int tickets = 100;
    private static Object obj = new Object();  //同步锁，唯一的object就行
    @Override
    public void run(){
        while (true){
            synchronized (obj){
                if(tickets>0){
                    try {
                         Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tickets--;
                    System.out.printf("%s  %d\n", Thread.currentThread().getName(),tickets);
                }else{
                    break;
                }
            }
        }
    }
}