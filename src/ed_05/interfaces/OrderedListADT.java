/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_05.interfaces;

/**
 *
 * @author pedro
 */
public interface OrderedListADT<T> extends ListADT<T> {
     //  Adds the specified element to this list at the proper location
   public void add (T element);
}
