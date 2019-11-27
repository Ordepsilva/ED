/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_05;

/**
 *
 * @author pedro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        ArrayOrderedList<Integer> n = new ArrayOrderedList();
        ArrayUnorderedList<Integer> u = new ArrayUnorderedList();
        int ex = 2;
        switch (ex) {

            case 1:
                //adiciona 4 elementos ao array , remove o ultimo , verifica se contem , size, 
                n.add(3);
                System.out.println(n.toString());
                n.add(4);
                System.out.println(n.toString());
                n.add(7);
                System.out.println(n.toString());
                n.add(6);
                System.out.println(n.toString());
                n.removeLast();
                System.out.println(n.toString());
                System.out.println("" + n.contains(3));
                System.out.println("" + n.size());
                break;
            case 2:
                //UnorderedList add, remove
                u.addToFront(3);
                u.addToRear(4);
                System.out.println(u.toString());

                u.addToFront(2);
                System.out.println(u.toString());
                u.removeFirst();
                System.out.println(u.toString());
                u.addAfter(7, 3);
                System.out.println(u.toString());
                break;
        }
    }

}
