package HashMap.types;

import HashMap.data.Node;

import java.util.*;
import java.util.function.Consumer;

public class HashMap<K, V> {

  private Node<K, V>[] array;
  private int size;
  transient Set<Node<K, V>> entrySet;

  public HashMap() {
    array = new Node[10];
  }

  public V put(K key, V value) {
    int index = getIndex(key);
    while (true) {
      if (array[index] == null) {
        Node<K, V> newNode = new Node<>(key, value);
        array[index] = newNode;
        ++size;
        resize();
        return null;
      } else if (array[index].getKey().equals(key)) {
        V old = array[index].getValue();
        array[index] = new Node<>(key, value);
        return old;
      } else {
        index = includeIndex(index);
      }
    }
  }

  public V get(K key) {
    int index = getIndex(key);
    while (true) {
      if (array[index] == null) {
        return null;
      } else if (array[index].getKey().equals(key)) {
        return array[index].getValue();
      } else {
        index = includeIndex(index);
      }
    }
  }

  private int includeIndex(int index) {
    ++index;
    if (index >= array.length) {
      index = 0;
    }
    return index;
  }

  private int getIndex(K key) {
    return Math.abs(key.hashCode()) % array.length;
  }

  private void resize() {
    if ((size * 10) / array.length > 2) {
      Node<K, V>[] old = array;
      array = new Node[array.length * 2];
      size = 0;
      for (Node<K, V> newNode : old) {
        if (newNode != null) {
          put(newNode.getKey(), newNode.getValue());
        }
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder printArray = new StringBuilder();

    printArray.append("[");

    int b = 0;

    for (Node<K, V> kvNode : array) {
      if (kvNode != null) {
        if (b != 0) {
          printArray.append(",");
        }
        b++;
        printArray.append(kvNode);
      }
    }

    printArray.append("]");
    return printArray.toString();
  }

  public int getSize() {
    return size;
  }

  public boolean contain(K key){
    return get(key)!= null;
  }

  public List<K> keySet(){
    List<K> keyList = new ArrayList<>();
    for (Node<K,V> node : array){
      if (node!=null){
        if (node.getKey()!=null){
          keyList.add(node.getKey());
        }
      }
    }
    return keyList;
  }

}
