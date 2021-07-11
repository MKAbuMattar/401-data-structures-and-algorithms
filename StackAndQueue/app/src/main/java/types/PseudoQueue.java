package types;

public class PseudoQueue<T> {
  private final Stack<T> main;
  private final Stack<T> temp;
  private int size;

  public PseudoQueue() {
    this.main = new Stack<>();
    this.temp = new Stack<>();
  }

  public void enqueue(T data) {
    while (!isEmpty()) {
      this.temp.push(this.main.pop());
    }
    this.temp.push(data);
    while (!this.temp.isEmpty()) {
      this.main.push(this.temp.pop());
    }
    size++;
  }

  public T dequeue() {
    if (!isEmpty()) {
      size--;
      return this.main.pop();
    } else {
      return null;
    }
  }

  public T peek() {
    return this.main.peek();
  }

  public boolean isEmpty() {
    return this.main.isEmpty();
  }

  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
    if(isEmpty()){
      return "Pseudo Queue list is empty";
    }else {
      return main.toString();
    }
  }
}
