package codechallenges;

import Trees.data.Node;
import Trees.types.BinarySearchTree;
import Trees.types.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TreeTest {

    BinaryTree<Integer> emptyBinaryTree = new BinaryTree<>();
    BinaryTree<Integer> singleRootBinaryTree = new BinaryTree<>();
    BinaryTree<Integer> insertBinaryTree = new BinaryTree<>();

    BinarySearchTree<Integer> emptyBinarySearchTree = new BinarySearchTree<>();
    BinarySearchTree<Integer> singleRootSearchBinaryTree = new BinarySearchTree<>();
    BinarySearchTree<Integer> insertBinarySearchTree = new BinarySearchTree<>();

    @Before
    public void init() {
        singleRootBinaryTree.setRoot(new Node<>(10));

        insertBinaryTree.setRoot(new Node<>(1));
        insertBinaryTree.getRoot().setLeft(new Node<>(2));
        insertBinaryTree.getRoot().setRight(new Node<>(3));
        insertBinaryTree.getRoot().getLeft().setLeft(new Node<>(4));
        insertBinaryTree.getRoot().getLeft().setRight(new Node<>(27));

        singleRootSearchBinaryTree.add(30);

        insertBinarySearchTree.add(5);
        insertBinarySearchTree.add(2);
        insertBinarySearchTree.add(8);
        insertBinarySearchTree.add(30);
        insertBinarySearchTree.add(10);
    }

    @Test
    public void testEmptyBinaryTree() {
        assertNull(emptyBinaryTree.getRoot().getData());
    }

    @Test
    public void testSingleRootBinaryTree() {
        assertNotNull(singleRootBinaryTree.getRoot().getData());
    }

    @Test
    public void testBinaryTreeInOrderTraverse() {
        assertEquals("4 2 27 1 3 ", insertBinaryTree.inOrderTraverse(insertBinaryTree.getRoot()));
    }

    @Test
    public void testBinaryTreePostOrderTraverse() {
        assertEquals("4 27 2 3 1 ", insertBinaryTree.postOrderTraverse(insertBinaryTree.getRoot()));
    }

    @Test
    public void testBinaryTreePreOrderTraverse() {
        assertEquals("1 2 4 27 3 ", insertBinaryTree.preOrderTraverse(insertBinaryTree.getRoot()));
    }

    @Test
    public void testEmptyBinarySearchTree() {
        assertNull(emptyBinarySearchTree.getRoot().getData());
    }

    @Test
    public void testSingleRootSearchBinaryTree() {
        assertNotNull(singleRootSearchBinaryTree.getRoot().getData());
    }

    @Test
    public void testBinarySearchTreeInOrderTraverse() {
        assertEquals("2 5 8 10 30 ", insertBinarySearchTree.inOrderTraverse(insertBinarySearchTree.getRoot()));
    }

    @Test
    public void testBinarySearchTreePostOrderTraverse() {
        assertEquals("2 10 30 8 5 ", insertBinarySearchTree.postOrderTraverse(insertBinarySearchTree.getRoot()));
    }

    @Test
    public void testBinarySearchTreePreOrderTraverse() {
        assertEquals("5 2 8 30 10 ", insertBinarySearchTree.preOrderTraverse(insertBinarySearchTree.getRoot()));
    }

    @Test
    public void testGetMaxEmpty() {
        assertNull(emptyBinaryTree.getMax());
        assertNull(emptyBinarySearchTree.getMax());
    }

    @Test
    public void testGetMaxSingleRoot() {
        assertEquals(10, (int) singleRootBinaryTree.getMax());
        assertEquals(30, (int) singleRootSearchBinaryTree.getMax());
    }

    @Test
    public void testGetMaxMultInsert() {
        assertEquals(27, (int) insertBinaryTree.getMax());
        assertEquals(30, (int) insertBinarySearchTree.getMax());
    }

    @Test
    public void testBreadthFirstEmpty() {
        assertEquals("Queue list is empty",emptyBinaryTree.breadthFirst().toString());
        assertEquals("Queue list is empty", emptyBinarySearchTree.breadthFirst().toString());
    }

    @Test
    public void testBreadthFirstSingleRoot() {
        assertEquals("{10}-> {null}-> NULL", singleRootBinaryTree.breadthFirst().toString());
        assertEquals("{30}-> {null}-> NULL", singleRootSearchBinaryTree.breadthFirst().toString());
    }

    @Test
    public void testBreadthFirstInsert() {
        assertEquals("{1}-> {2}-> {3}-> {4}-> {27}-> NULL", insertBinaryTree.breadthFirst().toString());
        assertEquals("{5}-> {2}-> {8}-> {30}-> {10}-> NULL", insertBinarySearchTree.breadthFirst().toString());
    }

    @Test
    public void testFizzBuzzIsEmptyTree() {
        assertNull(emptyBinaryTree.fizzBuzz(emptyBinaryTree).getRoot().getData());
        assertNull(emptyBinarySearchTree.fizzBuzz(emptyBinarySearchTree).getRoot().getData());
    }

    @Test
    public void testFizzBuzzNotEmptyTree() {
        assertNotNull(singleRootBinaryTree.fizzBuzz(singleRootBinaryTree).getRoot().getData());
        assertNotNull(singleRootSearchBinaryTree.fizzBuzz(singleRootSearchBinaryTree).getRoot().getData());
    }

    @Test
    public void testFizzBuzz() {
        assertEquals("{1}-> {2}-> {4}-> {Fizz}-> {Fizz}-> NULL", insertBinaryTree.fizzBuzz(insertBinaryTree).print().toString());
        assertEquals("{Buzz}-> {2}-> {8}-> {FizzBuzz}-> {Buzz}-> NULL", insertBinarySearchTree.fizzBuzz(insertBinarySearchTree).print().toString());
    }
}
