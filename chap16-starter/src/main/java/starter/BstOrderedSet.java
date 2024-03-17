package starter;

import java.util.Iterator;

/**
 * A Binary Search Tree implementation of OrderedSet ADT.
 *
 * @param <T> Element type.
 */
public class BstOrderedSet<T extends Comparable<T>> implements OrderedSet<T> {

  private Node<T> root;
  private int numElements;

  /**
   * Construct an empty BstOrderedSet.
   */
  public BstOrderedSet() {
    root = null;
    numElements = 0;
  }

  @Override
  public void insert(T t) {
    root = insert(root, t);
  }

  private Node<T> insert(Node<T> node, T t) {

    if (node == null) {
      node = new Node<>(t);
      numElements++;
    } else {
      int comparisonResult = t.compareTo(node.data);
      if (comparisonResult < 0) {
        node.left = insert(node.left, t);
      } else if (comparisonResult > 0) {
        node.right = insert(node.right, t);
      }
      //else, comparisonResult == 0 --> element already present (do nothing)
    }

    return node;
  }

  @Override
  public void remove(T t) {
    root = remove(root, t);
  }

  private Node<T> remove(Node<T> node, T t) {
    if (node != null) {
      int comparisonResult = t.compareTo(node.data);

      if (comparisonResult < 0) {
        node.left = remove(node.left, t);
      } else if (comparisonResult > 0) {
        node.right = remove(node.left, t);
      } else { // comparisonResult == 0 --> found the element
        node = removeSubtreeRoot(node);
      }
    }

    return node;
  }

  private Node<T> removeSubtreeRoot(Node<T> node) {
    if (node.left == null) {
      --numElements;
      return node.right;
    } else if (node.right == null) {
      --numElements;
      return node.left;
    } else {
      T smallest = getSmallestElement(node.right);
      node.data = smallest;
      node.right = remove(node.right, smallest);
    }

    return node;
  }

  private T getSmallestElement(Node<T> node) {
    Node<T> smallestNode = node;

    while (smallestNode.left != null) {
      smallestNode = smallestNode.left;
    }

    return smallestNode.data;
  }

  @Override
  public boolean has(T t) {
    return find(root, t);
  }

  private boolean find(Node<T> node, T t) {
    if (node == null) {
      return false;
    } else {
      int comparisonResult = t.compareTo(node.data);

      if (comparisonResult == 0) {
        return true;
      } else if (comparisonResult < 0) {
        return find(node.left, t);
      } else {
        return find(node.right, t);
      }
    }
  }

  @Override
  public int size() {
    return numElements;
  }

  @Override
  public Iterator<T> iterator() {
    // TODO Implement me!
    return null;
  }

  private static class Node<E> {
    E data;
    Node<E> left;
    Node<E> right;

    Node(E data) {
      this.data = data;
    }
  }

  /**
   * Driver program to visualize/test this implementation.
   *
   * @param args command-line arguments.
   */
  public static void main(String[] args) {
    BstOrderedSet<Integer> bst = new BstOrderedSet<>();
    bst.insert(7);
    bst.insert(4);
    bst.insert(13);
    bst.insert(1);
    bst.insert(6);
    bst.insert(10);
    bst.insert(15);
    bst.insert(3);
    bst.remove(1);
    bst.remove(3);
    bst.remove(7);
    bst.remove(13);

    System.out.println(bst.size());
    System.out.println(bst.has(13));
    System.out.println(bst.has(23));
  }
}
