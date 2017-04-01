/**
 * TestControladorLogin.java
 * 
 * Aquí se prueba el funcionamiento del controlador del login
 * 
 * ITL-POO
 * 
 * Vásquez Cortés Isidro Emmanuel.
 */
package Test;

import Controller.ControladorLogin;
import View.Login;

public class TestControladorLogin {

    public static void main(String[] args) {
        ControladorLogin controlador = new ControladorLogin();
        controlador.conectarVista(new Login());
        controlador.correr();
    }
    
}
