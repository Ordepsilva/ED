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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();
        lista.add("sim");
        lista.add("não");
        lista.add("tau");
        
        lista.remove("tau");
        
        System.out.println(lista.toString());
    }
    
}
