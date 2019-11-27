/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_05;

import ed_05.interfaces.OrderedListADT;
import java.util.Iterator;

/**
 *
 * @author pedro
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {
    //-----------------------------------------------------------------
    //  Creates an empty list using the default capacity.
    //-----------------------------------------------------------------

    public ArrayOrderedList() {
        super();
    }

    //-----------------------------------------------------------------
    //  Creates an empty list using the specified capacity.
    //-----------------------------------------------------------------
    public ArrayOrderedList(int initialCapacity) {
        super(initialCapacity);
    }

    //-----------------------------------------------------------------
    //  Adds the specified Comparable element to the list, keeping
    //  the elements in sorted order.
    //-----------------------------------------------------------------
    public void add(T element) {
        if (size() == list.length) {
            expandCapacity();
        }

        Comparable<T> temp = (Comparable<T>) element;

        int scan = 0;
        while (scan < rear && temp.compareTo(list[scan]) > 0) {
            scan++;
        }

        for (int scan2 = rear; scan2 > scan; scan2--) {
            list[scan2] = list[scan2 - 1];
        }

        list[scan] = element;
        rear++;
    }

}
