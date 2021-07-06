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
  public static LinkedList zipLists(LinkedList listOne, LinkedList ListTwo){
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
   * @param NodeTwo
   * @return
   */
  private static Node zipListsInsert(Node nodeOne, Node NodeTwo) {
    if ( nodeOne == null ) {
      return NodeTwo;
    } else if (NodeTwo == null) {
      return nodeOne;
    } else {
      Node mergeNode = zipListsInsert(nodeOne.getNext(), NodeTwo.getNext());
      NodeTwo.setNext(mergeNode);
      nodeOne.setNext(NodeTwo);
      return nodeOne;
    }
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
