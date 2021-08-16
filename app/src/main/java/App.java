import HashMapTreeIntersection.HashMapTreeIntersection;
import HashTable.types.HashTable;
import RepeatedWord.RepeatedWord;
import Trees.types.BinarySearchTree;


public class App {
  public static void main(String[] args) {

    BinarySearchTree<Integer> intFirstTree = new BinarySearchTree<>();
    BinarySearchTree<Integer> intSecondTree = new BinarySearchTree<>();

    intFirstTree.add(150);
    intFirstTree.add(100);
    intFirstTree.add(250);
    intFirstTree.add(75);
    intFirstTree.add(160);
    intFirstTree.add(200);
    intFirstTree.add(350);
    intFirstTree.add(125);
    intFirstTree.add(175);
    intFirstTree.add(300);
    intFirstTree.add(500);

    intSecondTree.add(42);
    intSecondTree.add(100);
    intSecondTree.add(600);
    intSecondTree.add(200);
    intSecondTree.add(350);
    intSecondTree.add(125);
    intSecondTree.add(175);
    intSecondTree.add(4);
    intSecondTree.add(500);

    HashMapTreeIntersection hashMapTreeIntersection = new HashMapTreeIntersection();

    System.out.println(hashMapTreeIntersection.hashMapTreeIntersection(intFirstTree, intSecondTree));

  }
}
