package codechallenges;

import Graph.Types.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {


  Graph<Integer, Integer> emtpy;
  Graph<String, Integer> airports;
  Graph<Integer, Double> busStops;

  @Before
  public void init(){

    emtpy = new Graph<>();
    airports = new Graph<>();
    airports.addNode("Amman");
    airports.addNode("Aqaba");
    airports.addNode("Assab");
    airports.addNode("Azraq");
    airports.addNode("Dafyanah");
    airports.addNode("Mafraq");
    airports.addEdge("Amman", "Queen Alia International Airport", 730);
    airports.addEdge("Amman", "Amman Civil Airport", 779);
    airports.addEdge("Aqaba", "King Hussein International Airport", 53);
    airports.addEdge("Assab", "H-4 Air Base", 681);
    airports.addEdge("Azraq", "Muwaffaq Salti Air Base", 519);
    airports.addEdge("Dafyanah", "Prince Hassan Air Base", 676);
    airports.addEdge("Mafraq", "King Hussein Air Base", 683);

    busStops = new Graph<>();
    busStops.addNode(1);
    busStops.addNode(2);
    busStops.addNode(3);
    busStops.addNode(4);
    busStops.addNode(5);
    busStops.addEdge(1, 2);
    busStops.addEdge(2, 3);
    busStops.addEdge(3, 4);
    busStops.addEdge(4, 5);
    busStops.addEdge(5, 1);
  }

  @Test
  public void TestGetSize() {
    assertEquals(6, airports.getSize());
    assertNotEquals(8, airports.getSize());
    assertEquals(5, busStops.getSize());
    assertNotEquals(8, busStops.getSize());
    assertEquals(0, emtpy.getSize());
  }

  @Test
  public void TestGetNodes() {
    assertTrue(busStops.getNodes().contains(1));
    assertFalse(busStops.getNodes().contains(44));
    assertTrue(busStops.getNodes().contains(2));
    assertFalse(busStops.getNodes().contains(-100));
    assertFalse(emtpy.getNodes().contains(0));
  }

  @Test
  public void getNeighborsTest() {
    assertEquals((Integer) 2, busStops.getNeighbors(1).get(0).getValue());
    assertEquals(1, busStops.getNeighbors(5).getSize());
    assertNull(emtpy.getNeighbors(0));
  }
}
