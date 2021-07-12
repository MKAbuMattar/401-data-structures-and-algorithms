import animalShelter.AnimalShelter;
import animalShelter.CatShelter;
import animalShelter.DogShelter;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import types.PseudoQueue;
import types.Queue;
import types.Stack;

import static org.junit.Assert.*;

public class AppTest {

  public Stack<Integer> stack;
  public Queue<Integer> queue;
  public PseudoQueue<Integer> pseudoQueue;

  public AnimalShelter emptyAnimalShelter;
  public AnimalShelter singleAnimalShelter;
  public AnimalShelter multipleAnimalShelter;

  /*
   * Code Challenge: Class 10: Stack and a Queue Implementation
   */

  /**
   * Can successfully push onto a stack
   */

  //Queue

  @BeforeEach
  public void initSetUpStack() {

  }

  @Test
  public void testStackIsEmpty() {
    stack = new Stack<>();
    stack.push(1);
    assertFalse(stack.isEmpty());
  }

  /**
   * Can successfully push multiple values onto a stack
   */
  @Test
  public void testStackIsEmptyMultiple() {
    stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    stack.push(8);
    stack.push(9);
    stack.push(10);
    stack.push(11);
    stack.push(12);
    assertFalse(stack.isEmpty());
  }

  /**
   * Can successfully pop off the stack
   */
  @Test
  public void testStackPop() {
    stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    assertEquals((Integer) 4, stack.pop());
  }

