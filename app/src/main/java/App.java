import HashMap.types.HashMap;
import LeftJoin.LeftJoin;

import java.util.Arrays;
import java.util.List;

//import java.util.*;


public class App {
  public static void main(String[] args) {
    HashMap<String, String> map1 = new HashMap<>();
    HashMap<String, String> map2 = new HashMap<>();

    map1.put("fond","enamored");
    map1.put("wrath","anger");
    map1.put("diligent","employed");
    map1.put("outift","grab");
    map1.put("guide","usher");

    map2.put("fond","averse");
    map2.put("wrath","delight");
    map2.put("diligent","idle");
    map2.put("guide","follow");
    map2.put("flow","jam");

    LeftJoin lj = new LeftJoin();

    List<String[]> list = lj.leftJoin(map1,map2);
    System.out.println(Arrays.toString(list.get(2)));

//    for (String[] item : list){
//      System.out.println(Arrays.toString(item));
//    }



  }
}
