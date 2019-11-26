/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_02;

/**
 *
 * @author Pedro
 */
public class LinkedList<T> {

    private LinkedNode<T> head, tail;
    private int count;

    public LinkedList() {
        this.count = 0;
        this.head = this.tail = null;
    }

    public void setHead(LinkedNode<T> head) {
        this.head = head;
    }

    public void setTail(LinkedNode<T> tail) {
        this.tail = tail;
    }

    public void add(T element) {
        if (head == null) {
            head = new LinkedNode<>(element, null);
            count++;

        } else {
            LinkedNode node = new LinkedNode<>(element, head);
            head = node;
            count++;

        }
        System.out.println("Adicionado elemento: " + element);
    }

    public int SizeList() {
        return this.count;
    }
    

    public String remove(T element) {
        if (head != null) {
            LinkedNode current = head;
            LinkedNode previous = null;
            while (current != null) {
                if (current.getN().equals(element)) {
                    if (previous == null) {
                        head = current.getNext();
                        return "Removido com sucesso";
                    } else {
                        previous.setNext(current.getNext());
                        return "Removido com sucesso";
                    }
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
        } else {
            return "Não ha nodes";
        }
        return "x";
    }

    @Override
    public String toString() {
        String frase = "";
        LinkedNode yup = head;
        while (yup != null) {
            frase = frase + yup.getN() + "\n";
            yup = yup.getNext();
        }
        return frase;
    }
}
