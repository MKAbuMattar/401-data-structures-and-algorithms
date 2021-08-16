package HashMapTreeIntersection;

import HashMap.Implement.ImplementHashMap;
import StackAndQueue.types.Queue;
import Trees.types.BinarySearchTree;

public class HashMapTreeIntersection {

  public ImplementHashMap<Integer> hashMapTreeIntersection(
      BinarySearchTree<Integer> firstTree,
      BinarySearchTree<Integer> secondTree
  ) {

    Queue<Integer> firstTreeValues = firstTree.breadthFirst();
    Queue<Integer> firstTreeValuesTemp = firstTree.breadthFirst();
    Queue<Integer> secondTreeValues = secondTree.breadthFirst();

    ImplementHashMap<Integer> firstTreeHashMap = new ImplementHashMap<>();

    while(!firstTreeValues.isEmpty()) {
      firstTreeHashMap.add(firstTreeValues.dequeue());
    }

    ImplementHashMap<Integer> secondTreeHashMap = new ImplementHashMap<>();

    while(!secondTreeValues.isEmpty()) {
      secondTreeHashMap.add(secondTreeValues.dequeue());
    }

    ImplementHashMap<Integer> intersections = new ImplementHashMap<>();

    for(int i = 0; i <= firstTreeHashMap.getSize(); i++) {
      int temp = 0;
      if(firstTreeValuesTemp.peek() != null){
        temp = firstTreeValuesTemp.dequeue();
      }
      
      if(secondTreeHashMap.contains(temp)){
        intersections.add(temp);
      }
    }

    return intersections;
  }
}
