/**
 * 
 */
package Test;

import Controller.ControladorNuevoTramite;
import Model.Representante;
import View.NuevoTramite;
import Utilidades.Validaciones;

public class TestNuevoTramite {


    public static void main(String[] args) {
        ControladorNuevoTramite c = new ControladorNuevoTramite();
        c.conectarVista(new NuevoTramite());
        c.correr();
        //System.out.println(Representante.buscarPorId(1).toString());
    }
    
}
