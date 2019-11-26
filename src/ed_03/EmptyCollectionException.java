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
public class EmptyCollectionException extends Exception {

    public EmptyCollectionException(String e) {
        super("the" + e + " is empty");
    }

   
}
