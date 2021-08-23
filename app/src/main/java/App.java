import Graph.Types.Graph;

//import java.util.*;


public class App {
  public static void main(String[] args) {

//    String str = "Once upon a time, there was a brave princess who... who";
//
//    RepeatedWord word = new RepeatedWord();
//
//    System.out.println("repeated word ==>> "+ word.repeatedWord(str));
//    System.out.println("repeated words ==>> "+ word.repeatedWords(str));
//    System.out.println("repeated words frequently ==>> "+ word.repeatedWordsFrequently(str));
//
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
//    System.out.println(Arrays.toString(list.get(4)));
//
////    for (String[] item : list){
////      System.out.println(Arrays.toString(item));
////    }

//    RepeatedWord rw = new RepeatedWord();
//    String str = "No. Try not. Do or do not. There is no try.";
//
//    System.out.println(rw.repeatedWord(str));

//    Graph<String, Integer> airports = new Graph<>();
//
//    airports = new Graph<>();
//    airports.addNode("Amman");
//    airports.addEdge("Amman", "Queen Alia International Airport", 730);
//    airports.addEdge("Amman", "Amman Civil Airport", 779);
//    airports.addNode("Aqaba");
//    airports.addEdge("Aqaba", "King Hussein International Airport", 53);
//    airports.addNode("Assab");
//    airports.addEdge("Assab", "H-4 Air Base", 681);
//    airports.addNode("Azraq");
//    airports.addEdge("Azraq", "Muwaffaq Salti Air Base", 519);
//    airports.addNode("Dafyanah");
//    airports.addEdge("Dafyanah", "Prince Hassan Air Base", 676);
//    airports.addNode("Mafraq");
//    airports.addEdge("Mafraq", "King Hussein Air Base", 683);
//
//    System.out.println(airports.getSize());
//    System.out.println(airports.getNeighbors("Amman"));


//    Graph<String, Integer> airports = new Graph<>();
//    airports.addNode("Amman - Queen Alia International Airport");
//    airports.addNode("Amman - Amman Civil Airport");
//    airports.addNode("Aqaba - King Hussein International Airport");
//    airports.addNode("Assab - H-4 Air Base");
//    airports.addNode("Azraq - Muwaffaq Salti Air Base");
//    airports.addNode("Dafyanah - Prince Hassan Air Base");
//    airports.addNode("Mafraq - King Hussein Air Base");
//
//    airports.addEdge(
//        "Amman - Queen Alia International Airport",
//        "Amman - Amman Civil Airport",
//        730
//    );
//    airports.addEdge(
//        "Amman - Queen Alia International Airport",
//        "Amman - Amman Civil Airport",
//        779
//    );
//    airports.addEdge(
//        "Amman - Queen Alia International Airport",
//        "Aqaba - King Hussein International Airport",
//        53
//    );
//    airports.addEdge(
//        "Amman - Amman Civil Airport",
//        "Amman - Queen Alia International Airport",
//        681
//    );
//    airports.addEdge(
//        "Amman - Amman Civil Airport",
//        "Aqaba - King Hussein International Airport",
//        681
//    );
//    airports.addEdge(
//        "Assab - H-4 Air Base",
//        "Amman - Queen Alia International Airport",
//        681
//    );
//    airports.addEdge(
//        "Assab - H-4 Air Base",
//        "Azraq - Muwaffaq Salti Air Base",
//        681
//    );
//    airports.addEdge(
//        "Azraq - Muwaffaq Salti Air Base",
//        "Amman - Queen Alia International Airport",
//        519
//    );
//    airports.addEdge(
//        "Azraq - Muwaffaq Salti Air Base",
//        "Aqaba - King Hussein International Airport",
//        519
//    );
//    airports.addEdge(
//        "Dafyanah - Prince Hassan Air Base",
//        "Assab - H-4 Air Base",
//        676
//    );
//    airports.addEdge(
//        "Mafraq - King Hussein Air Base",
//        "Assab - H-4 Air Base", 683
//    );
//    airports.addEdge(
//        "Mafraq - King Hussein Air Base",
//        "Dafyanah - Prince Hassan Air Base",
//        683
//    );
//    airports.addEdge(
//        "Aqaba - King Hussein International Airport",
//        "Amman - Queen Alia International Airport",
//        683
//    );
//    airports.addEdge(
//        "Aqaba - King Hussein International Airport",
//        "Mafraq - King Hussein Air Base",
//        683
//    );
//    airports.addEdge(
//        "Aqaba - King Hussein International Airport",
//        "Amman - Amman Civil Airport",
//        683
//    );
//
//    System.out.println(airports.breadthFirst("Azraq - Muwaffaq Salti Air Base"));

    Graph<String, Integer> test = new Graph<>();
    test.addNode("Pandora");
    test.addNode("Arendelle");
    test.addNode("Metroville");
    test.addNode("Monstropolis");
    test.addNode("Narnia");
    test.addNode("Naboo");

    test.addEdge("Pandora", "Arendelle", 150);
    test.addEdge("Pandora", "Metroville", 82);

    test.addEdge("Arendelle", "Pandora", 150);
    test.addEdge("Arendelle", "Metroville",99);
    test.addEdge("Arendelle", "Monstropolis",42);

    test.addEdge("Metroville", "Arendelle",99);
    test.addEdge("Metroville", "Monstropolis",105);
    test.addEdge("Metroville", "Narnia",37);
    test.addEdge("Metroville", "Naboo",26);

    test.addEdge("Monstropolis", "Arendelle",42);
    test.addEdge("Monstropolis", "Metroville",105);
    test.addEdge("Monstropolis", "Naboo",73);

    test.addEdge("Naboo", "Monstropolis",73);
    test.addEdge("Naboo", "Metroville",26);
    test.addEdge("Naboo", "Narnia",250);

    test.addEdge("Narnia", "Naboo",250);
    test.addEdge("Narnia", "Metroville",37);


    System.out.println(test.businessTrip(test, new String[]{"Metroville","Pandora"}));
    System.out.println(test.businessTrip(test, new String[]{"Arendelle","Monstropolis","Naboo"}));
    System.out.println(test.businessTrip(test, new String[]{"Naboo","Pandora"}));
    System.out.println(test.businessTrip(test, new String[]{"Narnia","Arendelle","Naboo"}));

  }
}
