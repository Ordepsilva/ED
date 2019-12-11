/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_05;

import ed_05.interfaces.UnorderedListADT;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    public ArrayUnorderedList() {
        super();
    }

    public ArrayUnorderedList(int inicialSize) {
        super(inicialSize);
    }

    @Override
    public void addToFront(T element) {
        if (size() == list.length) {
            expandCapacity();
        }

        // shift elements to make room
        for (int scan = rear; scan > 0; scan--) {
            list[scan] = list[scan - 1];
        }

        list[0] = element;
        rear++;
    }

    @Override
    public void addToRear(T element) {
        if (size() == list.length) {
            expandCapacity();
        }

        list[rear] = element;
        rear++;
    }

    @Override
    public void addAfter(T element, T target) {
        if (size() == list.length) {
            expandCapacity();
        }

        int scan = 0;
        while (scan < rear && !target.equals(list[scan])) {
            scan++;
        }

        if (scan == rear) {
            try {
                throw new ElementNotFoundException("list");
            } catch (ElementNotFoundException ex) {
                Logger.getLogger(ArrayUnorderedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        scan++;
        
        for (int scan2 = rear; scan2 > scan; scan2--) {
            list[scan2] = list[scan2 - 1];
        }

        list[scan] = element;
        rear++;
    }

}