  /**
   * Can successfully empty a stack after multiple pops
   */
  @Test
  public void testStackMultiplePop() {
    stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.pop();
    stack.pop();
    stack.pop();
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  /**
   * Can successfully peek the next item on the stack
   */
  @Test
  public void testStackPeek() {
    stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    assertEquals((Integer) 4, stack.peek());
  }

  /**
   * Can successfully instantiate an empty stack
   */
  @Test
  public void testStackEmpty() {
    stack = new Stack<>();
    assertTrue(stack.isEmpty());
  }

  /**
   * Calling pop or peek on empty stack raises exception
   */
  @Test
  public void testStackEmptyPopAndPeek() {
    stack = new Stack<>();
    assertNull(stack.pop());
    assertNull(stack.peek());
  }

  //Queue

  @BeforeEach
  public void initSetUpQueue() {
  }

  /**
   * Can successfully enqueue into a queue
   */
  @Test
  public void testQueueEnqueue() {
    queue = new Queue<>();
    queue.enqueue(1);
    assertFalse(queue.isEmpty());
  }

  /**
   * Can successfully enqueue multiple values into a queue
   */
  @Test
  public void testQueueEnqueueMultiple() {
    queue = new Queue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    assertFalse(queue.isEmpty());
    assertEquals("{1}-> {2}-> {3}-> {4}-> NULL", queue.toString());
  }

  /**
   * Can successfully dequeue out of a queue the expected value
   */
  @Test
  public void testQueueDequeue() {
    queue = new Queue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    assertEquals("{1}-> {2}-> {3}-> {4}-> NULL", queue.toString());
    assertEquals((Integer) 1, queue.dequeue());
    assertEquals("{2}-> {3}-> {4}-> NULL", queue.toString());
  }

  /**
   * Can successfully peek into a queue, seeing the expected value
   */
  @Test
  public void testQueuePeek() {
    queue = new Queue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    assertEquals("{1}-> {2}-> {3}-> {4}-> NULL", queue.toString());
    assertEquals((Integer) 1, queue.peek());
    assertEquals("{1}-> {2}-> {3}-> {4}-> NULL", queue.toString());
  }

  /**
   * Can successfully empty a queue after multiple dequeues
   */
  @Test
  public void testQueueMultipleDequeue() {
    queue = new Queue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    assertTrue(queue.isEmpty());
    assertEquals("Queue list is empty", queue.toString());
  }

  /**
   * Can successfully instantiate an empty queue
   */
  @Test
  public void testQueueEmpty() {
    queue = new Queue<>();
    assertTrue(queue.isEmpty());
    assertEquals("Queue list is empty", queue.toString());
  }

  /**
   * Calling dequeue or peek on empty queue raises exception
   */
  @Test
  public void testQueueEmptyDequeueAndPeek() {
    queue = new Queue<>();
    assertNull(queue.dequeue());
    assertNull(queue.peek());
    assertEquals("Queue list is empty", queue.toString());
  }

  /*
    Code Challenge: Class 11
   */

  /**
   * Can successfully enqueue into a Pseudo Queue
   */
  @Test
  public void testPseudoQueueEnqueue() {
    pseudoQueue = new PseudoQueue<>();
    pseudoQueue.enqueue(1);
    assertFalse(pseudoQueue.isEmpty());
    assertEquals(1, pseudoQueue.getSize());
    assertEquals("{1}-> NULL", pseudoQueue.toString());
  }

  /**
   * Can successfully enqueue multiple values into a Pseudo Queue
   */
  @Test
  public void testPseudoQueueEnqueueMultiple() {
    pseudoQueue = new PseudoQueue<>();
    pseudoQueue.enqueue(1);
    pseudoQueue.enqueue(2);
    pseudoQueue.enqueue(3);
    pseudoQueue.enqueue(4);
    assertFalse(pseudoQueue.isEmpty());
    assertEquals(4, pseudoQueue.getSize());
    assertEquals("{4}-> {3}-> {2}-> {1}-> NULL", pseudoQueue.toString());
  }

  /**
   * Can successfully dequeue out of a Pseudo Queue the expected value
   */
  @Test
  public void testPseudoQueueDequeue() {
    pseudoQueue = new PseudoQueue<>();
    pseudoQueue.enqueue(1);
    pseudoQueue.enqueue(2);
    pseudoQueue.enqueue(3);
    pseudoQueue.enqueue(4);
    assertEquals(4, pseudoQueue.getSize());
    assertEquals("{4}-> {3}-> {2}-> {1}-> NULL", pseudoQueue.toString());
    assertEquals((Integer) 1, pseudoQueue.dequeue());
    assertEquals(3, pseudoQueue.getSize());
    assertEquals("{4}-> {3}-> {2}-> NULL", pseudoQueue.toString());
  }

  /**
   * Can successfully peek into a Pseudo Queue, seeing the expected value
   */
  @Test
  public void testPseudoQueuePeek() {
    pseudoQueue = new PseudoQueue<>();
    pseudoQueue.enqueue(1);
    pseudoQueue.enqueue(2);
    pseudoQueue.enqueue(3);
    pseudoQueue.enqueue(4);
    assertEquals("{4}-> {3}-> {2}-> {1}-> NULL", pseudoQueue.toString());
    assertEquals(4, pseudoQueue.getSize());
    assertEquals((Integer) 1, pseudoQueue.peek());
    assertEquals("{4}-> {3}-> {2}-> {1}-> NULL", pseudoQueue.toString());
    assertEquals(4, pseudoQueue.getSize());
  }

  /**
   * Can successfully empty a Pseudo Queue after multiple dequeues
   */
  @Test
  public void testPseudoQueueMultipleDequeue() {
    pseudoQueue = new PseudoQueue<>();
    pseudoQueue.enqueue(1);
    pseudoQueue.enqueue(2);
    pseudoQueue.enqueue(3);
    pseudoQueue.enqueue(4);
    pseudoQueue.dequeue();
    pseudoQueue.dequeue();
    pseudoQueue.dequeue();
    pseudoQueue.dequeue();
    assertTrue(pseudoQueue.isEmpty());
    assertEquals(0, pseudoQueue.getSize());
    assertEquals("Pseudo Queue list is empty", pseudoQueue.toString());
  }

  /**
   * Can successfully instantiate an empty Pseudo Queue
   */
  @Test
  public void testPseudoQueueEmpty() {
    pseudoQueue = new PseudoQueue<>();
    assertTrue(pseudoQueue.isEmpty());
    assertEquals(0, pseudoQueue.getSize());
    assertEquals("Pseudo Queue list is empty", pseudoQueue.toString());
  }

  /**
   * Calling dequeue or peek on empty Pseudo Queue raises exception
   */
  @Test
  public void testPseudoQueueEmptyDequeueAndPeek() {
    pseudoQueue = new PseudoQueue<>();
    assertNull(pseudoQueue.dequeue());
    assertNull(pseudoQueue.peek());
    assertEquals(0, pseudoQueue.getSize());
    assertEquals("Pseudo Queue list is empty", pseudoQueue.toString());
  }

  /*
   * Code Challenge: Class 12
   */

  @Before
  public void setUp() throws Exception {
    emptyAnimalShelter = new AnimalShelter();

    singleAnimalShelter = new AnimalShelter();
    singleAnimalShelter.enqueue(new DogShelter( "KeKe", 5));

    multipleAnimalShelter = new AnimalShelter();
    multipleAnimalShelter.enqueue(new DogShelter("Max", 13));
    multipleAnimalShelter.enqueue(new DogShelter("semsem", 15));
    multipleAnimalShelter.enqueue(new CatShelter("MishMish", 7));
    multipleAnimalShelter.enqueue(new CatShelter("Zatar", 14));
  }

  @Test
  public void testAnimalShelterConstructor() {
    assertNotNull(emptyAnimalShelter);
  }

  @Test
  public void testEmptyAnimalShelterDequeue() {
    assertNull(emptyAnimalShelter.dequeue("dog"));
    assertNull(emptyAnimalShelter.dequeue("cat"));
    assertNull(emptyAnimalShelter.dequeue("hhh"));
  }

  @Test
  public void testSingleAnimalShelterDequeue() {
    assertEquals("KeKe", singleAnimalShelter.dequeue("dog").getName());
    assertNotNull(singleAnimalShelter);
  }

  @Test
  public void testMultipleAnimalShelterDequeueNotSpecified() {
    assertNotNull(multipleAnimalShelter);
    assertEquals("MishMish", multipleAnimalShelter.dequeue("cat").getName());
    assertEquals("Max", multipleAnimalShelter.dequeue("dog").getName());
  }

  @Test
  public void testMultipleAnimalShelterDequeueSpecified() {
    assertNotNull(multipleAnimalShelter);
    assertEquals("Max", multipleAnimalShelter.dequeue("dog").getName());
    assertEquals("MishMish", multipleAnimalShelter.dequeue("cat").getName());
    assertEquals("Zatar", multipleAnimalShelter.dequeue("cat").getName());
    assertEquals("semsem", multipleAnimalShelter.dequeue("dog").getName());
    assertNull(multipleAnimalShelter.dequeue("dog"));
    assertNull(multipleAnimalShelter.dequeue("cat"));
  }
}
