package starter;

import exceptions.EmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class QueueTest {

  protected Queue<Integer> queue;

  @BeforeEach
  public void setUp() throws Exception {
    queue = createQueue();
  }

  protected abstract Queue<Integer> createQueue();

  @Test
  public void newQueueIsEmpty() {
    assertTrue(queue.empty());
  }

  @Test
  public void frontOnEmptyQueueThrowsException() {
    try {
      queue.front();
      fail("EmptyException was expected but not thrown.");
    } catch (EmptyException e) {
      return;
    }
  }

  @Test
  public void dequeueOnEmptyQueueThrowsException() {
    try {
      queue.dequeue();
      fail("EmptyException was expected but not thrown.");
    } catch (EmptyException e) {
      return;
    }
  }

  @Test
  public void queueNotEmptyAfterEnqueue() {
    queue.enqueue(1);
    assertFalse(queue.empty());
  }

  @Test
  public void frontReturnsFirstIn() {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    assertEquals(1, queue.front().intValue());
  }

  @Test
  public void dequeueRemovesFirstIn() {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.dequeue();
    queue.dequeue();
    queue.enqueue(6);
    queue.enqueue(7);
    queue.enqueue(8);
    queue.enqueue(9);
    queue.enqueue(10);
    queue.enqueue(11);
    queue.enqueue(12);
    queue.enqueue(13);
    queue.enqueue(14);
    assertEquals(3, queue.front().intValue());
  }
}