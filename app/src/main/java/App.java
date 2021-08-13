import HashTable.types.HashTable;
import LinkedList.types.LinkedList;

import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    HashTable<Integer> map = new HashTable<>();
    map.add("this", 1);
    map.add("coder", 2);
    map.add("this", 4);
    map.add("hi", 5);
    System.out.println(map.getSize());
    System.out.println(map.remove("this"));
    System.out.println(map.getSize());
    System.out.println(map.isEmpty());
  }
}
