package HashTable.types;

import HashTable.data.Node;
import LinkedList.types.LinkedList;

public class HashTable<V> {

  private LinkedList<Node<V>> bucketArray;
  private int numBuckets;
  private int size;

  public HashTable() {
    bucketArray = new LinkedList<>();
    numBuckets = 10;
    size = 0;

    for (int i = 0; i < numBuckets; i++) {
      bucketArray.add(null);
    }

  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return getSize() == 0;
  }

  private int hashCode(String key) {
    char[] letters = key.toCharArray();

    double sum = 0;

    for (int i = 0; i < letters.length; i++) {
      double power = Math.pow((int) letters[i], i + 1);
      sum += power;
    }

    sum = (sum * 600) % getSize() + 1;

    return (int) sum;
  }

  private int getBucketIndex(String key) {
    int hashCode = hashCode(key);
    int index = hashCode % numBuckets;
    return Math.abs(index);
  }

  public void add(String key, V value) {
    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);
    Node<V> head = bucketArray.get(bucketIndex);

    while (head != null) {
      if (head.getKey().equals(key) && head.getHashCode() == hashCode) {
        head.setValue(value);
        return;
      }
      head = head.getNext();
    }

    size++;
    head = bucketArray.get(bucketIndex);
    Node<V> newNode = new Node<V>(key, value, hashCode);
    newNode.setNext(head);
    bucketArray.set(bucketIndex, newNode);

    resize();
  }

  private void resize() {
    if ((1.0 * size) / numBuckets >= 0.7) {
      LinkedList<Node<V>> temp = bucketArray;
      bucketArray = new LinkedList<>();
      numBuckets *= 2;
      size = 0;
      for (int i = 0; i < numBuckets; i++) {
        bucketArray.add(null);
      }

      for (Node<V> headNode : temp) {
        while (headNode != null) {
          add(headNode.getKey(), headNode.getValue());
          headNode = headNode.getNext();
        }
      }
    }
  }

  public V get(String key) {
    int bucketIndex = getBucketIndex(key);

    int hashCode = hashCode(key);

    Node<V> head = bucketArray.get(bucketIndex);

    while (head != null) {
      if (head.getKey().equals(key) && head.getHashCode() == hashCode) {
        return head.getValue();
      }

      head = head.getNext();
    }

    return null;
  }

  public V remove(String key) {
    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);
    Node<V> head = bucketArray.get(bucketIndex);

    Node<V> prev = null;
    while (head != null) {
      if (head.getKey().equals(key) && hashCode == head.getHashCode()) {
        break;
      }

      prev = head;
      head = head.getNext();
    }

    if (head == null) {
      return null;
    }

    size--;

    if (prev != null) {
      prev.setNext(head.getNext());
    } else {
      bucketArray.set(bucketIndex, head.getNext());
    }

    return head.getValue();
  }
}
