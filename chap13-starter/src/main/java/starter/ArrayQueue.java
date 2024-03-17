package starter;

import exceptions.EmptyException;

/**
 * Array Implementation of the Queue ADT.
 *
 * @param <T> base type.
 */
public class ArrayQueue<T> implements Queue<T> {

  private T[] array;
  private int front;
  private int back;
  private int size;

  public ArrayQueue() {
    this.size = 10;
    array = (T[]) new Object[size];
    front = 0;
    back = 1;
  }

  @Override
  public void enqueue(T value) {
    int index = back - 1;
    if (back == 0) {
      index += size;
    }
    array[index] = value;
    back++;

    if (back == size) {
      back = 0;
    }

    if (back == front) {
      T[] newArr = (T[]) new Object[size * 2];

      for (int i = 0; i < size; i++) {
        newArr[i] = array[(i + front) % size];
      }

      front = 0;
      back = size;
      size *= 2;
      array = newArr;
    }
  }

  @Override
  public void dequeue() throws EmptyException {
    if (empty()) {
      throw new EmptyException();
    }

    array[front] = null;
    front++;

    if (front == size) {
      front = 0;
    }
  }

  @Override
  public T front() throws EmptyException {
    if (empty()) {
      throw new EmptyException();
    }

    return array[front];
  }

  @Override
  public boolean empty() {
    return front == back - 1;
  }
}
