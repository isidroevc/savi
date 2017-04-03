/**
 * View.java
 * 
 * Clase de la cual deberán derivar  todas las vistas, que contiene como base
 * el atributo polimórfico Controller.
 * 
 * ITL - POO
 * Vásquez Cortés Isidro Emmanuel
 * 
 */
package View;

import Controller.Controller;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class View extends JFrame{
    //-Atributos
    
    public View(){
        
    }
    
    public abstract void conectarControlador(Controller c);
    protected abstract void crear();
    protected  void armar(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
    }
    
    public void mostrar(){
        this.setVisible(true);
    }
    // -Métodos de funcionamiento
    
    public void mandarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje);
    }
}
