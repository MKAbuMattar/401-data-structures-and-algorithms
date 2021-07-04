package types;

import data.Node;

public class LinkedList<T> {
  private Node<T> head;
  private int size;

  public void add(T data){
    Node<T> node = new Node<>(data);
    if(head == null) {
      head = node;
      return;
    }
    Node<T> current = this.head;
    while (current.getNext() != null){
      current = current.getNext();
    }
    current.setNext(node);
    size++;
  }

  public void insert(T data){
    Node<T> node = new Node<>(data);
    if(this.head == null){
      this.head = node;
    } else {
      Node<T> current = this.head;
      while (current.getNext() != null){
        current=current.getNext();
      }
      current.setNext(node);
    }
    size++;
  }

  public void append(T data){
    Node<T> node = new Node<>(data);
    if(this.head == null){
      this.head = node;
    } else {
      Node<T> current = this.head;
      while (current.getNext() != null){
        current=current.getNext();
      }
      current.setNext(node);
    }
    size++;
  }

    public void insertAfter(T after, T data) {
      boolean isIncludes = includes(after);

      if (isIncludes) {
        Node<T> newNode = new Node(data);
        Node<T> current= this.head;
        Node<T> aftCurrent;
        while(current != null ){
          if (current.getData() == after){
            aftCurrent = current.getNext();
            current.setNext(newNode);
            newNode.setNext(aftCurrent);
            break;
          }
          current = current.getNext();
        }
      }
    }

  public void insertBefore(T before, T data){
    boolean isIncludes = includes(before);

    if (isIncludes) {
      Node<T> newNode = new Node(data);
      Node<T> current = this.head;
      Node<T> prevCurrent = current;
      while(current != null ){
        if (current.getData() == data){
          newNode.setNext(current);
          prevCurrent.setNext(newNode);
          break;
        }
        prevCurrent = current;
        current = current.getNext();
      }
    }

  }



  public boolean includes(T value){
    Node<T> current = this.head;
    if(size != 0){
      while(current != null){
        if(current.getData() == value){
          return true;
        }
        current = current.getNext();
      }
    }
    return false;
  }

  public String toString(){
    Node<T> current = this.head;
    if (current == null) {
      return "Linked list is empty";
    }
    StringBuilder showList = new StringBuilder();
    while(current != null){
      showList.append("{").append(current.getData()).append("}-> ");
      current = current.getNext();
    }
    showList.append("NULL");
    return showList.toString();
  }
}
