package codechallenges;

import HashMapTreeIntersection.HashMapTreeIntersection;
import Trees.types.BinarySearchTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashMapTreeIntersectionTest {

  BinarySearchTree<Integer> intEmptyFirstTree;
  BinarySearchTree<Integer> intEmptySecondTree;

  BinarySearchTree<Integer> intFirstTree;
  BinarySearchTree<Integer> intSecondTree;

  BinarySearchTree<Integer> intNoDuplicateFirstTree;
  BinarySearchTree<Integer> intNoDuplicateSecondTree;

  BinarySearchTree<Integer> intNegativeNumberFirstTree;
  BinarySearchTree<Integer> intNegativeNumberSecondTree;

  HashMapTreeIntersection hashMapTreeIntersection;

  @Before
  public void init() {
    intEmptyFirstTree = new BinarySearchTree<>();
    intEmptySecondTree = new BinarySearchTree<>();

    intFirstTree = new BinarySearchTree<>();
    intSecondTree = new BinarySearchTree<>();

    intNoDuplicateFirstTree = new BinarySearchTree<>();
    intNoDuplicateSecondTree = new BinarySearchTree<>();

    intNegativeNumberFirstTree = new BinarySearchTree<>();
    intNegativeNumberSecondTree = new BinarySearchTree<>();

    hashMapTreeIntersection = new HashMapTreeIntersection();

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

    intNoDuplicateFirstTree.add(1);
    intNoDuplicateFirstTree.add(20);
    intNoDuplicateFirstTree.add(3);
    intNoDuplicateFirstTree.add(4);
    intNoDuplicateFirstTree.add(5);
    intNoDuplicateSecondTree.add(18);
    intNoDuplicateSecondTree.add(9);
    intNoDuplicateSecondTree.add(30);
    intNoDuplicateSecondTree.add(10);
    intNoDuplicateSecondTree.add(12);

    intNegativeNumberFirstTree.add(150);
    intNegativeNumberFirstTree.add(100);
    intNegativeNumberFirstTree.add(250);
    intNegativeNumberFirstTree.add(75);
    intNegativeNumberFirstTree.add(160);
    intNegativeNumberFirstTree.add(-200);
    intNegativeNumberFirstTree.add(-350);
    intNegativeNumberFirstTree.add(125);
    intNegativeNumberFirstTree.add(-175);
    intNegativeNumberFirstTree.add(300);
    intNegativeNumberFirstTree.add(500);
    intNegativeNumberSecondTree.add(42);
    intNegativeNumberSecondTree.add(100);
    intNegativeNumberSecondTree.add(1);
    intNegativeNumberSecondTree.add(-200);
    intNegativeNumberSecondTree.add(-350);
    intNegativeNumberSecondTree.add(125);
    intNegativeNumberSecondTree.add(-175);
    intNegativeNumberSecondTree.add(4);
    intNegativeNumberSecondTree.add(500);
  }


  @Test
  public void testEmptyHashMapTreeIntersectionTest() {
    assertEquals("[]",
        hashMapTreeIntersection
            .hashMapTreeIntersection(intEmptyFirstTree, intEmptySecondTree)
            .toString()
    );
  }

  @Test
  public void testNotEmptyHashMapTreeIntersectionTest() {
    assertEquals("[200,125,175,100,500,350]",
        hashMapTreeIntersection
            .hashMapTreeIntersection(intFirstTree, intSecondTree)
            .toString()
    );
  }

  @Test
  public void testNoDuplicateHashMapTreeIntersectionTest() {
    assertEquals("[]",
        hashMapTreeIntersection
            .hashMapTreeIntersection(intNoDuplicateFirstTree, intNoDuplicateSecondTree)
            .toString()
    );
  }

  @Test
  public void testNegativeNumberHashMapTreeIntersectionTest() {
    assertEquals("[-200,125,-175,100,500,-350]",
        hashMapTreeIntersection
            .hashMapTreeIntersection(intNegativeNumberFirstTree, intNegativeNumberSecondTree)
            .toString()
    );
  }
}
