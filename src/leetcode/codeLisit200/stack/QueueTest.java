package leetcode.codeLisit200.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }

}
class MyStack {
    Queue<Integer> queueIn = new ArrayDeque<>();
    Queue<Integer> queueOut = new ArrayDeque<>();
    Queue<Integer> queueTemp;

    public MyStack() {

    }

    public void push(int x) {
        queueIn.add(x);
    }

    public int pop() {
        while (queueIn.size()>1){
            queueOut.add(queueIn.poll());
        }
        int ans = queueIn.poll();
        queueTemp = queueIn;
        queueIn = queueOut;
        queueOut = queueTemp;

        return ans;

    }

    public int top() {
        while (queueIn.size()>1){
            queueOut.add(queueIn.poll());
        }
        int ans = queueIn.poll();
        queueOut.add(ans);
        queueTemp = queueIn;
        queueIn = queueOut;
        queueOut = queueTemp;
        return ans;

    }

    public boolean empty() {
        return queueIn.size()==0;

    }
}
