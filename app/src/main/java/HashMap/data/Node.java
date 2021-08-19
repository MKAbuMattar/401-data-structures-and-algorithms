package HashMap.data;

public class Node<K, V> {
  Node<K, V> next;
  private K key;
  private V value;

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

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return key.toString();
  }
}
