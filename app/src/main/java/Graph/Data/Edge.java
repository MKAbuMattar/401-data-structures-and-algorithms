package Graph.Data;

public class Edge<T, W> {

  private T value;
  private W weight;

  public Edge(T value) {
    this.value = value;
  }

  public Edge(T value, W weight) {
    this.value = value;
    this.weight = weight;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public W getWeight() {
    return weight;
  }

  public void setWeight(W weight) {
    this.weight = weight;
  }
}
