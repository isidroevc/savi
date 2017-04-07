/**
 * 
 */
package Controller;

import Model.Agente;
import View.Login;
import View.Menu;
import View.NuevoTramite;
import View.View;

public class ControladorPrincipal {
    private Agente agente; //el agente que actualmente esta loggeado.
    private ControladorLogin login;
    private ControladorMenu menu;
    private ControladorNuevoTramite tramite;
    public ControladorPrincipal(){
        
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }
    
    public void correr(){
        //lo primero que debe correr es el login
        irALogin();
    }
    public void irALogin(){
        login = new ControladorLogin();
        login.conectarVista(new Login());
        login.correr(this);
    }
    public void manejarIngreso(Agente a){
        this.agente = a;
        login.cerrar();
        irAMenu();
    }
    public void irAMenu(){
        menu = new ControladorMenu();
        menu.conectarVista(new Menu());
        menu.correr(this);
    }
    public void irANuevoTramite(){
        tramite = new ControladorNuevoTramite();
        tramite.conectarVista(new NuevoTramite());
        tramite.correr(this);
    }
    
    public void irASeguirTramite(){
        
    }
    
    public void manejarNuevo(){
        menu.cerrar();
        irANuevoTramite();
    }
    public void manejarSeguir(){
        menu.cerrar();
        irASeguirTramite();
    }
    public void manejarSalir(){
        menu.cerrar();
        irALogin();
    }
    
    public void manejarTramiteFinalizado(){
        tramite.cerrar();
        irAMenu();
    }
    
    public void manejarNuevoTramiteCerrado(){
        tramite.cerrar();
        irAMenu();
    }
}
