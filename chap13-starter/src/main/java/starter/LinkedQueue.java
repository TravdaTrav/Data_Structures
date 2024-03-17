package starter;

import exceptions.EmptyException;

/**
 * Linked implementation of Queue ADT.
 *
 * @param <T> base type.
 */
public class LinkedQueue<T> implements Queue<T> {

  Node<T> head;
  Node<T> tail;

  @Override
  public void enqueue(T value) {

    Node<T> node = new Node<>(value);

    if (tail == null) {
      head = node;
    } else {
      tail.next = node;
    }

    tail = node;
  }

  @Override
  public void dequeue() throws EmptyException {
    if (empty()) {
      throw new EmptyException();
    }

    if (head == tail) {
      tail = null;
    }

    head = head.next;
  }

  @Override
  public T front() throws EmptyException {
    if (empty()) {
      throw new EmptyException();
    }

    return head.data;
  }

  @Override
  public boolean empty() {
    return head == null;
  }

  private static class Node<T> {
    public T data;
    public Node<T> next;

    Node(T t) {
      this.data = t;
    }
  }
}
