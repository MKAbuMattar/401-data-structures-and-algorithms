package types;

import data.Node;

public class Stack<T> {
  private Node<T> top;

  public Stack() {
    top = null;
  }

  public void push(T data) {
    Node<T> newNode = new Node<>(data);
    Node<T> temp = this.top;
    this.top = newNode;
    this.top.setNext(temp);
  }

  public T pop() {
    if (this.isEmpty()) {
      return null;
    }
    Node<T> temp = this.top;
    if (this.top.getNext() == null) {
      this.top = null;
    } else {
      this.top = this.top.getNext();
      temp.setNext(null);
    }
    return temp.getData();
  }

  public T peek() {
    if (this.isEmpty()) {
      return null;
    } else {
      return this.top.getData();
    }
  }

  public boolean isEmpty() {
    return this.top == null;
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
