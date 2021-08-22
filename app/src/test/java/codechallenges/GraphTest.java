package codechallenges;

import Graph.Types.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {


  Graph<Integer, Integer> empty;
  Graph<String, Integer> airports;
  Graph<Integer, Double> busStops;

  @Before
  public void init(){

    empty = new Graph<>();
    airports = new Graph<>();
    airports.addNode("Amman - Queen Alia International Airport");
    airports.addNode("Amman - Amman Civil Airport");
    airports.addNode("Aqaba - King Hussein International Airport");
    airports.addNode("Assab - H-4 Air Base");
    airports.addNode("Azraq - Muwaffaq Salti Air Base");
    airports.addNode("Dafyanah - Prince Hassan Air Base");
    airports.addNode("Mafraq - King Hussein Air Base");

    airports.addEdge(
        "Amman - Queen Alia International Airport",
        "Amman - Amman Civil Airport",
        730
    );
    airports.addEdge(
        "Amman - Queen Alia International Airport",
        "Amman - Amman Civil Airport",
        779
    );
    airports.addEdge(
        "Amman - Queen Alia International Airport",
        "Aqaba - King Hussein International Airport",
        53
    );
    airports.addEdge(
        "Amman - Amman Civil Airport",
        "Amman - Queen Alia International Airport",
        681
    );
    airports.addEdge(
        "Amman - Amman Civil Airport",
        "Aqaba - King Hussein International Airport",
        681
    );
    airports.addEdge(
        "Assab - H-4 Air Base",
        "Amman - Queen Alia International Airport",
        681
    );
    airports.addEdge(
        "Assab - H-4 Air Base",
        "Azraq - Muwaffaq Salti Air Base",
        681
    );
    airports.addEdge(
        "Azraq - Muwaffaq Salti Air Base",
        "Amman - Queen Alia International Airport",
        519
    );
    airports.addEdge(
        "Azraq - Muwaffaq Salti Air Base",
        "Aqaba - King Hussein International Airport",
        519
    );
    airports.addEdge(
        "Dafyanah - Prince Hassan Air Base",
        "Assab - H-4 Air Base",
        676
    );
    airports.addEdge(
        "Mafraq - King Hussein Air Base",
        "Assab - H-4 Air Base", 683
    );
    airports.addEdge(
        "Mafraq - King Hussein Air Base",
        "Dafyanah - Prince Hassan Air Base",
        683
    );
    airports.addEdge(
        "Aqaba - King Hussein International Airport",
        "Amman - Queen Alia International Airport",
        683
    );
    airports.addEdge(
        "Aqaba - King Hussein International Airport",
        "Mafraq - King Hussein Air Base",
        683
    );
    airports.addEdge(
        "Aqaba - King Hussein International Airport",
        "Amman - Amman Civil Airport",
        683
    );

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
    assertEquals(7, airports.getSize());
    assertNotEquals(8, airports.getSize());
    assertEquals(5, busStops.getSize());
    assertNotEquals(8, busStops.getSize());
    assertEquals(0, empty.getSize());
  }

  @Test
  public void TestGetNodes() {
    assertTrue(busStops.getNodes().contains(1));
    assertFalse(busStops.getNodes().contains(44));
    assertTrue(busStops.getNodes().contains(2));
    assertFalse(busStops.getNodes().contains(-100));
    assertFalse(empty.getNodes().contains(0));
  }

  @Test
  public void getNeighborsTest() {
    assertEquals((Integer) 2, busStops.getNeighbors(1).get(0).getValue());
    assertEquals(1, busStops.getNeighbors(5).getSize());
    assertNull(empty.getNeighbors(0));
  }

  @Test
  public void breadthFirstTest() {
    assertEquals("{1}-> {2}-> NULL", busStops.breadthFirst().toString());
    assertNull(empty.breadthFirst());
    assertEquals(
        "{Azraq - Muwaffaq Salti Air Base}-> {Assab - H-4 Air Base}-> {Amman - Queen Alia International Airport}-> {Dafyanah - Prince Hassan Air Base}-> {Amman - Amman Civil Airport}-> {Aqaba - King Hussein International Airport}-> {Mafraq - King Hussein Air Base}-> NULL",
        airports.breadthFirst().toString()
    );
  }
  
  @Test
  public void breadthFirstTraversalTest() {
    assertEquals("{1}-> {2}-> NULL", busStops.breadthFirstTraversal(1).toString());
    assertEquals("{2}-> {1}-> NULL", busStops.breadthFirstTraversal(2).toString());
    assertEquals("{3}-> {2}-> {1}-> NULL", busStops.breadthFirstTraversal(3).toString());
    assertEquals("{4}-> {3}-> {2}-> {1}-> NULL", busStops.breadthFirstTraversal(4).toString());
    assertEquals("{5}-> {4}-> {3}-> {2}-> {1}-> NULL", busStops.breadthFirstTraversal(5).toString());

    assertEquals(
        "{Amman - Queen Alia International Airport}-> {Amman - Amman Civil Airport}-> {Aqaba - King Hussein International Airport}-> {Assab - H-4 Air Base}-> {Azraq - Muwaffaq Salti Air Base}-> {Mafraq - King Hussein Air Base}-> {Dafyanah - Prince Hassan Air Base}-> NULL",
        airports.breadthFirstTraversal("Amman - Queen Alia International Airport").toString()
    );
    assertEquals(
        "{Amman - Amman Civil Airport}-> {Amman - Queen Alia International Airport}-> {Aqaba - King Hussein International Airport}-> {Assab - H-4 Air Base}-> {Azraq - Muwaffaq Salti Air Base}-> {Mafraq - King Hussein Air Base}-> {Dafyanah - Prince Hassan Air Base}-> NULL",
        airports.breadthFirstTraversal("Amman - Amman Civil Airport").toString()
    );
    assertEquals(
        "{Aqaba - King Hussein International Airport}-> {Amman - Queen Alia International Airport}-> {Amman - Amman Civil Airport}-> {Azraq - Muwaffaq Salti Air Base}-> {Mafraq - King Hussein Air Base}-> {Assab - H-4 Air Base}-> {Dafyanah - Prince Hassan Air Base}-> NULL",
        airports.breadthFirstTraversal("Aqaba - King Hussein International Airport").toString()
    );
    assertEquals(
        "{Assab - H-4 Air Base}-> {Amman - Queen Alia International Airport}-> {Azraq - Muwaffaq Salti Air Base}-> {Dafyanah - Prince Hassan Air Base}-> {Amman - Amman Civil Airport}-> {Aqaba - King Hussein International Airport}-> {Mafraq - King Hussein Air Base}-> NULL",
        airports.breadthFirstTraversal("Assab - H-4 Air Base").toString()
    );
    assertEquals(
        "{Azraq - Muwaffaq Salti Air Base}-> {Assab - H-4 Air Base}-> {Amman - Queen Alia International Airport}-> {Dafyanah - Prince Hassan Air Base}-> {Amman - Amman Civil Airport}-> {Aqaba - King Hussein International Airport}-> {Mafraq - King Hussein Air Base}-> NULL",
        airports.breadthFirstTraversal("Azraq - Muwaffaq Salti Air Base").toString()
    );
    assertEquals(
        "{Dafyanah - Prince Hassan Air Base}-> {Assab - H-4 Air Base}-> {Amman - Queen Alia International Airport}-> {Azraq - Muwaffaq Salti Air Base}-> {Amman - Amman Civil Airport}-> {Aqaba - King Hussein International Airport}-> {Mafraq - King Hussein Air Base}-> NULL",
        airports.breadthFirstTraversal("Dafyanah - Prince Hassan Air Base").toString()
    );
    assertEquals(
        "{Mafraq - King Hussein Air Base}-> {Assab - H-4 Air Base}-> {Dafyanah - Prince Hassan Air Base}-> {Amman - Queen Alia International Airport}-> {Azraq - Muwaffaq Salti Air Base}-> {Amman - Amman Civil Airport}-> {Aqaba - King Hussein International Airport}-> NULL",
        airports.breadthFirstTraversal("Mafraq - King Hussein Air Base").toString()
    );

    assertNull(empty.breadthFirstTraversal(1));
    assertNull(empty.breadthFirstTraversal(2));
    assertNull(empty.breadthFirstTraversal(3));
    assertNull(empty.breadthFirstTraversal(4));
  }
}
