/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import types.Queue;
import types.Stack;

public class App {

    private static final Stack<Integer> stackList = new Stack<>();
    private static final Queue<Integer> queueList = new Queue<>();

    public static void main(String[] args) {

        stackList.push(1);
        stackList.push(2);
        stackList.push(3);
        stackList.push(4);
        stackList.push(5);

        System.out.println("Stack list: " + stackList);

        System.out.println("Stack list is empty: "+ stackList.isEmpty());

        System.out.println("stack list pop 1: "+ stackList.pop());
        System.out.println("stack list pop 2: "+ stackList.pop());
        System.out.println("stack list pop 3: "+ stackList.pop());
        System.out.println("stack list pop 4: "+ stackList.pop());
        System.out.println("stack list pop 5: "+ stackList.pop());

        System.out.println("Stack list is empty: "+ stackList.isEmpty());

        stackList.push(5);
        stackList.push(6);
        stackList.push(7);
        stackList.push(8);
        stackList.push(9);

        System.out.println("Stack list: " + stackList);

        System.out.println("Stack list is empty: "+ stackList.isEmpty());

        System.out.println("Stack list peek(): "+ stackList.peek());

        queueList.enqueue(1);
        queueList.enqueue(2);
        queueList.enqueue(3);
        queueList.enqueue(4);
        queueList.enqueue(5);

        System.out.println("Queue list: " + queueList);


        System.out.println("Queue list dequeue 1: "+ queueList.dequeue());
        System.out.println("Queue list dequeue 2: "+ queueList.dequeue());
        System.out.println("Queue list dequeue 3: "+ queueList.dequeue());
        System.out.println("Queue list dequeue 4: "+ queueList.dequeue());
        System.out.println("Queue list dequeue 5: "+ queueList.dequeue());

        System.out.println("Queue list is empty: " + stackList.isEmpty());

        queueList.enqueue(6);
        queueList.enqueue(7);
        queueList.enqueue(8);
        queueList.enqueue(9);
        queueList.enqueue(10);

        System.out.println("Queue list: " + queueList);

        System.out.println("Queue list is empty: " + queueList.isEmpty());

        System.out.println("Queue list peek(): " + queueList.peek());
    }
}