import HashTable.types.HashTable;

public class App {
  public static void main(String[] args) {
    HashTable<Integer> map = new HashTable<>();
    map.add("1", 1);
    map.add("2", 2);
    map.add("3", 3);
    System.out.println(map.getSize());
    System.out.println(map.get("1"));
    System.out.println(map.remove("1"));
    System.out.println(map.getSize());
    System.out.println(map.get("1"));
    System.out.println(map.get("2"));
    System.out.println(map.get("3"));
  }
}
