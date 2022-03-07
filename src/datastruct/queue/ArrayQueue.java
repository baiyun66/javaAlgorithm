package datastruct.queue;

import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {
        ArrayQueueObject queue = new ArrayQueueObject(150);
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
                        queue.headQueue();
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

class ArrayQueueObject {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //创建队列
    public ArrayQueueObject(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能添加新的数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int outQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            throw new RuntimeException("队列空，没有数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
        } else {
            for (int i = front + 1; i <= rear; i++) {
                System.out.printf("%d>>", arr[i]);
            }
            System.out.println();
        }

    }

    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front + 1];
    }
}

