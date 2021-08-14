package LinkedList.types;

import LinkedList.data.Node;

import java.util.Collection;

public class LinkedList<T> {
  private Node<T> head;
  private Node<T> last;
  private int size;

  public LinkedList() {
  }

  public int getSize() {
    return size;
  }

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
    Node<T> node = new Node<>(value);
    if (this.head != null) {
      node.setNext(this.head);
    }
    this.head = node;
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

  public LinkedList<T> zipLists(LinkedList<T> listOne, LinkedList<T> ListTwo) {
    if (listOne.head != null && ListTwo.head != null) {
      listOne.head = zipListsInsert(listOne.head, ListTwo.head);
      return listOne;
    } else {
      return null;
    }
  }

  private Node<T> zipListsInsert(Node<T> nodeOne, Node<T> nodeTwo) {
    if (nodeOne == null) {
      return nodeTwo;
    } else if (nodeTwo == null) {
      return nodeOne;
    } else {
      Node<T> mergeNode = zipListsInsert(nodeOne.getNext(), nodeTwo.getNext());
      nodeTwo.setNext(mergeNode);
      nodeOne.setNext(nodeTwo);
      return nodeOne;
    }
  }

  public boolean testPalindrome() {
    boolean result = true;

    Node<T> first = head;
    Node<T> second = head;
    Node<T> previous;
    Node<T> temp;

    while (second != null && second.getNext() != null) {
      first = first.getNext();
      second = second.getNext().getNext();
    }

    previous = first;
    first = first.getNext();
    previous.setNext(null);

    while (first != null) {
      temp = first.getNext();
      first.setNext(previous);
      previous = first;
      first = temp;
    }

    second = head;
    first = previous;

    while (first != null) {
      if (second.getData() != first.getData()) {
        result = false;
      }
      second = second.getNext();
      first = first.getNext();
    }

    return result;
  }

  public void reverse() {
    if (head != null && head.getNext() != null) {
      Node<T> previous = null;
      Node<T> current = head;
      Node<T> next = current.getNext();
      while (current != null) {
        current.setNext(previous);
        previous = current;
        current = next;
        if (next != null) {
          next = next.getNext();
        }
      }
      head = previous;
    }
  }

  public boolean palindrome() {
    boolean result;

    Node<T> pointerFirst = head;
    Node<T> pointerSecond = head;
    Node<T> pointerPrevious = head;
    Node<T> middleNode = null;

    if (head != null && head.getNext() != null) {
      while (pointerSecond != null && pointerSecond.getNext() != null) {
        pointerSecond = pointerSecond.getNext().getNext();
        pointerPrevious = pointerFirst;
        pointerFirst = pointerFirst.getNext();
      }
      if (pointerSecond != null) {
        middleNode = pointerFirst;
        pointerFirst = pointerFirst.getNext();
      }

      Node<T> secondHalfNode = pointerFirst;

      pointerPrevious.setNext(null);

      reverse();

      result = comparison(head, secondHalfNode);

      reverse();

      if (middleNode != null) {
        pointerPrevious.setNext(middleNode);
        middleNode.setNext(secondHalfNode);
      } else {
        pointerPrevious.setNext(secondHalfNode);
      }
    } else {
      result = true;
    }
    return result;
  }

  public boolean comparison(Node<T> NodeOne, Node<T> NodeTwo) {
    Node<T> tempNodeOne = NodeOne;
    Node<T> tempNodeTwo = NodeTwo;

    while (tempNodeOne != null && tempNodeTwo != null) {
      if (tempNodeOne.getData() == tempNodeTwo.getData()) {
        tempNodeOne = tempNodeOne.getNext();
        tempNodeTwo = tempNodeTwo.getNext();
      } else {
        return false;
      }
    }

    return tempNodeOne == null && tempNodeTwo == null;
  }

  private boolean isElementIndex(int index) {
    return index >= 0 && index < this.size;
  }

  private String outOfBoundsMsg(int index) {
    return "Index: " + index + ", Size: " + this.size;
  }

  private void checkElementIndex(int index) {
    if (!this.isElementIndex(index)) {
      throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
    }
  }

  private Node<T> node(int index) {
    Node<T> temp;
    int i;
    if (index < this.size && this.size > 0) {
      temp = head;

      for (i = 0; i < index; ++i) {
        temp = temp.getNext();
      }

    } else {
      temp = last;

      for (i = this.size - 1; i > index; --i) {
        temp = temp.getPrev();
      }

    }
    return temp;
  }

  public T set(int index, T element) {
    this.checkElementIndex(index);
    Node<T> temp = node(index);
    T oldVal = temp.getData();
    temp.setData(element);
    return oldVal;
  }

  public T get(int index) {
    this.checkElementIndex(index);
    return this.node(index).getData();
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
