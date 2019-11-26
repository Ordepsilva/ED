/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_04;

import ed_03.EmptyCollectionException;
import ed_03.LinkedNode;

/**
 *
 * @author Pedro
 */
public class LinkedQueue<T> implements QueueADT<Object> {

    private LinkedNode<T> front, rear;
    private int count;

    public LinkedQueue() {
        front = rear = null;
        count = 0;
    }

    //  Adds the specified element to the rear of the queue.
    @Override
    public void enqueue(Object element) {
        LinkedNode<T> node = new LinkedNode<T>((T) element);
        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }
        rear = node;
        count++;

    }
//  Removes the element at the front of the queue and returns a
    //  reference to it. Throws an EmptyCollectionException if the
    //  queue is empty.

    @Override
    public Object dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        T result = front.getN();
        front = front.getNext();
        count--;
        if (isEmpty()) {
            rear = null;
        }

        return result;
    }

    @Override
    public Object first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        return front.getN();
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String result = "";
        LinkedNode<T> current = front;

        while (current != null) {
            result = result + (current.getN()).toString() + "\n";
            current = current.getNext();
        }
        return result;
    }

}
