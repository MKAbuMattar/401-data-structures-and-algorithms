import types.LinkedList;

public class Main {
  private static final LinkedList<Integer> list = new LinkedList<>();
  private static final LinkedList<String> list2 = new LinkedList<>();
  public static void main(String[] args) {

//    long startTime, stopTime;

    System.out.println("Type of linked list is integer");

//    startTime = System.currentTimeMillis();
    list.add(1);
//    stopTime = System.currentTimeMillis();
//    System.out.println("execution time for method add "+ (stopTime - startTime) + "ms");

    list.add(2);
    list.add(3);

//    startTime = System.currentTimeMillis();
    list.insert(4);
//    stopTime = System.currentTimeMillis();
//    System.out.println("execution time for method insert " + (stopTime - startTime) + "ms");

    list.insert(5);
    list.insert(6);

//    startTime = System.currentTimeMillis();
    System.out.println("If value is include at linked list!! \uD83E\uDD14 " + list.includes(15));
//    stopTime = System.currentTimeMillis();
//    System.out.println("execution time for method includes " + (stopTime - startTime) + "ms");



//    startTime = System.currentTimeMillis();
    System.out.println(list);
//    list.insertAfter(2,55);
//    System.out.println("insert after 2: "+list);
//    list.insertBefore(2,66);
//    System.out.println("insert before 2: " +list);

    System.out.println(list.kthFromEnd(12));
//    stopTime = System.currentTimeMillis();
//    System.out.println("execution time for method toString "+ (stopTime - startTime) + "ms");
  }
}
