/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_05;

import ed_05.interfaces.ListADT;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author pedro
 */
public class ArrayList<T> implements ListADT<T> {

    protected static final int DEFAULT_CAPACITY = 100;
    private static final int NOT_FOUND = -1;
    
    protected int rear;
    
    T[] list;

    public ArrayList() {
        this.rear = 0;
        this.list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int inicialSize) {
        rear = 0;
        list = (T[]) new Object[inicialSize];
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {   
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
 
         T  result = list[0];
        rear--;
        for (int i = 0; i < rear; i++) {
            list[i] = list[i + 1];
        }
        list[rear] = null;

        return result;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        T result;
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        
        rear--;
        result = list[rear];
        list[rear] = null;
       
        return result;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException {

        T result;

        int index = find(element);
        if (index == NOT_FOUND) {
            throw new EmptyCollectionException("list");
        }
        result = list[index];
        rear--;

        for (int i = 0; i < rear; i++) {
            list[i] = list[i + 1];
        }
        
        list[rear] = null;
        
        return result;
    }

    private int find(T target) {
        int scan = 0, result = NOT_FOUND;
        boolean found = false;

        if (!isEmpty()) {
            while (!found && scan < rear) {
                if (target.equals(list[scan])) {
                    found = true;
                } else {
                    scan++;
                }
            }
        }

        if (found) {
            result = scan;
        }

        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        return list[0];
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        return list[rear - 1];
    }

    @Override
    public boolean contains(T target) {
        return (find(target) != NOT_FOUND);
    }

    @Override
    public boolean isEmpty() {
        return rear == 0;
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(list, rear);
    }

    public String toString() {
        String result = "";

        for (int scan = 0; scan < rear; scan++) {
            result +=  list[scan].toString() + "\n";
        }

        return result;
    }

    protected void expandCapacity() {
        T[] larger = (T[]) (new Object[list.length * 2]);

        for (int scan = 0; scan < list.length; scan++) {
            larger[scan] = list[scan];
        }

        list = larger;
    }
    
   
    public class ArrayIterator<T> implements Iterator {

    private int count;
    private int current;
    private T[] items;

    public ArrayIterator(T[] collection, int size) {
        items = collection;
        count = size;
        current = 0;
    }

    @Override
    public boolean hasNext() {
        return (current < count);
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        
        current++;
        return items[current - 1];
    }
}
}

