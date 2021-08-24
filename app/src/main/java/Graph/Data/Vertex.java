package Graph.Data;

public class Vertex<T, W> {

  private T value;
  private W weight;

  public Vertex(T value) {
    this.value = value;
  }

  public Vertex(T value, W weight) {
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
