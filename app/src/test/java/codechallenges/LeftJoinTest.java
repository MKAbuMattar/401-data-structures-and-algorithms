package codechallenges;

import LeftJoin.LeftJoin;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class LeftJoinTest {

  HashMap<String, String> map1;
  HashMap<String, String> map2;
  HashMap<String, String[]> results;
  LeftJoin leftJoin;

  @Before
  public void init() {

    map1 = new HashMap<>();
    map2 = new HashMap<>();

    leftJoin = new LeftJoin();

    map1.put("fond","enamored");
    map1.put("wrath","anger");
    map1.put("diligent","employed");
    map1.put("outift","grab");
    map1.put("guide","usher");

    map2.put("fond","averse");
    map2.put("wrath","delight");
    map2.put("diligent","idle");
    map2.put("guide","follow");
    map2.put("flow","jam");
  }

  @Test
  public void TestLeftJoin() {
    results = leftJoin.leftJoin(map1, map2);
    assertArrayEquals(new String[]{"enamored", "averse"}, results.get("fond"));
    assertArrayEquals(new String[]{"usher","follow"}, results.get("guide"));
  }

}
