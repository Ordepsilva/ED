/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_04;

import ed_03.EmptyCollectionException;

/**
 *
 * @author Pedro
 */
public class CircularArrayQueue<T> implements QueueADT<T> {

    private final int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;

    public CircularArrayQueue() {
        front = rear = count = 0;
        queue = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public CircularArrayQueue(int inicialSize) {
        queue = (T[]) new Object[inicialSize];
        front = rear = count = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size() == queue.length) {
            expandcapacity();
        }
        queue[rear] = element;
        rear = (rear +1 ) % queue.length;
        count++;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    private void expandcapacity() {
        T[] larger = (T[]) new Object[queue.length * 2];

        for (int i = 0; i < count; i++) {
            larger[i] = queue[front];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = count;
        queue = larger;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;
        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        return queue[front];
    }

    @Override
    public String toString() {
        String result = "";
        int scan = 0;
        while(scan < count){
            if(queue[scan]!= null){
                result += queue[scan].toString() + "\n"; 
            }
            scan++;
        }
        return result;
    }

}
