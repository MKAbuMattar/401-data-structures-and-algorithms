package LeftJoin;

import java.util.*;

public class LeftJoin {

  public HashMap<String, String[]> leftJoin(
      HashMap<String, String> firstHashMap,
      HashMap<String, String> secondHashMap
  ) {

    HashMap<String, String[]> result = new HashMap<>();

    for (Map.Entry<String, String> tempNode : firstHashMap.entrySet()) {

      String firstMapValues = tempNode.getValue();

      String secondMapValues = secondHashMap.get(tempNode.getKey());

      String[] joinedValues = {firstMapValues, secondMapValues};

      result.put(tempNode.getKey(), joinedValues);
    }
    return result;
  }

}
