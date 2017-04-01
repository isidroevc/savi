/**
 * Controller.java
 * 
 * De esta clase se derivarán todos los controlador teniendo ésta comoa atributo
 * base una vista asociada, de la clase polimórfica View.
 * 
 * ITL-POO
 * 
 * Vásquez Cortés Isidro Emmanuel
 */
package Controller;

import View.View;

public abstract class Controller {
    // -Atributos
    
    public abstract void conectarVista(View v);
    
    public abstract void correr();
}
