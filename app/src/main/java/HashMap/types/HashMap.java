package HashMap.types;

import HashMap.data.Node;

public class HashMap<K,V> {

  private Node<K,V>[] array;
  private int size;

  public HashMap() {
    array = new Node[10];
  }

  public V put(K key, V value) {
    int index = getIndex(key);
    while(true) {
      if(array[index] == null) {
        Node<K,V> add = new Node<>(key, value);
        array[index] = add;
        ++size;
        checkForExpansion();
        return null;
      } else if(array[index].getKey().equals(key)) {
        V old = array[index].getValue();
        array[index] = new Node<>(key, value);
        return old;
      } else {
        index = incIndex(index);
      }
    }
  }

  public V get(K key) {
    int index = getIndex(key);
    while(true) {
      if(array[index] == null) {
        return null;
      } else if(array[index].getKey().equals(key)) {
        return array[index].getValue();
      } else {
        index = incIndex(index);
      }
    }
  }

  private int incIndex(int index) {
    ++index;
    if(index >= array.length) {
      index = 0;
    }
    return index;
  }

  private int getIndex(K key) {
    return Math.abs(key.hashCode()) % array.length;
  }

  private void checkForExpansion() {
    if((size * 10) / array.length > 2) {
      Node<K,V>[] old = array;
      array = new Node[array.length*2];
      size = 0;
      for (Node<K, V> newNode : old) {
        if (newNode != null) {
          put(newNode.getKey(), newNode.getValue());
        }
      }
    }
  }

}
