import Graph.Types.Graph;

//import java.util.*;


public class App {
  public static void main(String[] args) {
//    HashMap<String, String> map1 = new HashMap<>();
//    HashMap<String, String> map2 = new HashMap<>();
//
//    map1.put("fond","enamored");
//    map1.put("wrath","anger");
//    map1.put("diligent","employed");
//    map1.put("outift","grab");
//    map1.put("guide","usher");
//
//    map2.put("fond","averse");
//    map2.put("wrath","delight");
//    map2.put("diligent","idle");
//    map2.put("guide","follow");
//    map2.put("flow","jam");
//
//    LeftJoin lj = new LeftJoin();
//
//    List<String[]> list = lj.leftJoin(map1,map2);
//    System.out.println(Arrays.toString(list.get(2)));
//
////    for (String[] item : list){
////      System.out.println(Arrays.toString(item));
////    }

//    RepeatedWord rw = new RepeatedWord();
//    String str = "No. Try not. Do or do not. There is no try.";
//
//    System.out.println(rw.repeatedWord(str));

    Graph<String, Integer> airports = new Graph<>();

    airports = new Graph<>();
    airports.addNode("Amman");
    airports.addEdge("Amman", "Queen Alia International Airport", 730);
    airports.addEdge("Amman", "Amman Civil Airport", 779);
    airports.addNode("Aqaba");
    airports.addEdge("Aqaba", "King Hussein International Airport", 53);
    airports.addNode("Assab");
    airports.addEdge("Assab", "H-4 Air Base", 681);
    airports.addNode("Azraq");
    airports.addEdge("Azraq", "Muwaffaq Salti Air Base", 519);
    airports.addNode("Dafyanah");
    airports.addEdge("Dafyanah", "Prince Hassan Air Base", 676);
    airports.addNode("Mafraq");
    airports.addEdge("Mafraq", "King Hussein Air Base", 683);

    System.out.println(airports.getSize());
    System.out.println(airports.getNeighbors("Amman"));

  }
}
