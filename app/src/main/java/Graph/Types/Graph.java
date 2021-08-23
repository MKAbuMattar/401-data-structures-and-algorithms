package Graph.Types;

import Graph.Data.Edge;
import HashMap.Implement.ImplementHashMap;
import HashMap.types.HashMap;
import LinkedList.types.LinkedList;
import StackAndQueue.types.Queue;
import StackAndQueue.types.Stack;

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

  public Queue<T> breadthFirst() {

    T node;

    if(!Objects.equals(getNodes().toString(), "[]")){
      node = getNodes().get(0);
    } else {
      return null;
    }


    if (!nodes.contain(node)) {
      return null;
    }

    Queue<T> nodesToProcess = new Queue<>();

    ImplementHashMap<T> nodesSeen = new ImplementHashMap<>();

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

  public Queue<T> breadthFirstTraversal(T node) {

    if (!nodes.contain(node)) {
      return null;
    }

    Queue<T> nodesToProcess = new Queue<>();

    ImplementHashMap<T> nodesSeen = new ImplementHashMap<>();

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

  public String businessTrip(Graph<String, Integer> graph, String[] connections) {

    String result = "";
    boolean pathExists = true;
    Integer cost = 0;

    if (connections.length <= 1) {
      pathExists = false;
    } else {

      for (String conn : connections) {
        if (!graph.getNodes().contains(conn)) {
          pathExists = false;
        }
      }

      for (int i = 0; i < connections.length - 1 && pathExists; i++) {

        LinkedList<Edge<String, Integer>> links = graph.getNeighbors(connections[i]);

        pathExists = false;

        for (int j = 0; j < links.getSize(); j++) {

          Edge<String, Integer> link = links.get(j);

          if (link.getValue().equals(connections[i + 1])) {

            pathExists = true;
            cost += link.getWeight();

          }

        }
      }

    }

    if (pathExists) {
      result = "True, $" + cost;
    } else {
      result = "False, $" + cost;
    }

    return result;
  }

}
