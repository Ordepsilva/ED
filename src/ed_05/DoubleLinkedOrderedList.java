/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_05;

import ed_05.interfaces.OrderedListADT;

/**
 *
 * @author Pedro
 */
public class DoubleLinkedOrderedList<T> extends DoubleList<T> implements OrderedListADT<T> {

    public DoubleLinkedOrderedList() {
        super();
    }

    @Override
    public void add(T element) throws NonComparableElementException {

        DoubleNode<T> traverse = front;
        DoubleNode<T> newNode = new DoubleNode<T>(element);

        Comparable temp;

        if (element instanceof Comparable) {
            temp = (Comparable) element;
        } else {
            throw new NonComparableElementException("double linked ordered list");
        }

        if (isEmpty()) 
        {
            front = newNode;
            rear = newNode;
        } else if (temp.compareTo(rear.getElem()) >= 0)
        {
            rear.setNext(newNode);
            newNode.setPrevious(rear);
            newNode.setNext(null);
            rear = newNode;
        } else if (temp.compareTo(front.getElem()) <= 0)
        {
            front.setPrevious(newNode);
            newNode.setNext(front);
            newNode.setPrevious(null);
            front = newNode;

        } else
        {
            while ((temp.compareTo(traverse.getElem()) > 0)) {
                traverse = traverse.getNext();
            }
            newNode.setNext(traverse);
            newNode.setPrevious(traverse.getPrevious());
            traverse.getPrevious().setNext(newNode);
            traverse.setPrevious(newNode);
        }

        count++;
    }

}
