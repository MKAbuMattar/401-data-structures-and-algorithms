import types.LinkedList;

public class Main {
  private static final LinkedList<Integer> list = new LinkedList<>();
  private static final LinkedList<String> list2 = new LinkedList<>();
  public static void main(String[] args) {

    System.out.println("Integer");

    list.add(1);
    list.add(2);
    list.add(3);

    list.insert(4);
    list.insert(5);
    list.insert(6);

    System.out.println("If value is include at linked list!! \uD83E\uDD14 " + list.includes(15));
    System.out.println(list);

    System.out.println("\n");

    System.out.println("String");

    list2.add("Mohammad");
    list2.add("Ali");
    list2.add("Jon");

    list2.insert("Rana");
    list2.insert("Aya");
    list2.insert("Khaled");
    System.out.println("If value is include at linked list!! \uD83E\uDD14 " + list2.includes("Khaled"));
    System.out.println(list2);
  }
}
