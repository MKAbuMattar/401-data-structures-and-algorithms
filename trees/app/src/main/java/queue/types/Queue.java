package queue.types;

import queue.data.Node;

public class Queue<T>  {
    private Node<T> front;
    private Node<T> back;
    private int size = 0;

    public Queue() {
        front = new Node<>();
        back = new Node<>();
        front.setNext(back);
    }

    public void enqueue(T data) {
        if (isEmpty()) {
            front.setData(data);
        } else if (back.getData() == null) {
            back.setData(data);
        } else {
            Node<T> newNode = new Node<>(data);
            back.setNext(newNode);
            back = newNode;
        }
        size++;
    }

    public T dequeue() {
        Node<T> temp;
        if (isEmpty()) {
            return null;
        } else if (front.getNext() == back) {
            temp = new Node<>(front.getData());
            front = front.getNext();
            back = new Node<>();
            front.setNext(back);
            temp.setNext(null);
            size--;
            return temp.getData();
        } else {
            temp = new Node<>(front.getData());
            front = front.getNext();
            temp.setNext(null);
            size--;
            return temp.getData();
        }
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return front.getData();
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front.getData() == null;
    }

    public String toString() {
        Node<T> current = front;
        if (current.getData() == null) {
            return "Tree is empty";
        }
        StringBuilder showList = new StringBuilder();
        while (current != null) {
            showList.append("{").append(current.getData()).append("}-> ");
            current = current.getNext();
        }
        showList.append("NULL");
        return showList.toString();
    }
}
