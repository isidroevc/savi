/**
 * Validaciones.java
 * 
 * Esta clase contiene métodos estáticos para la validacion de diferentes tipos
 * de datos.
 * 
 * ITL - POO
 * 
 * Vasquez Cortés Isidro Emmanuel
 * 
 */
package Utilidades;

public class Validaciones {
    
    //Validacion de numéricos
    public static boolean validarEntero(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
