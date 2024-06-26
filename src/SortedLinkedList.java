/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 23/03/2022
 */

/**
 * Extension of {@link LinkedList} that sorts the list by descending order of area.
 *
 * @param <E> the type of {@link PlanarShape} elements stored.
 */
public class SortedLinkedList<E extends PlanarShape> extends LinkedList<E> {

  public SortedLinkedList() {
    super();
  }

  /**
   * Adds an item to the list while maintaining an order of decreasing area.
   *
   * @param data The {@link PlanarShape} object to be added to this {@link SortedLinkedList}.
   */
  public void insertInOrder(final E data) {
    Node<E> current = this.sentinel;
    while ((current = current.getNext()) != this.sentinel) {
      if (data.compareTo(current.getData()) > 0) {
        break;
      }
    }
    connect(data, current, current.getPrev());
  }

  /**
   * Adds a {@link PlanarShape} object to the {@link SortedLinkedList} by directing incoming data to
   * {@link SortedLinkedList#insertInOrder(PlanarShape)}.
   *
   * @param data The {@link PlanarShape} object to be added to the list.
   */
  @Override
  public void insert(final E data) {
    insertInOrder(data);
  }

  /**
   * Adds a {@link PlanarShape} object to the start of {@link LinkedList}.
   *
   * @param data The {@link PlanarShape} object to be prepended to the {@link LinkedList}.
   * @deprecated because this method is invalid on {@link SortedLinkedList}.
   * @throws UnsupportedOperationException if used with {@link SortedLinkedList}.
   */
  @Deprecated
  @Override
  public void prepend(final E data) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Use of prepend() is invalid on SortedLinkedList");
  }

  /**
   * Adds a {@link PlanarShape} object to the end of {@link LinkedList}.
   *
   * @param data The {@link PlanarShape} object to be appended to the end of the {@link LinkedList}.
   * @deprecated because this method is invalid on {@link SortedLinkedList}.
   * @throws UnsupportedOperationException if used with {@link SortedLinkedList}.
   */
  @Deprecated
  @Override
  public void append(final E data) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Use of append() is invalid on SortedLinkedList");
  }
}
