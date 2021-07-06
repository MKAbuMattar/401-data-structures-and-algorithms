package types;

import data.Node;

public class LinkedList<T> {
  private Node<T> head;
  private int size;

  public void add(T data) {
    Node<T> node = new Node<>(data);
    if (head == null) {
      head = node;
      return;
    }
    Node<T> current = head;
    while (current.getNext() != null) {
      current = current.getNext();
    }
    current.setNext(node);
    size++;
  }

  public void insert(T data) {
    Node<T> node = new Node<>(data);
    if (head == null) {
      head = node;
    } else {
      Node<T> current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(node);
    }
    size++;
  }

  public void append(T data) {
    Node<T> node = new Node<>(data);
    if (head == null) {
      head = node;
    } else {
      Node<T> current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(node);
    }
    size++;
  }

  public void insertAfter(T after, T data) {
    boolean isIncludes = includes(after);

    if (isIncludes) {
      Node<T> newNode = new Node<>(data);
      Node<T> current = head;
      Node<T> aftCurrent = current;
      while (current.getData() != after) {
        current = aftCurrent;
        aftCurrent = aftCurrent.getNext();
      }
      newNode.setNext(aftCurrent);
      current.setNext(newNode);
      size++;
    }
  }

  public void insertBefore(T before, T data) {
    boolean isIncludes = includes(before);

    if (isIncludes) {
      Node<T> newNode = new Node<>(data);
      Node<T> current = head;
      Node<T> prevCurrent = current;
      if (this.head.getData() == before) {
        insertAtFirst(data);
      } else {
        while (current.getData() != before) {
          prevCurrent = current;
          current = current.getNext();
        }
        newNode.setNext(current);
        prevCurrent.setNext(newNode);
        size++;
      }
    }
  }

  public void insertAtFirst(T value) {
    Node<T> node = new Node(value);
    if (this.head == null) {
      this.head = node;
    } else {
      node.setNext(this.head);
      this.head = node;
    }
    size++;
  }

  public boolean includes(T value) {
    Node<T> current = head;
    if (size != 0) {
      while (current != null) {
        if (current.getData() == value) {
          return true;
        }
        current = current.getNext();
      }
    }
    return false;
  }

  public T kthFromEnd(int index) {
    if ((index > -1) && (index > size)) {
      return null;
    }
    if (index > -1) {
      Node<T> current = head;
      int i = size - index;
      while (i > 0) {
        current = current.getNext();
        i--;
      }
      return current.getData();
    } else {
      return null;
    }
  }

  public static LinkedList zipLists(LinkedList firstList, LinkedList secondList){
    if(firstList.head != null && secondList.head != null) {
      firstList.head = (callBackZipListsInsert(firstList.head, secondList.head));
      return firstList;
    } else {
      return null;
    }
  }

  private static Node callBackZipListsInsert(Node firstNode, Node secondNode) {
    if ( firstNode == null ) {
      return secondNode;
    }
    else if (secondNode == null) {
      return firstNode;
    } else {
      Node remainingNods = callBackZipListsInsert(firstNode.getNext(), secondNode.getNext());
      secondNode.setNext(remainingNods);
      firstNode.setNext(secondNode);
      return firstNode;
    }
  }

  public String toString() {
    Node<T> current = head;
    if (current == null) {
      return "Linked list is empty";
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
