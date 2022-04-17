/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 23/03/2022
 */

/** */
public class SortedLinkedList<E extends PlanarShape> extends LinkedList<E> {

  public void insertInOrder(final E data) {
    // TODO implement insertInOrder()
  }

  /**
   * Add item to list; maintaining descending order
   *
   * <p>Pre-conditions: None<br>
   * Post-conditions: <code>PlanarShape</code> object is added to the list
   *
   * @param data The <code>PlanarShape</code> object to be added to the list
   * @see SortedLinkedList#insertInOrder(PlanarShape)
   */
  @Override
  public void insert(final E data) {
    insertInOrder(data);
  }

  /**
   * Adds data to the start of list
   *
   * <p>Pre-conditions: None<br>
   * Post-conditions: <code>PlanarShape</code> object is added to the start of the list
   *
   * @param data The <code>PlanarShape</code> object to be prepended to the list
   * @throws Exception When used on <code>SortedLinkedList</code>
   */
  @Override
  public void prepend(final E data) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Use of prepend() is invalid on SortedLinkedList");
  }

  /**
   * Adds data to the start of list
   *
   * <p>Pre-conditions: None<br>
   * Post-conditions: <code>PlanarShape</code> object is added to the start of the list
   *
   * @param data The <code>PlanarShape</code> object to be prepended to the list
   * @throws Exception When used on <code>SortedLinkedList</code>
   */
  @Override
  public void append(final E data) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Use of prepend() is invalid on SortedLinkedList");
  }
}
