package types;

public class PseudoQueue<T> {
  private final Stack<T> main;
  private final Stack<T> temp;
  private int size;

  public PseudoQueue() {
    this.main = new Stack<>();
    this.temp = new Stack<>();
  }

//  public void enqueue(T data) {
//    while (!isEmpty()) {
//      this.temp.push(this.main.pop());
//    }
//    this.temp.push(data);
//    while (!this.temp.isEmpty()) {
//      this.main.push(this.temp.pop());
//    }
//    size++;
//  }

  public void enqueue(T data) {

    if (temp.getTop() != null) {
      while (temp.getTop() != null) {
        main.push(temp.pop());
      }
    }
    main.push(data);
    size++;
  }

//  public T dequeue() {
//    if (!isEmpty()) {
//      size--;
//      return this.main.pop();
//    } else {
//      return null;
//    }
//  }

  public T dequeue() {
    T tempData = null;
    if (temp.getTop() == null && main.getTop() == null) {
      return null;
    }

    if (main.getTop() != null) {
      while (main.getTop() != null) {
        temp.push(main.pop());
      }
      tempData = temp.pop();
      while (temp.getTop() != null) {
        main.push(temp.pop());
      }
    }
    size--;
    return tempData;
  }

  public T peek() {
    T tempData = null;
    if (temp.getTop() == null && main.getTop() == null) {
      return null;
    }

    if (main.getTop() != null) {
      while (main.getTop() != null) {
        temp.push(main.pop());
      }
      tempData = temp.peek();
      while (temp.getTop() != null) {
        main.push(temp.pop());
      }
    }
    return tempData;
  }

  public boolean isEmpty() {
    return this.main.isEmpty();
  }

  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
    if (isEmpty()) {
      return "Pseudo Queue list is empty";
    } else {
      return main.toString();
    }
  }
}
