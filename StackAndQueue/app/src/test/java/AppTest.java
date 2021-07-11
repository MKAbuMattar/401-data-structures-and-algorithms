import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import types.Queue;
import types.Stack;

import static org.junit.Assert.*;

public class AppTest {

  public Stack<Integer> stack;
  public Queue<Integer> queue;

  /**
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
//    queue = new Queue<>();
//    queue.enqueue(1);
//    queue.enqueue(2);
//    queue.enqueue(3);
//    queue.enqueue(4);
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
  }

  /**
   * Can successfully instantiate an empty queue
   */
  @Test
  public void testQueueEmpty() {
    queue = new Queue<>();
    assertTrue(queue.isEmpty());
  }

  /**
   * Calling dequeue or peek on empty queue raises exception
   */
  @Test
  public void testQueueEmptyDequeueAndPeek() {
    queue = new Queue<>();
    assertNull(queue.dequeue());
    assertNull(queue.peek());
  }
}
