package trees.types;

import queue.types.Queue;
import trees.data.Node;

public class BinaryTree<T extends Comparable<T>> {
  Node<T> root;
  StringBuilder dataOfBinaryTree = new StringBuilder();
  private T max = null;

  public BinaryTree() {
    root = new Node<T>();
  }

  public Node<T> getRoot() {
    if (root == null) {
      return null;
    }
    return root;
  }

  public void setRoot(Node<T> root) {
    this.root = root;
  }

  public String inOrderTraverse(Node<T> node) {
    if (node != null) {
      inOrderTraverse(node.getLeft()); // traverse left sub tree
      dataOfBinaryTree.append(node.getData()).append(" "); // root
      inOrderTraverse(node.getRight()); // traverse right sub tree
    }

    return dataOfBinaryTree.toString();
  }

  public String postOrderTraverse(Node<T> node) {
    if (node != null) {
      postOrderTraverse(node.getLeft()); // traverse left sub tree
      postOrderTraverse(node.getRight()); // traverse right sub tree
      dataOfBinaryTree.append(node.getData()).append(" ");// root
    }
    return dataOfBinaryTree.toString();
  }

  public String preOrderTraverse(Node<T> node) {
    if (node != null) {
      dataOfBinaryTree.append(node.getData()).append(" "); // root
      preOrderTraverse(node.getLeft()); // traverse left sub tree
      preOrderTraverse(node.getRight()); // traverse right sub tree
    }
    return dataOfBinaryTree.toString();
  }

  public T getMax() {
    if (root.getData() != null) {
      max = root.getData();
      max = swap(root);
    }
    return max;
  }

  private T swap(Node<T> root) {
    if (max.compareTo(root.getData()) < 0) {
      max = root.getData();
    }

    if (root.getRight() != null) {
      swap(root.getRight());
    }

    if (root.getLeft() != null) {
      swap(root.getLeft());
    }

    return max;
  }

  public Queue<T> breadthFirst() {

    Queue<Node<T>> tempRoot = new Queue<>();

    Queue<T> root = new Queue<>();

    Node<T> current = this.getRoot();

    if (current != null) {
      tempRoot.enqueue(this.getRoot());
    }

    while (!tempRoot.isEmpty()) {

      current = tempRoot.dequeue();
      root.enqueue(current.getData());

      if (current.getLeft() != null) {
        tempRoot.enqueue(current.getLeft());
      }

      if (current.getRight() != null) {
        tempRoot.enqueue(current.getRight());
      }
    }

    return root;
  }

  public BinaryTree<String> fizzBuzz(BinaryTree<Integer> tree) {

    BinaryTree<String> newTree = new BinaryTree<>();

    if (tree.getRoot().getData() != null) {
      traverseFizzBuzzTree(tree.getRoot(), newTree.getRoot());
    }

    return newTree;
  }

  private void traverseFizzBuzzTree(Node<Integer> root, Node<String> newRoot) {

    if (root.getData() % 15 == 0) {
      newRoot.setData("FizzBuzz");
    } else if (root.getData() % 5 == 0) {
      newRoot.setData("Buzz");
    } else if (root.getData() % 3 == 0) {
      newRoot.setData("Fizz");
    } else {
      newRoot.setData(root.getData().toString());
    }

    if (root.getLeft() != null) {
      newRoot.setLeft(new Node<>());
      traverseFizzBuzzTree(root.getLeft(), newRoot.getLeft());
    }

    if (root.getRight() != null) {
      newRoot.setRight(new Node<>());
      traverseFizzBuzzTree(root.getRight(), newRoot.getRight());
    }
  }

  public Queue<T> print() {
    Queue<T> data = new Queue<>();

    traversePrint(this.getRoot(), data);

    return data;
  }

  private void traversePrint(Node<T> root, Queue<T> data) {

    data.enqueue(root.getData());

    if (root.getLeft() != null) {
      traversePrint(root.getLeft(), data);
    }
    if (root.getRight() != null) {
      traversePrint(root.getRight(), data);
    }
  }

}
