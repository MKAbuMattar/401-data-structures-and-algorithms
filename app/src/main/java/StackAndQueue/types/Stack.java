package StackAndQueue.types;

import StackAndQueue.data.Node;

public class Stack<T> {
    private Node<T> top;

    public Stack() {
        top = null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> temp = top;
        top = newNode;
        top.setNext(temp);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        Node<T> temp = top;
        if (top.getNext() == null) {
            top = null;
        } else {
            top = top.getNext();
            temp.setNext(null);
        }
        return temp.getData();
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return top.getData();
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Node<T> getTop() {
        return top;
    }

    public String toString() {
        Node<T> current = top;
        if (current == null) {
            return "Stack list is empty";
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
