/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 23/03/2022
 */

import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 */
public class LinkedList<T extends PlanarShape> implements Iterable<T> {
    private final Node<T> sentinel;
    private int size;

    public LinkedList() {
        sentinel = new Node<T>();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
        size = 0;
    }


    /**
     * <p>Adds data to the end of list</p>
     * <p>Pre-conditions: None<br/>
     * Post-conditions: <code>PlanarShape</code> object is added to the end of the list</p>
     *
     * @param data The <code>PlanarShape</code> object to be appended to the end of the list
     */
    public void append(final T data) throws UnsupportedOperationException {
        final Node<T> newNode = new Node<>(data, sentinel, sentinel.getPrev());
        sentinel.getPrev().setNext(newNode);
        sentinel.setPrev(newNode);
        size++;
    }

    /**
     * <p>Adds data to the start of list</p>
     * <p>Pre-conditions: None<br/>
     * Post-conditions: <code>PlanarShape</code> object is added to the start of the list</p>
     *
     * @param data The <code>PlanarShape</code> object to be prepended to the list
     */
    public void prepend(final T data) throws UnsupportedOperationException {
        final Node<T> newNode = new Node<>(data, sentinel.getNext(), sentinel);
        sentinel.getNext().setPrev(newNode);
        sentinel.setNext(newNode);
        size++;
    }

    /**
     * <p>Add item to list</p>
     * <p>Pre-conditions: None<br/>
     * Post-conditions: <code>PlanarShape</code> object is added to the list</p>
     *
     * @param data The <code>PlanarShape</code> object to be added to the list
     * @see LinkedList#append(PlanarShape)
     */
    public void insert(final T data) throws UnsupportedOperationException {
        append(data);
    }

    /**
     * <p>Returns to the head of the list</p>
     * <p>Pre-conditions: None<br/>
     * Post-conditions: <code>current</code> is updated to reference the node located at the start of the list</p>
     *
     * @throws Exception When used on a <code>LinkedList</code> object
     * @deprecated Incompatible with <code>LinkedList</code>
     */
    @Deprecated
    public void reset() throws Exception {
        throw new Exception("Use of reset() on LinkedList is invalid");
    }

    /**
     * <p>Steps to the next item in the list</p>
     * <p>Pre-conditions: List is not empty<br/>
     * Post-conditions: <code>current</code> is updated to reference the next node in the list</p>
     *
     * @throws Exception When used on a <code>LinkedList</code> object
     * @deprecated Incompatible with <code>LinkedList</code>
     */
    @Deprecated
    public void next() throws Exception {
        throw new Exception("Use of next() on LinkedList is invalid");
    }


    /**
     * Removes the item from the head of the list and returns its data
     *
     * @return The data of the removed <code>Node</code> object
     */
    public T pop() {
        final Node<T> head = sentinel.getNext();
        head.getNext().setPrev(sentinel);
        sentinel.setNext(head.getNext());
        return head.getData();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = sentinel;

            @Override
            public boolean hasNext() {
                return current.getNext() != sentinel;
            }

            @Override
            public T next() {
                current = current.getNext();
                return current.getData();
            }

            @Override
            public void remove() {
                if (size > 0) {
                    Node<T> temp = current.getPrev();
                    next();
                    temp.setNext(current);
                    current.setPrev(temp);
                }
            }

            @Override
            public void forEachRemaining(Consumer<? super T> action) {
                Iterator.super.forEachRemaining(action);
            }


        };
    }
    // TODO Implement iterator

    @Override
    public String toString() {
        if (size > 0) {
            Iterator<T> iterator = iterator();
//            iterator.
        }
        return null;
    }
}
