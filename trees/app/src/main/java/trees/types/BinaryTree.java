package trees.types;

import trees.data.Node;

public class BinaryTree<T extends Comparable<T>> {
    Node<T> root;
    StringBuilder dataOfBinaryTree = new StringBuilder();
//    private T max = null;
    private int max = 0;

    public BinaryTree() {
        root = new Node<T>();
    }

    public Node<T> getRoot() {
        if(root == null) {
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

//    public T getMax(){
//        if (root != null){
//            max = swap(root);
//        }
//        return max;
//    }
//
//    private T swap(Node<T> root){
//        if ((root.getRight() == null) && (root.getLeft() == null)){
//            if (max.compareTo(root.getData()) > 0){
//                max = root.getData();
//            }
//        }
//
//        if (root.getRight() != null){
//            swap(root.getRight());
//        }
//
//        if (root.getLeft() != null){
//            swap(root.getLeft());
//        }
//
//        return max;
//    }

    public Number getMax(){
        if (root.getData() != null){
            max = (int) swap(root);
        }
        return max;
    }

    private Number swap(Node node){
        if ((node.getRight() == null) && (node.getLeft() == null)){
            if (max < (int) node.getData()){
                max = (int) node.getData();
            }
        }

        if (node.getRight() != null){
            swap(node.getRight());
        }

        if (node.getLeft() != null){
            swap(node.getLeft());
        }

        return max;
    }
}
