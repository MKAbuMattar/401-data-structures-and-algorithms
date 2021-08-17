package LeftJoin;

//import java.util.*;

import HashMap.types.HashMap;

import java.util.ArrayList;
import java.util.List;

public class LeftJoin {

//  public HashMap<String, String[]> leftJoin(
//      HashMap<String, String> firstHashMap,
//      HashMap<String, String> secondHashMap
//  ) {
//
//    HashMap<String, String[]> result = new HashMap<>();
//
//    for (Map.Entry<String, String> tempNode : firstHashMap.entrySet()) {
//
//      String firstMapValues = tempNode.getValue();
//
//      String secondMapValues = secondHashMap.get(tempNode.getKey());
//
//      String[] joinedValues = {firstMapValues, secondMapValues};
//
//      result.put(tempNode.getKey(), joinedValues);
//    }
//    return result;
//  }

  public List<String[]> leftJoin(
      HashMap<String,String> firstHashMap,
      HashMap<String,String> secondHashMap
  ){

    List<String[]> result = new ArrayList<>();

    List<String> firstMapKeys = firstHashMap.keySet();

    if(firstMapKeys.size()>0){
      for (String key : firstMapKeys){
        if (secondHashMap.contain(key)){
          String[] joinedValues = {key ,firstHashMap.get(key) , secondHashMap.get(key)};
          result.add(joinedValues);
        } else {
          String[] joinedValues = {key ,firstHashMap.get(key),"NULL"};
          result.add(joinedValues);
        }
      }
    }

    return (result != null) ? result : null ;
  }

}
