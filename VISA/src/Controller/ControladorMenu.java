/**
 * 
 */
package Controller;

import View.Menu;
import View.View;

public class ControladorMenu extends Controller{
    private Menu menu;
    public ControladorMenu(){
        
    }
    @Override
    public void conectarVista(View v) {
        this.menu = (Menu)v;
        this.menu.conectarControlador(this);
    }

    @Override
    public void correr(ControladorPrincipal p) {
        super.correr(p);
        menu.mostrar();
    }
    
    public void manejarNuevo(){
        p.manejarNuevo();
    }
    public void manejarSeguir(){
        p.manejarSeguir();
    }
    
    public void manejarSalir(){
        p.manejarSalir();
    }
    public void cerrar(){
        menu.setVisible(false);
        menu.dispose();
    }
    
    
}
