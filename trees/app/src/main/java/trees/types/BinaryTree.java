package trees.types;

import trees.data.Node;

public class BinaryTree<T> {
    Node<T> root;
    StringBuilder dataOfBinaryTree = new StringBuilder();

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

    public String inOrderTraverse(Node<T> node) {
        if (node != null) {
            inOrderTraverse(node.getLeft()); // traverse left sub tree
            dataOfBinaryTree.append(node.getData()).append(" "); // root
            inOrderTraverse(node.getRight()); // traverse right sub tree
        }

        return dataOfBinaryTree.toString();
    }

    public String postOrderTraverse(Node<T>  node) {
        if (node != null) {
            postOrderTraverse(node.getLeft()); // traverse left sub tree
            postOrderTraverse(node.getRight()); // traverse right sub tree
            dataOfBinaryTree.append(node.getData()).append(" ");// root
        }
        return dataOfBinaryTree.toString();
    }

    public String preOrderTraverse(Node<T>  node) {
        if (node != null) {
            dataOfBinaryTree.append(node.getData()).append(" "); // root
            preOrderTraverse(node.getLeft()); // traverse left sub tree
            preOrderTraverse(node.getRight()); // traverse right sub tree
        }
        return dataOfBinaryTree.toString();
    }
}
