package datastruct.queue;

import java.util.Scanner;

public class LoopQueueDemo {
    public static void main(String[] args) {
        ArrayLoopQueueObject queue = new ArrayLoopQueueObject(5);
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据队列");
            System.out.println("g(get):从数据队列取数据");
            System.out.println("h(head):查看队列头部");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出");
                    break;
                case 'a':
                    System.out.println("请输出一个数字：");
                    int n = scanner.nextInt();
                    queue.addQueue(n);
                    break;
                case 'g':
                    try {
                        System.out.printf("out:%d\n", queue.outQueue());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println(queue.headQueue());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }

        }
    }
}

class ArrayLoopQueueObject {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //创建队列
    public ArrayLoopQueueObject(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return (rear+1)%maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能添加新的数据");
            return;
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }

    public int outQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            throw new RuntimeException("队列空，没有数据");
        }
        int n = arr[front];
        front=(front+1)%maxSize;
        return n;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
        } else {
            int i = 0;
            System.out.printf("队列长度：%d\n", (rear-front+maxSize)%maxSize);
            while (i<(rear-front+maxSize)%maxSize){
                System.out.printf(">>%d", arr[(i+front)%maxSize]);
                i = i+1;
            }
            System.out.println();
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }
}

