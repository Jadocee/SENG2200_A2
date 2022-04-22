/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 23/03/2022
 */

import java.util.Iterator;
import java.util.function.Consumer;

/** Implementation of a <em>circular doubly linked list</em> data structure. */
public class LinkedList<E extends PlanarShape> implements Iterable<E> {
  // Instance variables
  protected final Node<E> sentinel;
  protected int size;

  /** Default constructor */
  public LinkedList() {
    sentinel = new Node<E>();
    sentinel.setNext(sentinel);
    sentinel.setPrev(sentinel);
    size = 0;
  }

  /**
   * Adds a {@link PlanarShape} object to the end of {@link LinkedList}.
   *
   * @param data The {@link PlanarShape} object to be appended to the end of the {@link LinkedList}.
   */
  public void append(final E data) throws UnsupportedOperationException {
    final Node<E> newNode = new Node<E>(data, sentinel, sentinel.getPrev());
    sentinel.getPrev().setNext(newNode);
    sentinel.setPrev(newNode);
    size++;
  }

  /**
   * Adds a {@link PlanarShape} object to the start of {@link LinkedList}.
   *
   * @param data The {@link PlanarShape} object to be prepended to the {@link LinkedList}.
   */
  public void prepend(final E data) throws UnsupportedOperationException {
    final Node<E> newNode = new Node<E>(data, sentinel.getNext(), sentinel);
    sentinel.getNext().setPrev(newNode);
    sentinel.setNext(newNode);
    size++;
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
   * @see Iterator
   * @see Iterable
   * @see LinkedList
   */
  @Override
  public Iterator<E> iterator() {
    return new LinkedListIterator(this.sentinel);
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
    while (iterator.hasNext()) {
      stringBuilder.append(iterator.next().toString()).append("\n");
    }
    return stringBuilder.toString();
  }

  /** Implementation of the {@link Iterator} interface for iterating a {@link LinkedList}. */
  private class LinkedListIterator implements Iterator<E> {
    // LinkedListIterator instance variables
    private Node<E> current;

    public LinkedListIterator(final Node<E> sentinel) {
      this.current = sentinel;
    }

    @Override
    public boolean hasNext() {
      return current.getNext() != sentinel;
    }

    @Override
    public E next() {
      current = current.getNext();
      return current.getData();
    }

    public void insertBefore(final E data) {
      final Node<E> newNode = new Node<E>(data, current, current.getPrev());
      current.getPrev().setNext(newNode);
      current.setPrev(newNode);
    }

    @Override
    public void forEachRemaining(Consumer<? super E> action) {
      Iterator.super.forEachRemaining(action);
    }
  }
}
