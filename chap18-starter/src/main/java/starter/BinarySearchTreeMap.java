package starter;

import org.junit.jupiter.params.aggregator.ArgumentAccessException;

import java.util.Iterator;

public class BinarySearchTreeMap<K extends Comparable<K>, V>
    implements OrderedMap<K, V> {

  Node<K, V> root;
  int numElements;

  public BinarySearchTreeMap() {
    root = null;
    numElements = 0;
  }

  @Override
  public void insert(K k, V v) throws IllegalArgumentException {
    if (k == null) {
      throw new IllegalArgumentException();
    }
    if (root == null) {
      root = new Node<>(k, v);
      numElements++;
      return;
    }

    insert(root, k, v);
  }

  private void insert(Node<K, V> node, K k, V v) throws IllegalArgumentException {
    int comparison = k.compareTo(node.key);

    if (comparison == 0) {
      throw new IllegalArgumentException();
    } else if (comparison < 0) {
      if (node.left == null) {
        node.left = new Node<>(k, v);
        numElements++;
      } else {
        insert(node.left, k, v);
      }
    } else {
      if (node.right == null) {
        node.right = new Node<>(k, v);
        numElements++;
      } else {
        insert(node.right, k, v);
      }
    }
  }

  @Override
  public V remove(K k) throws IllegalArgumentException {
    if (k == null || root == null) {
      throw new IllegalArgumentException();
    }

    V v = remove(root, k);

    if (v == null) {
      throw new IllegalArgumentException();
    }

    return v;
  }

  private V remove(Node<K, V> node, K k) {

  }

  @Override
  public V get(K k) throws IllegalArgumentException {
    Node<K, V> node = find(root, k);

    if (node == null) {
      throw new IllegalArgumentException();
    }

    return node.value;
  }

  @Override
  public boolean has(K k) {
    Node<K, V> node = find(root, k);
    return !(node == null);
  }

  private Node<K, V> find(Node<K, V> node, K k) {
    if (node == null) {
      return null;
    }

    int comparison = k.compareTo(node.key);

    if (comparison == 0) {
      return node;
    } else if (comparison < 0) {
      return find(node.left, k);
    } else {
      return find(node.right, k);
    }
  }

  @Override
  public int size() {
    return numElements;
  }

  @Override
  public Iterator<K> iterator() {
    // TODO Implement me.
    return null;
  }

  private static class Node<K, V> {
    K key;
    V value;

    Node<K, V> left;
    Node<K, V> right;

    Node(K k, V v) {
      key = k;
      value = v;
      left = null;
      right = null;
    }
  }
}
