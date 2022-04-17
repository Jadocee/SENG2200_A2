/*
 *  SENG2200 Assignment 2
 *  Jaydon Cameron
 *  C3329145
 *  05/03/2021
 */

/**
 * Structure for storing data and linking nodes in a data structure.
 *
 * @param <E> the type of elements stored.
 */
public class Node<E extends PlanarShape> {
  // Instance variables
  private final E data;
  private Node<E> next;
  private Node<E> prev;

  /**
   * Constructor that specifies the data of the {@link Node} object.
   *
   * @param data object to be stored in this {@link Node}.
   */
  public Node(final E data) {
    this.data = data;
    next = null;
    prev = null;
  }

  /** Default constructor */
  public Node() {
    data = null;
    next = null;
    prev = null;
  }

  /**
   * Constructor that specifies the data, next, and previous.
   *
   * @param data object to be stored in this {@link Node}.
   * @param next {@link Node} that will be referenced by {@link Node#next}
   * @param prev {@link Node} that will be referenced by {@link Node#prev}
   * @see Node#getNext()
   * @see Node#setNext(Node)
   * @see Node#getPrev()
   * @see Node#setPrev(Node)
   */
  public Node(final E data, final Node<E> next, final Node<E> prev) {
    this.data = data;
    this.next = next;
    this.prev = prev;
  }

  /**
   * Gets the {@link Node} that is linked next to this {@link Node}.
   *
   * @return The {@link Node} that is referenced by this {@link Node#next}.
   * @see #setNext(Node)
   */
  public Node<E> getNext() {
    return next;
  }

  /**
   * Sets the {@link Node} that is linked to this {@link Node} via {@link Node#next}.
   *
   * @param node {@link Node} to be linked.
   * @see #getNext()
   */
  public void setNext(final Node<E> node) {
    next = node;
  }

  /**
   * Gets the {@link Node} object that is linked previous to this {@link Node}.
   *
   * @return The {@link Node} referenced by this {@link Node#prev}.
   * @see #setPrev(Node)
   */
  public Node<E> getPrev() {
    return prev;
  }

  /**
   * Sets the {@link Node} that is linked to this {@link Node} via {@link Node#prev}.
   *
   * @param node {@link Node} to be linked.
   * @see #getPrev()
   */
  public void setPrev(final Node<E> node) {
    prev = node;
  }

  /**
   * Gets the data of this {@link Node}
   *
   * @return The object stored in this {@link Node}.
   */
  public E getData() {
    return data;
  }
}
