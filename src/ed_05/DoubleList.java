/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_05;

import ed_05.interfaces.ListADT;
import java.util.Iterator;

/**
 *
 * @author Pedro
 */
public class DoubleList<T> implements ListADT<T> {

    protected DoubleNode<T> front, rear;
    protected int count;

    public DoubleList() {
        front = rear = null;
        count = 0;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        T result = front.getElem();
        front = front.getNext();
        if (front == null) {
            rear = null;
        } else {
            front.setPrevious(null);
        }

        count--;
        return result;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        T result = rear.getElem();
        rear = rear.getPrevious();
        if (rear == null) {
            front = null;
        } else {
            rear.setNext(null);
        }
        count--;
        return result;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException {
        T result;
        DoubleNode<T> node = find(element);

        if (node == null) {
            throw new EmptyCollectionException("list");
        }
        result = node.getElem();

        if (result == front) {
            result = this.removeFirst();
        } else if (result == rear) {
            result = this.removeLast();
        } else {
            node.getNext().setPrevious(node.getPrevious());
        }
        node.getPrevious().setNext(node.getNext());
        count--;

        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        return front.getElem();
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        return rear.getElem();
    }

    @Override
    public boolean contains(T target) {
        return (find(target) != null);
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
    public Iterator<T> iterator() {
        return new DoubleIterator<T>(count, front);
    }

    private DoubleNode<T> find(T element) {
        boolean found = false;
        DoubleNode<T> x = front;
        DoubleNode<T> result = null;

        if (!isEmpty()) {
            while (!found && x != null) {
                if (element.equals(x.getElem())) {
                    found = true;
                } else {
                    x = x.getNext();
                }
            }
        }

        if (found) {
            result = x;
        }

        return result;
    }
    
    public String toString(){
        String result="";
        DoubleNode<T> traverse = front;
        while(traverse != null){
            result = result + (traverse.getElem()).toString() + "\n";
            traverse = traverse.getNext();
        }
        return result;
    }
}
