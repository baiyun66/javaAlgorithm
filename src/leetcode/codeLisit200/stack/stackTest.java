package leetcode.codeLisit200.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class stackTest {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }

}


class MyQueue {
    Stack<Integer> stackOut = new Stack<>();
    Stack<Integer> stackIn = new Stack<>();
    List<Integer> stack = new LinkedList<>();

    int state = 0; //0 入队列   1出队列
    public MyQueue() {
        state = 0;
//        stack.

    }

    public void push(int x) {
        if(state==1){
            allElse();
        }
        stackIn.add(x);
        state = 0;
    }

    public int pop() {
        if(state==0){
            allElse();
        }
        state = 1;
        return stackOut.pop();
    }

    public int peek() {
        if(state==0){
            allElse();
        }
        state = 1;
        return stackOut.peek();
    }

    public boolean empty() {
        return stackOut.size()==0 && stackIn.size()==0;
    }

    public void allElse() {
        if(state==1){
            while(stackOut.size()>0){
                stackIn.add(stackOut.pop());
            }
        }else{
            while(stackIn.size()>0){
                stackOut.add(stackIn.pop());
            }
        }

    }
}