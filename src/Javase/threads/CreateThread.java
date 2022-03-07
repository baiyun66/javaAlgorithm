package Javase.threads;

/*
1.继承thread
2.重写run
3.调用start
    周期：先启动主线程  主线程生成子线程  几个子线程和主线程独立运行
    启动后不能继续启动

4.currentThreads
5.getName
6.setName
7.yield   释放线程的执行权
8.join  加入线程，父线程中断，子线程执行完，继续父线程
9.stop  停止 已过时
10. sleep 休眠毫秒
11. isAlive  是否还存活

12优先级：
    MAX_PRIORITY:10
    MIN_PRIORITY:1
    NORM_PRIORITY:5

    getPriority  优先级高的可能先执行
    setPriority
 */


public class CreateThread {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("主线程");
        System.out.printf("主线程优先级：%d",Thread.currentThread().getPriority());

        MyThread myThread1 = new MyThread();
        myThread1.setName("线程一");
        System.out.println(myThread1.getName());


        MyThread myThread2 = new MyThread();
        myThread2.setName("线程二");
        myThread2.setPriority(1);

        myThread1.start();  //启动此(新)线程  调用run
        myThread2.start();
//        myThread2.join();


        /*
        方式二
        1.implements Runnable   实现接口
        2.MyThread2 myThread21 = new MyThread2();  实例化
        3.Thread T1 = new Thread(myThread21);  实例化 Thread
        4.T1.start();
         */

        MyThread2 myThread21 = new MyThread2();
        Thread T1 = new Thread(myThread21);
        T1.setName("线程一");
        T1.start();

    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.printf("%s %s:%d\n",currentThread().getName(),currentThread().getPriority(),i);

//            if(i%2==0){
//                yield();
//            }


        }
    }
}



class MyThread2 implements Runnable{
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.printf("%d\n",i);
            System.out.printf("%s\n",Thread.currentThread().getName());
        }
    }
}