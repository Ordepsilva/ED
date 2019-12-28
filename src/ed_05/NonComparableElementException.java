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
public class NonComparableElementException extends Exception {

    public NonComparableElementException(String collection) {
     super ("The " + collection + " requires comparable elements.");
    }
    
}
