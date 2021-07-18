package trees.types;

import trees.data.Node;

public class BinaryTree<T> {
    Node<T> root;

    public BinaryTree() {
        root = new Node<T>();
    }

    public Node<T> getRoot() {
        if(this.root == null) {
            return null;
        }
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void inOrderTraverse(Node<T> node) {
        if (node != null) {
            inOrderTraverse(node.getLeft()); // traverse left sub tree
            System.out.print(" " + node.getData()); // root
            inOrderTraverse(node.getRight()); // traverse right sub tree
        }
    }

    public void postOrderTraverse(Node<T>  node) {
        if (node != null) {
            postOrderTraverse(node.getLeft()); // traverse left sub tree
            postOrderTraverse(node.getRight()); // traverse right sub tree
            System.out.print(" " + node.getData()); // root
        }
    }

    public void preOrderTraverse(Node<T>  node) {
        if (node != null) {
            System.out.print(" " + node.getData()); // root
            preOrderTraverse(node.getLeft()); // traverse left sub tree
            preOrderTraverse(node.getRight()); // traverse right sub tree
        }
    }
}
