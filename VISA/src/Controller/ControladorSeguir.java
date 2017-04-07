/**
 * 
 */
package Controller;

import View.SeguirTramite;
import View.View;


public class ControladorSeguir extends Controller{

    private SeguirTramite seguir;
    @Override
    public void conectarVista(View v) {
        this.seguir = (SeguirTramite)v;
    }
    @Override
    public void correr(ControladorPrincipal p){
        super.correr(p);
        seguir.mostrar();
    }
}
