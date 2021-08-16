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
      if(secondTreeHashMap.contains(i)){
        intersections.add(i);
      }
    }

    return intersections;
  }
}
