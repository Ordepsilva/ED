/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_05;

/**
 *
 * @author Pedro
 */
public class DoubleNode<T> {
    private DoubleNode<T> next;
    private T element;
    private DoubleNode<T> previous;

    public DoubleNode() {
    next=null;
    element=null;
    previous=null;
    
    }

    public DoubleNode(T elem) {
        this.element = elem;
        next=null;
        previous=null;
    }
    
    public DoubleNode<T> getNext(){
        return next;
    }
    
    public DoubleNode<T> getPrevious(){
        return previous;

    }
        public void setPrevious (DoubleNode<T> node)
    {
       previous = node;
    }
    public void setNext(DoubleNode<T> node){
        next=node;
    }
    
    public void setElement(T elem){
        this.element= elem;
    }
    public T getElem(){
        return element;
    }
}
