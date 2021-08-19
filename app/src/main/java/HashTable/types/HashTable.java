package HashTable.types;

import HashTable.data.Node;
import LinkedList.types.LinkedList;

import java.util.Objects;

public class HashTable<V> {

  private LinkedList<Node<V>> bucketArray;
  private int numBucket;
  private int size;

  public HashTable() {

    bucketArray = new LinkedList<>();
    numBucket = 10;
    size = 0;

    for (int index = 0; index < numBucket; index++) {
      bucketArray.append(null);
    }

  }

  public LinkedList<Node<V>> getBucketArray() {
    return bucketArray;
  }

  public void setBucketArray(LinkedList<Node<V>> bucketArray) {
    this.bucketArray = bucketArray;
  }

  public int getNumBucket() {
    return numBucket;
  }

  public void setNumBucket(int numBucket) {
    this.numBucket = numBucket;
  }

  private int hashCode(String key) {
    return Objects.hashCode(key);
  }

  private int getBucketIndex(String key) {
    int hashCode = hashCode(key);
    int index = hashCode % numBucket;
    return Math.abs(index);
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public boolean isEmpty() {
    return getSize() == 0;
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
    Node<V> newNode = new Node<>(key, value, hashCode);
    newNode.setNext(head);
    bucketArray.set(bucketIndex, newNode);
    resize();
  }

  private void resize() {
    if ((1.0 * size) / numBucket >= 0.7) {
      LinkedList<Node<V>> temp = bucketArray;
      bucketArray = new LinkedList<>();
      numBucket *= 2;
      size = 0;
      for (int index = 0; index < numBucket; index++) {
        bucketArray.append(null);
      }

      for (int i = 0; i <= temp.getSize(); i++) {
        Node<V> headNode = temp.get(i);
        while (headNode != null) {
          add(headNode.getKey(), headNode.getValue());
          headNode = headNode.getNext();
        }
      }

    }
  }

  public V remove(String key) {
    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);

    Node<V> head = bucketArray.get(bucketIndex);

    Node<V> prev = null;

    while (head != null) {
      if (head.getKey().equals(key) && head.getHashCode() == hashCode) {
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

  public boolean contains(String key) {
    return get(key) != null;
  }

}