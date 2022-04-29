/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 23/03/2022
 */

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a <em>circular doubly linked list</em> data structure.
 *
 * @param <E> the type of {@link PlanarShape} elements stored.
 */
public class LinkedList<E extends PlanarShape> implements Iterable<E> {
  // Instance variables
  protected final Node<E> sentinel;
  protected int size;
  protected transient int modCount;

  /** Default constructor */
  public LinkedList() {
    sentinel = new Node<E>();
    sentinel.setNext(sentinel);
    sentinel.setPrev(sentinel);
    size = 0;
    modCount = 0;
  }

  /**
   * Adds a {@link PlanarShape} object to the end of {@link LinkedList}.
   *
   * @param data The {@link PlanarShape} object to be appended to the end of the {@link LinkedList}.
   */
  public void append(final E data) throws UnsupportedOperationException {
    connect(data, sentinel, sentinel.getPrev());
  }

  /**
   * Adds a {@link PlanarShape} object to the start of {@link LinkedList}.
   *
   * @param data The {@link PlanarShape} object to be prepended to the {@link LinkedList}.
   */
  public void prepend(final E data) throws UnsupportedOperationException {
    connect(data, sentinel.getNext(), sentinel);
  }

  protected void connect(final E data, final Node<E> next, final Node<E> prev) {
    final Node<E> newNode = new Node<>(data, next, prev);
    next.setPrev(newNode);
    prev.setNext(newNode);
    size++;
    modCount++;
  }

  /**
   * Adds a {@link PlanarShape} object to the {@link LinkedList} by directing incoming data to
   * {@link LinkedList#append(PlanarShape)}.
   *
   * @param data The {@link PlanarShape} object to be added to the list.
   */
  public void insert(final E data) {
    append(data);
  }

  /**
   * Moves cursor to the head of the list.
   *
   * @deprecated because this method is invalid on {@link LinkedList}.
   * @throws UnsupportedOperationException if used with {@link LinkedList}.
   */
  @Deprecated
  public void reset() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Use of reset() on LinkedList is invalid");
  }

  /**
   * Moves cursor to the next item in the list.
   *
   * @deprecated because this method is invalid on {@link LinkedList}.
   * @throws UnsupportedOperationException if used with {@link LinkedList}.
   */
  @Deprecated
  public void next() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Use of next() on LinkedList is invalid");
  }

  /**
   * Remove the {@link Node} at the head of the {@link LinkedList}.
   *
   * @return The data of the removed {@link Node}.
   */
  public E pop() {
    final Node<E> head = sentinel.getNext();
    head.getNext().setPrev(sentinel);
    sentinel.setNext(head.getNext());
    size--;
    modCount++;
    return head.getData();
  }

  /**
   * Check if this {@link LinkedList} is empty.
   *
   * @return {@code true} if this {@link LinkedList} is empty.
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Get an {@link Iterator} for iterating over elements of an instance of {@link LinkedList}.
   *
   * @return An instance of {@link Iterator}.
   * @see Iterable
   */
  @Override
  public Iterator<E> iterator() {
    return new LinkedListIterator(this.sentinel, this.modCount);
  }

  /**
   * Get the string representation of this {@link LinkedList}.
   *
   * @return The {@link String} object representing this {@link LinkedList}.
   */
  @Override
  public String toString() {
    if (this.isEmpty()) {
      return "Empty";
    }
    final Iterator<E> iterator = this.iterator();
    final StringBuilder stringBuilder = new StringBuilder();
    try {
      while (iterator.hasNext()) {
        stringBuilder.append(iterator.next().toString()).append("\n");
      }
    } catch (NoSuchElementException e) {
      // Hit end of list; that's fine, just continue
    }
    return stringBuilder.toString();
  }

  /** Implementation of the {@link Iterator} interface for iterating a {@link LinkedList}. */
  private class LinkedListIterator implements Iterator<E> {
    private final int expectedModCount; // For checking if the container has modified.
    private Node<E> current; // For traversing the list.

    public LinkedListIterator(final Node<E> sentinel, final int modCount) {
      this.current = sentinel;
      this.expectedModCount = modCount;
    }

    @Override
    public boolean hasNext() {
      return current.getNext() != sentinel;
    }

    @Override
    public E next() {
      if (expectedModCount != modCount) {
        throw new ConcurrentModificationException("Unexpected modification of collection.");
      }
      if (!hasNext()) {
        throw new NoSuchElementException("End of collection.");
      }
      current = current.getNext();
      return current.getData();
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
