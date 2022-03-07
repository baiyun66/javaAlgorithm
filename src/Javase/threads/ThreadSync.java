package Javase.threads;

/*
 synchronized (obj)
 同步代码块：包裹需要操作共享资源的代码，加obj锁，obj需要只有一把锁，表示只能同时一个线程操作该资源。
            过程：等待阻塞的线程执行完后，其余线程才可以和结束的线程一起再来执行改代码块

  synchronized func()
  修饰方法，表示这个方法里面所有的代码是枷锁的。监视器为：this
 */


public class ThreadSync {
    public static void main(String[] args) {
        Window window = new Window();
        Thread w1 = new Thread(window);
        Thread w2 = new Thread(window);
        Thread w3 = new Thread(window);
        w1.start();
        w2.start();
        w3.start();
    }
}



class Window implements Runnable{
    private int tickets = 100;
    Object obj = new Object();  //同步锁，唯一的object就行

    @Override
    public void run(){
            while (true){
                synchronized (Window.class){  //synchronized (obj){  //ynchronized (this)
                if(tickets>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tickets--;
                    System.out.printf("%s  %d\n",Thread.currentThread().getName(),tickets);
                }else{
                    break;
                }
            }
        }


    }
}