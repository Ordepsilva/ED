/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_05;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Pedro
 */
public class DoubleIterator<T> implements Iterator {

    private int count;
    private DoubleNode<T> current;

    public DoubleIterator(int count, DoubleNode<T> current) {
        this.count = count;
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return (current != null);
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        
        T result = current.getElem();
        current = current.getNext();
        
        return result;
    }

}
