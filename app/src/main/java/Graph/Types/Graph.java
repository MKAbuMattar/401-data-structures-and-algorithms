package Graph.Types;

import Graph.Data.Edge;
import HashMap.types.HashMap;
import LinkedList.types.LinkedList;
import StackAndQueue.types.Queue;

import java.util.*;


public class Graph<T, W> {

  private HashMap<T, LinkedList<Edge<T, W>>> nodes;
  private long size;

  public Graph() {
    nodes = new HashMap<>();
  }

  public long getSize() {
    return size;
  }

  public T addNode(T value) {
    nodes.put(value, new LinkedList<>());
    size++;
    return value;
  }

  public void addEdge(T firstNode, T secondValue) {
    if (!nodes.contain(firstNode) || !nodes.contain(secondValue)) {
      return;
    }

    nodes.get(firstNode).add(new Edge<T, W>(secondValue));
    nodes.get(secondValue).add(new Edge<T, W>(firstNode));
  }

  public void addEdge(T firstNode, T secondValue, W weight){
    if (!nodes.contain(firstNode) || !nodes.contain(secondValue)) {
      return;
    }

    nodes.get(firstNode).add(new Edge<T, W>(secondValue, weight));
    nodes.get(secondValue).add(new Edge<T, W>(firstNode, weight));
  }

  public LinkedList<Edge<T, W>> getNeighbors(T node) {
    if (!nodes.contain(node)) {
      return null;
    }

    return nodes.get(node);
  }

  public List<T> getNodes() {
    return nodes.keySet();
  }

  public Queue<T> breadthFirstTraversal(T node) {

    if (!nodes.contain(node)) {
      return null;
    }

    Queue<T> nodesToProcess = new Queue<>();

    LinkedList<T> nodesSeen = new LinkedList<>();

    Queue<T> searchResults = new Queue<>();

    nodesSeen.add(node);
    nodesToProcess.enqueue(node);
    searchResults.enqueue(node);

    while (!nodesToProcess.isEmpty()) {

      LinkedList<Edge<T, W>> edges = nodes.get(nodesToProcess.dequeue());

      for (int i = 0; i < edges.getSize(); i++) {

        Edge<T, W> edge = edges.get(i);

        if (!nodesSeen.contains(edge.getValue())) {

          nodesToProcess.enqueue(edge.getValue());
          searchResults.enqueue(edge.getValue());
          nodesSeen.add(edge.getValue());

        }
      }
    }

    return searchResults;
  }

}
