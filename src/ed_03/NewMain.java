/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_03;

import ed_04.CircularArrayQueue;
import ed_04.LinkedQueue;

/**
 *
 * @author Pedro
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        ArrayStack<Integer> s = new ArrayStack<>();
        LinkedStack<Integer> n = new LinkedStack<>();
        LinkedQueue<Integer> myqueue = new LinkedQueue<>();
        CircularArrayQueue<Integer> circularqueue = new CircularArrayQueue<>();
        int ex = 8;
        switch (ex) {
            /* Adiciona 6 numeros e remove 5
            ArrayStack*/
            case 1:

                for (int i = 0; i < 6; i++) {
                    s.push(i);
                }
                System.out.println(s);
                for (int i = 0; i < 5; i++) {
                    s.pop();
                }

                System.out.println(s);
                break;
            case 2:
                /* Tenta remover sem ter numeros
                ArrayStack*/
                s.pop();
                break;
            case 3:
                /* LinkedStack test add 6 remove 5*/

                for (int i = 0; i < 6; i++) {
                    n.push(i);
                }
                System.out.println(n);
                for (int i = 0; i < 3; i++) {
                    n.pop();
                }

                System.out.println(n);
                break;
            case 4:
                /* LINKEDSTACK
                 remove when is empty*/
                n.pop();
                break;
            case 5:
                /*LinkedQueue Test 
                Adiciona 6 na queue*/
                for (int i = 0; i < 6; i++) {
                    myqueue.enqueue(i);
                    myqueue.first();
                }
                System.out.println(myqueue);

                for (int i = 0; i < 5; i++) {
                    myqueue.dequeue();
                }
                System.out.println(myqueue);
                break;
            case 6:
                /*LinedQueue Test dequeue sem ter nenhum */
                myqueue.enqueue(3);
                myqueue.enqueue(2);
                System.out.println(myqueue);
                for (int i = 0; i < 3; i++) {
                    myqueue.dequeue();
                }

                System.out.println(myqueue);
                break;
            case 7:
                /*circular array queue test */
                for (int i = 0; i < 10; i++) {
                    circularqueue.enqueue(i);
                }
                for (int i = 0; i < 4; i++) {
                    circularqueue.dequeue();
                    System.out.println(circularqueue);
                }
                break;
            case 8:
                /* cricular array 
                verifica se está a remover certo 
                */
                circularqueue.enqueue(3);
                System.out.println(circularqueue.size());
                circularqueue.enqueue(4);
                System.out.println(circularqueue);
                circularqueue.dequeue();
                System.out.println(circularqueue.size());
                System.out.println(circularqueue.first());
                System.out.println(circularqueue);
                circularqueue.dequeue();
                System.out.println(circularqueue.size());
                break;
        }
        
    }

}
