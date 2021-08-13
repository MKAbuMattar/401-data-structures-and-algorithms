package Trees.types;


import Trees.data.Node;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

  public void add(T data) {
    traverse(this.getRoot(), data);
  }

  private void traverse(Node<T> root, T data) {
    if (root.getData() == null) {
      root.setData(data);
    } else if (data.compareTo(root.getData()) < 0) {
      if (root.getLeft() != null) {
        traverse(root.getLeft(), data);
      } else {
        root.setLeft(new Node<T>(data));
      }
    } else if (data.compareTo(root.getData()) > 0) {
      if (root.getRight() != null) {
        traverse(root.getRight(), data);
      } else {
        root.setRight(new Node<T>(data));
      }
    }
  }

  public boolean contains(T data) {
    return comparison(this.getRoot(), data);
  }

  private boolean comparison(Node<T> root, T data) {
    if (root == null) {
      return false;
    } else if (data.compareTo(root.getData()) == 0) {
      return true;
    } else if (data.compareTo(root.getData()) < 0) {
      return comparison(root.getLeft(), data);
    } else if (data.compareTo(root.getData()) > 0) {
      return comparison(root.getRight(), data);
    } else {
      return false;
    }
  }
}
