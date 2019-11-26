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
public class LinkedNode<T> {

    private T element;
    private LinkedNode next;

    public LinkedNode() {
        element = null;
        next = null;
    }

    public LinkedNode(T cena) {
        this.next = null;
        this.element = cena;
    }

    public T getN() {
        return element;
    }

    public void setN(T cena) {
        this.element = cena;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedNode<T> node) {
        next = node;
    }

 
}
