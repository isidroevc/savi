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
    public static boolean validarFecha(String f){
        if(Formatos.toDate(f) == null){
            return false;
        }
        return true;
    }
    
    public static boolean validarNombres(String n){
        int cuenta = 0;
        if(n.length() == 0 || n.length() > 25)
            return false;
        if(!haySoloLetras(n)){
            return false;
        }
        return true;
    }
    public static int contarCaracteres(String s,char c){
        int cuenta = 0;
        char[]  array = new char[s.length()];
        s.getChars(0, s.length(), array, 0);
        for(int i =0,aux = s.length(); i < aux; i++){
            if(array[i] == c)
                cuenta++;
        }
        return cuenta;
    }
    
    public static boolean haySoloLetras(String s){
        char[]  array = new char[s.length()];
        s.getChars(0, s.length(), array, 0);
        if(s.length() == 0)
            return false;
        for(int i =0,aux = s.length(); i < aux; i++){
            if(!Character.isLetter(array[i]) && !Character.isSpaceChar(array[i])){
                return false;
            }
        }
        return true;
    }
    
    public static boolean haySoloEspacios(String s){
        char[]  array = new char[s.length()];
        s.getChars(0, s.length(), array, 0);
        if(s.length() == 0)
            return false;
        for(int i =0,aux = s.length(); i < aux; i++){
            if(!Character.isSpaceChar(array[i])){
                return false;
            }
        }
        return true;
    }
    
    public static boolean validarTelefono(String s){
        try{
            Long.parseLong(s);
        }catch(Exception ex){
            return false;
        }
        return s.length() == 10;
    }
}
