/**
 * ControladorLogin.java
 * 
 * Esta clase corresponde a la lógica de la parte de login para el agente en 
 * cuestión, se encarga de validar un usuario y contraseña, y mandar el flujo
 * de ejecución según corresponda.
 * 
 * ITL-POO
 * 
 * Vasquez Cortés Isidro Emmanuel
 */
package Controller;

import Model.Agente;
import View.Login;
import View.View;
import Utilidades.Validaciones;
public class ControladorLogin extends Controller{
    private Login login;
    
    // - Constructores
    public ControladorLogin(){
        
    }
    
    // -Métodos de acceso
    @Override
    public void conectarVista(View v){
        this.login = (Login)v;
        this.login.conectarControlador(this);
    }
    
    // -Métodos específicos de funcionamiento
    //Este método valida si se loggea o no
    public void ingresar(String idString, String pass){
        //Primero hay quue validar los datos
        int id = 0;
        Agente agente;
        //En caso que los datos sean validos
        if(Validaciones.validarEntero(idString.trim()) && pass.length() >= 6){
            id = Integer.parseInt(idString.trim());
            //Se verifica que no se haya introducido un número negativo
            if(id < 0){
                login.mandarMensaje("Id no válido, no hay ids negativos");
            }
        }
        else{
            if(!Validaciones.validarEntero(idString)){
                login.mandarMensaje("Id no válido, sólo numeros");
            }
            if(!(pass.length() >= 6)){
                login.mandarMensaje("Escriba una contraseña, mínimo 6 caracteres");
            }
        }
        agente = Agente.buscarPorId(id);
        if(agente != null){
            if(agente.getPassword().equals(pass)){
                login.mandarMensaje("Bienvenido " + agente.getNombres());
                //TODO: Hace que se abra el menú
            
            }else{
                login.mandarMensaje("ID o contraseña incorrectos, por favor verifique");
            }
        }
    }
    @Override
    public void correr(){
        this.login.mostrar();
    }
}
