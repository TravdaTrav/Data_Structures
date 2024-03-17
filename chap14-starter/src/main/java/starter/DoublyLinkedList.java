package starter;

import exceptions.PositionException;

public class DoublyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int numElements;

  public void addFirst(T data) {
    Node<T> node = new Node<>(data);
    node.prev = null;
    node.next = this.head;
    if (head == null) {
      this.head = node;
      tail = head;
    } else {
      head.prev = node;
    }
    this.head = node;
    numElements++;
  }

  public void addLast(T data) {
    if (tail == null) {
      addFirst(data);
      return;
    }

    Node<T> node = new Node<>(data);
    node.prev = tail;
    node.next = null;
    tail.next = node;

    this.tail = node;
    numElements++;
  }

  public T get(int index) {
//    Node<T> node = this.head;
//
//    for(int i = 0; i < index; i++) {
//      node = node.next;
//    }
//
//    return node.data;

    Node<T> node = this.tail;

    for (int i = numElements - 1; i > index; i--) {
      node = node.prev;
    }

    return node.data;
  }

  private Node<T> convert(Position<T> position) throws PositionException {
    try {
      Node<T> node = (Node<T>) position;
      if (this != node.getOwner()) {
        throw new PositionException();
      }
      return node;
    } catch (ClassCastException | NullPointerException e) {
      throw new PositionException();
    }
  }

  public Position<T> delete(Position<T> target) throws PositionException {
    Node<T> node = convert(target);

    Node<T> prev = node.prev;
    Node<T> next = node.next;

    if (prev != null) {
      prev.next = next;
    } else {
      this.head = next;
    }

    if (next != null) {
      next.prev = prev;
    } else {
      this.tail = prev;
    }

    return node;
  }

  public void insertAfter(Node<T> target, T data) {
    Node<T> node = new Node<>(data, this);
    node.next = target.next;
    node.prev = target;

    target.next = node;

    if (node.next != null) {
      node.next.prev = node;
    } else {
      this.tail = node;
    }

    numElements++;
  }

  public void insertBefore(Node<T> target, T data) {
    Node<T> node = new Node<>(data);
    node.prev = target.prev;
    node.next = target;

    target.prev = node;

    if (node.prev != null) {
      node.prev.next = node;
    } else {
      this.head = node;
    }

    numElements++;
  }

  private static class Node<E> implements Position<E> {
    E data;
    Node<E> next;
    Node<E> prev;

    private final DoublyLinkedList<E> owner;

    Node(E data, DoublyLinkedList<E> owner) {
      this.data = data;
      this.owner = owner;
    }

    public DoublyLinkedList<E> getOwner() {
      return owner;
    }

    @Override
    public E get() {
      return null;
    }
  }

  public DoublyLinkedList() {
    head = null;
    tail = null;
    numElements = 0;
  }

}