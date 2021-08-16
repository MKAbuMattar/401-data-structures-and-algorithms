import HashMapTreeIntersection.HashMapTreeIntersection;
import HashTable.types.HashTable;
import RepeatedWord.RepeatedWord;
import Trees.types.BinarySearchTree;


public class App {
  public static void main(String[] args) {

    BinarySearchTree<Integer> intFirstTree = new BinarySearchTree<>();
    BinarySearchTree<Integer> intSecondTree = new BinarySearchTree<>();

    intFirstTree.add(1);
    intFirstTree.add(2);
    intFirstTree.add(3);
    intFirstTree.add(4);
    intFirstTree.add(5);
    intSecondTree.add(18);
    intSecondTree.add(5);
    intSecondTree.add(30);
    intSecondTree.add(10);
    intSecondTree.add(2);

    HashMapTreeIntersection hashMapTreeIntersection = new HashMapTreeIntersection();

    System.out.println(hashMapTreeIntersection.hashMapTreeIntersection(intFirstTree, intSecondTree));

  }
}
