package au.com.avantsystems;

import java.util.NoSuchElementException;

public class SimpleLinkedList<T> {
  // reference to the first item
  private Node<T> head;

  // reference to the last item
  private Node<T> tail;

  private static class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
      this.value = value;
    }
  }

  /**
   * Adds an item to the head of the SimpleLinkedList
   *
   * @param item
   */
  public void addFirst(T item) {
    var newNode = new Node<>(item);
    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  public void addLast(T item) {
    var newNode = new Node<>(item);
    if (isEmpty()) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
  }

  public void deleteFirst() {
    if (isEmpty()) throw new NoSuchElementException();
    if (head == tail) {
      head = tail = null;
      return;
    }
    var next = head.next;
    head.next = null;
    head = next;
  }

  public void deleteLast() {
    if (isEmpty()) throw new NoSuchElementException();
    var previous = getPrevious(tail);
    tail = previous;
    tail.next = null;
  }

  public T getHead() {
    final Node<T> h = head;
    if (h == null) {
      throw new NoSuchElementException();
    }
    return h.value;
  }

  public T getTail() {
    final Node<T> t = tail;
    if (t == null) {
      throw new NoSuchElementException();
    }
    return t.value;
  }

  public void removeLast() {
    if (isEmpty()) throw new NoSuchElementException();
    Node<T> current = head;
    Node<T> previous = null;
    Node<T> next;
    boolean result = true;
    while (result) {
      next = current.next;
      if (next != null) {
        previous = current;
        current = next;
      } else {
        result = false;
        previous.next = null;
      }
    }
  }

  public int indexOf(T t) {
    int index = 0;
    Node<T> current = head;
    while (current != null) {
      if (current.value.equals(t)) return index;
      current = current.next;
      index++;
    }
    return -1;
  }

  public boolean contains(T t) {
    return indexOf(t) != -1;
  }

  private boolean isEmpty() {
    return head == null;
  }

  private Node<T> getPrevious(Node<T> node) {
    Node<T> current = head;
    while (current != null) {
      if (current.next == node) {
        return current;
      }
      current = current.next;
    }
    return null;
  }
}
