package codechallenges;

import LinkedList.types.LinkedList;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {

  private LinkedList<Integer> list;
  private LinkedList<Integer> list2;
  private LinkedList<String> list3;

  /**
   * Code Challenge: Class 05: Linked List Implementation
   */

  /**
   * Can successfully instantiate an empty linked list
   */
  @org.junit.Test
  public void testLinkedListEmpty() {
    list = new LinkedList<>();
    assertEquals("Linked list is empty", list.toString());
  }

  /**
   * Can properly insert into the linked list
   */
  @org.junit.Test
  public void testLinkedListInsert() {
    list = new LinkedList<>();
    list.insert(13);
    assertEquals("{13}-> NULL", list.toString());
  }

  /**
   * The head property will properly point to the first node in the linked list
   */
  @org.junit.Test
  public void testLinkedListPoint() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    assertEquals("{1}-> {2}-> NULL", list.toString());
  }

  /**
   * Can properly insert multiple nodes into the linked list
   */
  @org.junit.Test
  public void testLinkedListMultipleInsert() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    assertEquals("{1}-> {2}-> {3}-> {4}-> NULL", list.toString());
  }

  /**
   * Will return true when finding a value within the linked list that exists
   */
  @org.junit.Test
  public void testLinkedListIncludesTrue() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    assertEquals(true, list.includes(3));
  }

  /**
   * Will return false when searching for a value in the linked list that does not exist
   */
  @org.junit.Test
  public void testLinkedListIncludesFalse() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    assertEquals(false, list.includes(44));
  }

  /**
   * Can properly return a collection of all the values that exist in the linked list
   */
  @org.junit.Test
  public void testLinkedListToString() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    assertEquals("{1}-> {2}-> {3}-> {4}-> NULL", list.toString());
  }

  /**
   * Code Challenge: Class 06
   */

  /**
   * Can successfully add a node to the end of the linked list
   */
  @org.junit.Test
  public void testLinkedListAddToEnd() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.append(3);
    assertEquals("{1}-> {2}-> {3}-> NULL", list.toString());
  }

  /**
   * Can successfully add multiple nodes to the end of a linked list
   */
  @org.junit.Test
  public void testLinkedListAddMultipleToEnd() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.append(3);
    list.append(4);
    list.append(5);
    assertEquals("{1}-> {2}-> {3}-> {4}-> {5}-> NULL", list.toString());
  }

  /**
   * Can successfully insert a node before a node located i the middle of a linked list
   */
  @org.junit.Test
  public void testLinkedListInsertBefore() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insertBefore(2, 30);
    assertEquals("{1}-> {30}-> {2}-> {3}-> NULL", list.toString());
  }

  /**
   * Can successfully insert a node before the first node of a linked list
   */
  @org.junit.Test
  public void testLinkedListInsertBeforeFirstNode() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insertBefore(1, 30);
    assertEquals("{30}-> {1}-> {2}-> {3}-> NULL", list.toString());
  }

  /**
   * Can successfully insert after a node in the middle of the linked list
   */
  @org.junit.Test
  public void testLinkedListInsertAfter() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insertAfter(2, 30);
    assertEquals("{1}-> {2}-> {30}-> {3}-> NULL", list.toString());
  }

  /**
   * Can successfully insert a node after the last node of the linked list
   */
  @org.junit.Test
  public void testLinkedListInsertAfterLastNode() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insertAfter(3, 30);
    assertEquals("{1}-> {2}-> {3}-> {30}-> NULL", list.toString());
  }

  /**
   * Code Challenge: Class 07
   */

  /**
   * Where k is greater than the length of the linked list
   */
  @org.junit.Test
  public void testLinkedListKthFromEndGreaterThanTheLength() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    assertEquals(null, list.kthFromEnd(5));
  }

  /**
   * Where k and the length of the list are the same
   */
  @org.junit.Test
  public void testLinkedListKthFromEndSameLength() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    assertEquals((Integer) 1, list.kthFromEnd(3));
  }

  /**
   * Where k is not a positive integer
   */
  @org.junit.Test
  public void testLinkedListKthFromEndNegativeNumber() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    assertEquals(null, list.kthFromEnd(-12));
  }

  /**
   * Where the linked list is of a size 1
   */
  @org.junit.Test
  public void testLinkedListKthFromEndSizeOne() {
    list = new LinkedList<>();
    list.insert(12);
    assertEquals((Integer) 12, list.kthFromEnd(1));
  }

  /**
   * ???Happy Path??? where k is not at the end, but somewhere in the middle of the linked list
   */
  @org.junit.Test
  public void testLinkedListKthFromEndHappyPath() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    list.insert(5);
    assertEquals((Integer) 3, list.kthFromEnd(3));
  }

  /**
   * Code Challenge: Class 08
   */

  /**
   * test case one normal input and two lists have the same size
   */
  @org.junit.Test
  public void testLinkedListZipListsNormal() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(3);
    list.insert(2);

    list2 = new LinkedList<>();
    list2.insert(5);
    list2.insert(9);
    list2.insert(4);

    list.zipLists(list, list2);
    assertEquals("{1}-> {5}-> {3}-> {9}-> {2}-> {4}-> NULL", list.toString());
  }


  /**
   * test case list one is shorter than list two
   */
  @org.junit.Test
  public void testLinkedListZipListsShorterListOne() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(3);
    list.insert(2);

    list2 = new LinkedList<>();
    list2.insert(5);
    list2.insert(4);

    list.zipLists(list, list2);
    assertEquals("{1}-> {5}-> {3}-> {4}-> {2}-> NULL", list.toString());
  }

  /**
   * test case list two is shorter than list one
   */
  @org.junit.Test
  public void testLinkedListZipListsShorterListTwo() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(3);

    list2 = new LinkedList<>();
    list2.insert(5);
    list2.insert(9);
    list2.insert(4);

    list.zipLists(list, list2);
    assertEquals("{1}-> {5}-> {3}-> {9}-> {4}-> NULL", list.toString());
  }

  /**
   * Code Challenge: Class 09
   */

  @org.junit.Test
  public void testLinkedListReverse() {
    list = new LinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    list.insert(5);
    list.reverse();
    assertEquals("{5}-> {4}-> {3}-> {2}-> {1}-> NULL", list.toString());
  }

  @org.junit.Test
  public void testLinkedListReverseOneElement() {
    list = new LinkedList<>();
    list.insert(1);
    list.reverse();
    assertEquals("{1}-> NULL", list.toString());
  }

  @org.junit.Test
  public void testLinkedListReverseEmpty() {
    list = new LinkedList<>();
    list.reverse();
    assertEquals("Linked list is empty", list.toString());
  }

  @org.junit.Test
  public void testLinkedListPalindromeTrue() {
    list3 = new LinkedList<>();
    list3.insert("t");
    list3.insert("a");
    list3.insert("c");
    list3.insert("o");
    list3.insert("c");
    list3.insert("a");
    list3.insert("t");

    assertEquals(true, list3.palindrome());
  }

  @org.junit.Test
  public void testLinkedListPalindromeFalse() {
    list3 = new LinkedList<>();
    list3.insert("h");
    list3.insert("o");
    list3.insert("u");
    list3.insert("s");
    list3.insert("e");

    assertEquals(false, list3.palindrome());
  }

  @org.junit.Test
  public void testLinkedListPalindromeOneElement() {
    list3 = new LinkedList<>();
    list3.insert("h");

    assertEquals(true, list3.palindrome());
  }

  @org.junit.Test
  public void testLinkedListPalindromeEmpty() {
    list3 = new LinkedList<>();

    assertEquals(true, list3.palindrome());
  }
}
