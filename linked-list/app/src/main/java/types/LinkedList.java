package types;

import data.Node;

public class LinkedList<T> {
  private Node<T> head;
  private int size;

  /**
   *
   * @param data
   */
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

  /**
   *
   * @param data
   */
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

  /**
   *
   * @param data
   */
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

  /**
   *
   * @param after
   * @param data
   */
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

  /**
   *
   * @param before
   * @param data
   */
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

  /**
   *
   * @param value
   */
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

  /**
   *
   * @param value
   * @return
   */
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

  /**
   *
   * @param index
   * @return
   */
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

  /**
   *
   * @param listOne
   * @param ListTwo
   * @return
   */
  public LinkedList zipLists(LinkedList listOne, LinkedList ListTwo){
    if(listOne.head != null && ListTwo.head != null) {
      listOne.head = zipListsInsert(listOne.head, ListTwo.head);
      return listOne;
    } else {
      return null;
    }
  }

  /**
   *
   * @param nodeOne
   * @param nodeTwo
   * @return
   */
  private Node zipListsInsert(Node nodeOne, Node nodeTwo) {
    if ( nodeOne == null ) {
      return nodeTwo;
    } else if (nodeTwo == null) {
      return nodeOne;
    } else {
      Node mergeNode = zipListsInsert(nodeOne.getNext(), nodeTwo.getNext());
      nodeTwo.setNext(mergeNode);
      nodeOne.setNext(nodeTwo);
      return nodeOne;
    }
  }

  /**
   *
   */
  public void reverse() {
    if(head != null && head.getNext() != null) {
      Node<T> previous = null;
      Node<T> current = head;
      Node<T> next = current.getNext();
      while(current != null) {
        current.setNext(previous);
        previous = current;
        current = next;
        if(next != null) {
          next = next.getNext();
        }
      }
      head = previous;
    }
  }

  /**
   *
   * @return
   */
  public boolean palindrome(){
    boolean result = false;

    Node printerFirst = head;
    Node printerSecond = head;
    Node previousPrinter = head;
    Node middleNode = null;

    if (head != null && head.getNext() != null) {
      while (printerSecond != null && printerSecond.getNext() != null) {
        printerSecond = printerSecond.getNext().getNext();
        previousPrinter = printerFirst;
        printerFirst = printerFirst.getNext();
      }

      if (printerSecond != null) {
        middleNode = printerFirst;
        printerFirst = printerFirst.getNext();
      }

      Node secondHalfNode = printerFirst;
      previousPrinter.setNext(null);

      reverse();

      Node tempNodeOne = head;
      Node tempNodeTwo = secondHalfNode;

      while (tempNodeOne != null && tempNodeTwo != null) {
        if (tempNodeOne.getData() == tempNodeTwo.getData()) {
          tempNodeOne = tempNodeOne.getNext();
          tempNodeTwo = tempNodeTwo.getNext();
        } else {
          return false;
        }
      }

      if (tempNodeOne == null && tempNodeTwo == null){
        return true;
      }

      reverse();

      if (middleNode != null) {
        previousPrinter.setNext(middleNode);
        middleNode.setNext(secondHalfNode);
      } else {
        previousPrinter.setNext(secondHalfNode);
      }
    } else {
      result = true;
    }
    return result;
  }

  /**
   *
   * @return
   */
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
