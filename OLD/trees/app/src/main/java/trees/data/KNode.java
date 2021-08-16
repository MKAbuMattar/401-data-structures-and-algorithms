package trees.data;

import java.util.ArrayList;
import java.util.List;

public class KNode<T> {
  private T data;
  private List<KNode<T>> children;
  private KNode<T> parent;


  public KNode() {
    children = new ArrayList<KNode<T>>();
  }

  public KNode(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public KNode<T> getParent() {
    return parent;
  }

  public void setParent(KNode<T> parent) {
    this.parent = parent;
  }


  public List<KNode<T>> getChildren() {
    return children;
  }

  public void setChildren(List<KNode<T>> children) {
    for (KNode<T> child : children) {
      child.parent = this;
    }

    this.children = children;
  }

  public boolean hasChildren() {
    return getChildren().size() > 0;
  }

  public void addChild(KNode<T> child) {
    child.parent = this;
    children.add(child);
  }

}
