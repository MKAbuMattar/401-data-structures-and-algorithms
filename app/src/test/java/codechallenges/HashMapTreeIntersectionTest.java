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

  HashMapTreeIntersection hashMapTreeIntersection;

  @Before
  public void init() {
    intEmptyFirstTree = new BinarySearchTree<>();
    intEmptySecondTree = new BinarySearchTree<>();

    intFirstTree = new BinarySearchTree<>();
    intSecondTree = new BinarySearchTree<>();

    intNoDuplicateFirstTree = new BinarySearchTree<>();
    intNoDuplicateSecondTree = new BinarySearchTree<>();

    hashMapTreeIntersection = new HashMapTreeIntersection();

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
    assertEquals("[2,5]",
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
}
