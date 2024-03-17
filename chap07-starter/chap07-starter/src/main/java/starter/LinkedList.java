package starter;

import exceptions.IndexException;

import java.util.Iterator;

// TODO some of the sanity checks are convoluted and need to be refactored!
public class LinkedList<T> implements Iterable<T> {
  private Node<T> head;
  private int numElements;

  public LinkedList() {
    head = null;
    numElements = 0;
  }

  public void addFirst(T t) {
    Node<T> node = new Node<T>(t);

    if (head == null) {
      addLast(t);
    } else {
      node.next = head;
      head = node;
    }
    numElements++;
  }

  public void addLast(T t) {
    Node<T> pos = head;
    Node<T> node = new Node<T>(t);

    if (head == null) {
      head = node;
      numElements++;
      return;
    }

    while (pos.next != null) {
      pos = pos.next;
    }

    pos.next = node;
    numElements++;
  }

  public void traverse() {
    // TODO Implement me!
  }

  public T get(int index) throws IndexException {
    if (index >= 0 && index < numElements) {
      Node<T> pos = head;
      for (int i = 0; i < index; i++) {
        pos = pos.next;
      }
      return pos.data;
    } else {
      throw new IndexException();
    }
  }


  public void insert(int index, T t) throws IndexException{
    if (index < 0 || index > numElements) {
      throw new IndexException();
    }

    if (index == 0) {
      addFirst(t);
      numElements++;
      return;
    }

    Node<T> target = head;
    Node<T> newNode = new Node<T>(t);
    for (int i = 0; i < index - 1; i++) {
      target = target.next;
    }

    target.next = newNode.next;
    newNode.next = target;
    numElements++;
  }

  public void delete(int index) {
    // TODO Implement me!
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  public int length() {
    return 0;  // TODO Implement me!
  }

  private static class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
      this.data = data;
    }
  }

  private class LinkedListIterator implements Iterator<T> {

    @Override
    public T next() {
      return null;     // TODO Implement me!
    }

    @Override
    public boolean hasNext() {
      return false;     // TODO Implement me!
    }
  }

}
