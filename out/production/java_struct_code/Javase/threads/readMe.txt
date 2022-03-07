大章
    /*
    1.基本概念
    2.创建与使用
        JDK5.0 前2种 后2种
    3.生命周期
    4.同步（线程安全）
        3种方法
    5.通信
    6.JDK5.0新增的创建方式
     */


1.基本概念
    并发、并行
    单核、多核
    一个java程序同时至少3个线程（main主线程 gc():垃圾回收线程 异常处理线程）

    使用场景：

2. 创建使用

    优先选择方式二，
        没有类的单继承性
        天然共享数据

    /*
    方式一：
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

    注意：资源可能需要使用 static 几个线程共享一个

     /*
    方式二
        1.implements Runnable   实现接口
        2.MyThread2 myThread21 = new MyThread2();  实例化
        3.Thread T1 = new Thread(myThread21);  实例化 Thread
        4.T1.start();

        3.Thread T2 = new Thread(myThread21);  实例化 Thread
        4.T2.start();
    */

    注意：资源使用类myThread21 里面的资源，不用加 static

     /*
        方式三
           callable 接口
           有返回值，可以使用泛型，可以抛出异常
        */


      /*
         方式二
           线程池ThreadPool
           提高线程的重用率，便以线程的管理
         */


3.生命周期
    新建
    就绪
    运行
    阻塞
    死亡

4.线程的同步

    /*
     synchronized(obj){}
     同步代码块：包裹需要操作共享资源的代码，加obj锁，obj需要只有一把锁，表示只能同时一个线程操作该资源。
                过程：等待阻塞的线程执行完后，其余线程才可以和结束的线程一起再来执行改代码块
     */

     /*
     同步方法：
            private synchronized void(){}
            在实现runNable类时，同步监视器为this 只有一个对象

            private static synchronized void(){}
            在继承Thread类时，可以有多个对象，同步监视器this会有多个，所以使用static
     */

     /*
          lock:
            锁，上锁代码块：共享资源
            解锁，释放共享资源
     */

5.线程通信
    1.wait()  阻塞当前线程，释放资源锁
    2.notify()  唤醒阻塞的线程的一个优先级较高的
    3.notifyAll() 唤醒所有阻塞的线程
    注意：在同步代码块中，同步方法中使用
    调佣者需要是同一个监视器
