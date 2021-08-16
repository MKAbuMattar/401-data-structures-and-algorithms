/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package trees;

import trees.data.Node;
import trees.types.BinarySearchTree;
import trees.types.BinaryTree;

public class App {

  private static final BinaryTree<Integer> binaryTree = new BinaryTree<>();
  private static final BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

  public static void main(String[] args) {

    binaryTree.setRoot(new Node<>(1));
    binaryTree.getRoot().setLeft(new Node<>(2));
    binaryTree.getRoot().setRight(new Node<>(3));
    binaryTree.getRoot().getLeft().setLeft(new Node<>(4));

    binarySearchTree.add(5);
    binarySearchTree.add(3);
    binarySearchTree.add(8);
    binarySearchTree.add(1);
    binarySearchTree.add(3);
    binarySearchTree.add(9);
    binarySearchTree.add(15);
    binarySearchTree.add(-1);

//        System.out.println(binaryTree.breadthFirst());

    System.out.println(binaryTree.fizzBuzz(binaryTree).print());
  }
}
