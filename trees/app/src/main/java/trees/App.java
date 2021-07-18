/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package trees;

import trees.types.BinarySearchTree;

public class App {

    private static final BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

    public static void main(String[] args) {

        binarySearchTree.add(5);
        binarySearchTree.add(3);
        binarySearchTree.add(8);
        binarySearchTree.add(1);
        binarySearchTree.add(7);

        System.out.println(binarySearchTree.contains(9));

        binarySearchTree.inOrderTraverse(binarySearchTree.getRoot());
        System.out.println("\n");
        binarySearchTree.postOrderTraverse(binarySearchTree.getRoot());
        System.out.println("\n");
        binarySearchTree.preOrderTraverse(binarySearchTree.getRoot());
    }
}
