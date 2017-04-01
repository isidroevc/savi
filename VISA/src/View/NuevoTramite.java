/**
 * NuevoTramite.java
 * 
 * Esta vista corresponde a la funcionalidad de comenzar un nuevo trámite.
 * 
 * ITL-POO
 * 
 * Vásquez Cortés Isidro Emmanuel
 * 
 */
package View;

import Controller.Controller;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
public class NuevoTramite extends View {
    // -Atributos
    JFXPanel c;
    // -Métodos Constructores
    //Constructor sin parámetros
    public NuevoTramite(){
        crear();
    }
    
    
    // -Métodos específicos de funcionamiento
    
    @Override
    public void conectarControlador(Controller c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void crear() {
        c = new JFXPanel();
        c.setSize(640,480);
        Platform.runLater(() -> {
        WebView webView = new WebView();
        c.setScene(new Scene(webView));
        webView.getEngine().load("http://www.stackoverflow.com/");
        this.setLayout(null);
        this.setSize(640,480);
        c.setBounds(0,0,640,480);
        this.add(c);
});
    }

    @Override
    protected void armar() {
        this.setVisible(true);
    }
    
}
