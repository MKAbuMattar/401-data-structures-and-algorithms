package types;

import data.Node;

public class Queue<T>  {
  private Node<T> front;
  private Node<T> back;

  public Queue() {
    this.front = new Node<>();
    this.back = new Node<>();
    this.front.setNext(this.back);
  }

  public void enqueue(T data) {
    if (this.isEmpty()) {
      this.front.setData(data);
    } else if (this.back.getData() == null) {
      this.back.setData(data);
    } else {
      Node<T> newNode = new Node<>(data);
      this.back.setNext(newNode);
      this.back = newNode;
    }
  }

  public T dequeue() {
    if (this.isEmpty()) {
      return null;
    } else if (this.front.getNext() == this.back) {
      Node<T> temp = new Node<>(this.front.getData());
      this.front = this.front.getNext();
      Node<T> newBack = new Node<>();
      this.back = newBack;
      this.front.setNext(this.back);
      return temp.getData();
    } else {
      Node<T> temp = new Node<>(this.front.getData());
      this.front = this.front.getNext();
      return temp.getData();
    }
  }

  public T peek() {
    if (this.isEmpty()) {
      return null;
    } else {
      return this.front.getData();
    }
  }

  public boolean isEmpty() {
    return this.front.getData() == null;
  }

  public String toString() {
    Node<T> current = front;
    if (current == null) {
      return "Queue list is empty";
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
