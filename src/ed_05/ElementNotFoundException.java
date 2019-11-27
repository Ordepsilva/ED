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
public class ElementNotFoundException extends Exception {

    //-----------------------------------------------------------------
   public ElementNotFoundException (String collection)
   {
      super ("The target element is not in this " + collection);
   }
}
