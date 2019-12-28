/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_05;

import ed_05.interfaces.UnorderedListADT;

/**
 *
 * @author Pedro
 */
public class DoubleLinkedUnorderedList<T> extends DoubleList<T> implements UnorderedListADT<T> {

    public DoubleLinkedUnorderedList(){
        super();
    }
  
    /**
     * Método que adiciona um elemento à primeira posição da lista.
     *
     * @param element elemento que se pretende adicioanr à primeira posição da
     * lista.
     */
    @Override
    public void addToFront(T element) {
        if (!element.equals(null)) {
            DoubleNode<T> newNode = new DoubleNode<>(element);

            if (this.isEmpty()) {
                this.front = newNode;
                this.rear= newNode;
            } else {
                newNode.setNext(this.front);
                this.front.setPrevious(newNode);
                this.front = newNode;
            }

            this.count++;
        }
    }

    /**
     * Método que adiciona um elemento à última posição da lista.
     *
     * @param element elemento que se pretende adicioanr à última posição da
     * lista.
     */
    @Override
    public void addToRear(T element) {
        if (!element.equals(null)) {

            DoubleNode<T> newNode = new DoubleNode<>(element);

            if (this.isEmpty()) {
                this.front = newNode;
                this.rear = newNode;
            } else {
                newNode.setPrevious(this.rear);
                newNode.setNext(null);
                this.rear.setNext(newNode);
                this.rear= newNode;
            }

            this.count++;
        }
    }

    /**
     * Método que adiciona um elemento na posição a seguir a um específico
     * elemento.
     *
     * @param element elemento que se pretende adicioanr à lista.
     * @param target elemento objetivo.
     * @throws ElementNotFoundException se o elemento objetivo não for
     * encontrado.
     */
    @Override
    public void addAfter(T element, T target) throws ElementNotFoundException {
        if (!element.equals(null) && !target.equals(null)) {

            DoubleNode<T> newNode = new DoubleNode<>(element);
            DoubleNode<T> targetNode = new DoubleNode<>(target);

            if (this.isEmpty()) {
                throw new ElementNotFoundException("A lista encontra-se vazia, logo não se pode adicionar o elemento a seguir a outro");
            }

            boolean found = false;
            DoubleNode<T> current = this.front;
            DoubleNode<T> nextOne = this.front.getNext();

            while (current != null || found != true) {
                if (current.getElem().equals(targetNode.getElem())) {
                    found = true;
                    current.setNext(newNode);
                    nextOne.setPrevious(newNode);
                    newNode.setPrevious(current);
                    newNode.setNext(nextOne);
                } else {
                    current = current.getNext();
                    nextOne = current.getNext();
                }
            }

            if (!found) {
                throw new ElementNotFoundException("list");
            }

            this.count++;

        }
    }
}
