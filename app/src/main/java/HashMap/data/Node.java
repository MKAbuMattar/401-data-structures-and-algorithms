package HashMap.data;

public class Node<K, V> {
  private K key;
  private  V value;
  Node<K, V> next;

  public Node(K key, V value, Node<K, V> next) {
    this.key = key;
    this.value = value;
    this.next = next;
  }

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public Node() {
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public void setValue(V value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return key.toString();
  }
}
