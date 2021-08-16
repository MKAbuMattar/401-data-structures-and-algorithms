package trees.types;

import trees.data.KNode;

public class KAryTree<T> {
  KNode<T> root = new KNode<>();

  public KAryTree() {
  }

  public KNode<T> getRoot() {
    return this.root;
  }

  public void setRoot(KNode<T> root) {
    this.root = root;
  }

  public int getNumberOfNodes() {
    int numberOfNodes = 0;

    if (root != null) {
      numberOfNodes = getNumberOfNodes(root) + 1;
    }

    return numberOfNodes;
  }

  private int getNumberOfNodes(KNode<T> node) {
    int k = node.getChildren().size(); // k = number of nodes

    for (KNode<T> child : node.getChildren()) {
      k += getNumberOfNodes(child);
    }

    return k;
  }
}
