package HashMap.data;

public class Node<K, V> {
  private final K key;
  private final V value;
  Node<K, V> next;

  public Node(K key, V value, Node<K, V>  next) {
    this.key = key;
    this.value = value;
    this.next = next;
  }

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  @Override
  public String toString() {
    return key.toString();
  }
}
