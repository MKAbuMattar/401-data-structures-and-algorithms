package HashTable.data;

public class Node<V> {
  private String key;
  private V value;
  private final int hashCode;

  Node<V> next;

  public Node(String key, V value, int hashCode) {
    this.key = key;
    this.value = value;
    this.hashCode = hashCode;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public int getHashCode() {
    return hashCode;
  }

  public Node<V> getNext() {
    return next;
  }

  public void setNext(Node<V> next) {
    this.next = next;
  }
}
