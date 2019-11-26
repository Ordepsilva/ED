/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_03;

/**
 *
 * @author Pedro
 */
public class LinkedStack<T> implements StackADT<T> {

    private LinkedNode<T> top;
    private int count;

    public LinkedStack() {
        this.top = null;
        this.count = 0;
    }

    @Override
    public void push(T element) {
        LinkedNode<T> temp = new LinkedNode<T>(element);

        temp.setNext(top);
        top = temp;
        count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }

        T result = top.getN();
        top = top.getNext();
        count--;

        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }

        return top.getN();
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    public String toString() {
        String result = "";
        LinkedNode current = top;

        while (current != null) {
            result = result + (current.getN()).toString() + "\n";
            current = current.getNext();
        }

        return result;
    }

}
