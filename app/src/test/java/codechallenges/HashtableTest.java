package codechallenges;

import HashTable.types.HashTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashtableTest {

  HashTable<Integer> emptyHashtable;
  HashTable<Integer> ages;
  HashTable<String> foods;

  @Before
  public void init() {

    emptyHashtable = new HashTable<>();

    ages = new HashTable<>();
    ages.add("Mohammad", 26);
    ages.add("Ali", 40);
    ages.add("Ahmad", 5);
    ages.add("Rana", 23);
    ages.add("Raghad", 21);

    foods = new HashTable<>();
    foods.add("Jordanian", "Mansaf");
    foods.add("KSA", "Kabsa");
    foods.add("Palestine", "Muskhan");
    foods.add("Syria", "Kibbeh");

  }

  @Test
  public void testEmptyHashTableSize() {
    assertEquals(0, emptyHashtable.getSize());
  }

  @Test
  public void TestHashTableIntegerSize() {
    assertEquals(5, ages.getSize());
  }

  @Test
  public void TestHashTableStringSize() {
    assertEquals(4, foods.getSize());
  }

  @Test
  public void testEmptyHashTableIsEmpty() {
    assertTrue(emptyHashtable.isEmpty());
  }

  @Test
  public void TestHashTableIntegerIsEmpty() {
    assertFalse(ages.isEmpty());
  }

  @Test
  public void TestHashTableStringIsEmpty() {
    assertFalse(foods.isEmpty());
  }

  @Test
  public void testEmptyHashTableGet() {
    assertNull(emptyHashtable.get("key"));
  }

  @Test
  public void TestHashTableIntegerGet() {
    assertEquals(Integer.valueOf(21), ages.get("Raghad"));
    assertEquals(Integer.valueOf(40), ages.get("Ali"));
    assertEquals(Integer.valueOf(5), ages.get("Ahmad"));
    assertEquals(Integer.valueOf(23), ages.get("Rana"));
    assertEquals(Integer.valueOf(26), ages.get("Mohammad"));
  }

  @Test
  public void TestHashTableStringGet() {
    assertEquals("Kibbeh", foods.get("Syria"));
  }

  @Test
  public void TestHashTableIntegerRemove() {
    assertEquals(Integer.valueOf(40), ages.get("Ali"));
    ages.remove("Ali");
    assertNull(ages.get("Ali"));
  }

  @Test
  public void TestHashTableStringRemove() {
    assertEquals("Kibbeh", foods.get("Syria"));
    foods.remove("Syria");
    assertNull(ages.get("Syria"));
  }

}
