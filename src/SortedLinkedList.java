/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 23/03/2022
 */

/**
 *
 */
public class SortedLinkedList<T extends PlanarShape> extends LinkedList<T> {

    public void insertInOrder(final T data) {
        // TODO implement insertInOrder()
    }

    /**
     * <p>Add item to list; maintaining descending order</p>
     * <p>Pre-conditions: None<br/>
     * Post-conditions: <code>PlanarShape</code> object is added to the list</p>
     *
     * @param data The <code>PlanarShape</code> object to be added to the list
     * @see SortedLinkedList#insertInOrder(PlanarShape)
     */
    @Override
    public void insert(final T data) {
        insertInOrder(data);
    }

    /**
     * <p>Adds data to the start of list</p>
     * <p>Pre-conditions: None<br/>
     * Post-conditions: <code>PlanarShape</code> object is added to the start of the list</p>
     *
     * @param data The <code>PlanarShape</code> object to be prepended to the list
     * @throws Exception When used on <code>SortedLinkedList</code>
     */
    @Override
    public void prepend(final T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Use of prepend() is invalid on SortedLinkedList");
    }

    /**
     * <p>Adds data to the start of list</p>
     * <p>Pre-conditions: None<br/>
     * Post-conditions: <code>PlanarShape</code> object is added to the start of the list</p>
     *
     * @param data The <code>PlanarShape</code> object to be prepended to the list
     * @throws Exception When used on <code>SortedLinkedList</code>
     */
    @Override
    public void append(final T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Use of prepend() is invalid on SortedLinkedList");
    }
}
