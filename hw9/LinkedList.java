package aadikatyal.cs1331.hw9;

/* I worked on the assignment alone, using only course-provided materials. */

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Declaring a class called LinkedList that can be used to create a linked list
 * of any type.
 *
 * @author aadikatyal
 * @version 1.0
 * @param <T> Type of data
 */
public class LinkedList<T> {
    private Node<T> head;
    private int size;

    /**
     * This is the constructor for the LinkedList class. It initializes the head of
     * the list to null and the size of the list to 0.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * If the index is valid, add a new node at the given index with the provided
     * data.
     *
     * @param data  The data to be added to the list.
     * @param index The index at which to add the data.
     */
    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is out of bounds");
        }

        if (index == 0) {
            head = new Node<T>(data, head);
        } else {
            Node<T> newNode = new Node<>(data, null);

            Node<T> current = head;
            int currentIndex = 0;

            while (currentIndex != index - 1) {
                current = current.getNext();
                currentIndex++;
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

        size++;
    }

    /**
     * If the index is valid, remove the node at the given index and return the data
     * it contains.
     *
     * @param index The index of the element to be removed.
     * @return The data of the node that was removed.
     */
    public T removeFromIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is out of bounds");
        }

        T data;

        if (isEmpty()) {
            data = null;
        } else if (index == 0) {
            data = head.getData();
            head = head.getNext();
        } else {
            Node<T> current = head;
            int currentIndex = 0;

            while (currentIndex != index - 1) {
                current = current.getNext();
                currentIndex++;
            }

            data = current.getNext().getData();
            current.setNext(current.getNext().getNext());
        }

        size--;

        return data;
    }

    /**
     * This function removes all the elements from the list.
     */
    public void clear() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is already empty");
        }

        while (!isEmpty()) {
            removeFromIndex(0);
        }
    }

    /**
     * Get the data at the specified index by starting at the head and traversing
     * the list until the index is reached.
     *
     * @param index The index of the element to return.
     * @return The data of the node at the given index.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is out of bounds");
        }

        Node<T> current = head;
        int currentIndex = 0;

        while (currentIndex != index) {
            current = current.getNext();
            currentIndex++;
        }

        return current.getData();
    }

    /**
     * If the head is null, then the list is empty.
     *
     * @return The method is returning a boolean value.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Create a new ArrayList, iterate through the linked list, and add each element
     * to the ArrayList.
     *
     * @return An ArrayList of the data in the LinkedList.
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node<T> current = head;

        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }

        return list;
    }

    /**
     * We create a new LinkedList, then we iterate through the current LinkedList,
     * and for each element, we add a new element to the new LinkedList.
     *
     * @return A LinkedList of Strings
     */
    public LinkedList<String> fizzBuzzLinkedList() {
        LinkedList<String> list = new LinkedList<>();

        Node<T> current = head;
        int currentIndex = 0;

        while (current != null) {
            int position = currentIndex + 1;
            String newElement = "";

            if (position % 3 == 0 && position % 5 != 0) {
                newElement = "Fizz";
            } else if (position % 5 == 0 && position % 3 != 0) {
                newElement = "Buzz";
            } else if (position % 5 == 0 && position % 3 == 0) {
                newElement = "FizzBuzz";
            } else {
                newElement = String.format("%d: %s", position, current.getData().toString());
            }

            list.addAtIndex(newElement, currentIndex);
            current = current.getNext();
            currentIndex++;
        }

        return list;
    }
}