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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class NuevoTramite extends View {
    // -Atributos
    JFXPanel c;
    JPanel panelA,
           panelB;
    
    JLabel aNom,
           aApellidoP,
           aApellidoM,
           aDireccion,
           aTelefono,
           aCelular,
           aFechaN,
           aFechaAlta,
           bNom,
           bApellidoP,
           bApellidoM,
           bDireccion,
           bTelefono,
           bCelular,
           bFechaN, 
           fondo;
    
    JTextField aNom1,
               aApellidoP1,
               aApellidoM1,
               aDireccion1,
               aTelefono1,
               aCelular1,
               aFechaN1,
               aFechaAlta1,
               bNom1,
               bApellidoP1,
               bApellidoM1,
               bDireccion1,
               bTelefono1,
               bCelular1,
               bFechaN1; 
    JButton siguiente,
            anterior;
    private String path="src/Imagenes/";
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
        
        //Apartir de aqui es lo que hice yo 
        
        //Primer panel pertenece al Acreedor
        panelA = new JPanel();
        aNom = new JLabel("Nombre(s)");
        aApellidoP = new JLabel("Apellido paterno");
        aApellidoM = new JLabel("Apellido materno");
        aDireccion = new JLabel("Direccion");
        aTelefono = new JLabel("Numero de Telefono");
        aCelular = new JLabel("Numero de Celular");
        aFechaN = new JLabel("Fecha de Nacimiento");
        aFechaAlta= new JLabel("Fecha del tramite");
        
        aNom1 = new JTextField();
        aApellidoP1 = new JTextField();
        aApellidoM1 = new JTextField();
        aDireccion1 = new JTextField();
        aTelefono1 = new JTextField();
        aCelular1 = new JTextField();
        aFechaN1 = new JTextField();
        aFechaAlta1 = new JTextField();
        
        //Segundo Panel
        panelB = new JPanel();
        bNom = new JLabel("Nombre(s)");
        bApellidoP = new JLabel("Apellido paterno");
        bApellidoM = new JLabel("Apellido materno");
        bDireccion = new JLabel("Direccion");
        bTelefono = new JLabel("Numero de Telefono");
        bCelular = new JLabel("Numero de Celular");
        bFechaN = new JLabel("Fecha de Nacimiento");
        
        bNom1 = new JTextField();
        bApellidoP1 = new JTextField();
        bApellidoM1 = new JTextField();
        bDireccion1 = new JTextField();
        bTelefono1 = new JTextField();
        bCelular1 = new JTextField();
        bFechaN1 = new JTextField();
        
        fondo= new JLabel();
        siguiente = new JButton("siguiente");
        anterior = new JButton ("anterior");
});
    }

    @Override
    protected void armar() {
        this.setTitle("Nuevo tramite");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
        //Apartir de aqui es lo que hice yo 
        panelA.setLayout(null);
        panelB.setLayout(null);
        
        fondo.setIcon(new ImageIcon(path+"Nombre de la imagen"));   //Fondo del menu
        fondo.setBounds(0, 0, 1000,1000);
        
        //Elementos del primer panel pertenecientes al Acreedor
        aNom.setBounds(10, 10, 90, 30);
        aNom.setFont(new Font("Arial",1,15));
        aNom1.setBounds(110, 10, 200, 30);
        
        aApellidoP.setBounds(10, 50,120, 30);
        aApellidoP.setFont(new Font("Arial",1,15));
        aApellidoP1.setBounds(140, 50, 200, 30);
        
        aApellidoM.setBounds(10, 90,120, 30);
        aApellidoM.setFont(new Font("Arial",1,15));
        aApellidoM1.setBounds(140, 90, 200, 30);
        
        aDireccion.setBounds(10, 130,90, 30);
        aDireccion.setFont(new Font("Arial",1,15));
        aDireccion1.setBounds(110, 130, 200, 30);
        
        aTelefono.setBounds(10, 170,150, 30);
        aTelefono.setFont(new Font("Arial",1,15));
        aTelefono1.setBounds(170, 170, 200, 30);
        
        aCelular.setBounds(10, 210,150, 30);
        aCelular.setFont(new Font("Arial",1,15));
        aCelular1.setBounds(170, 210, 200, 30);
        
        aFechaN.setBounds(10, 250,150, 30);
        aFechaN.setFont(new Font("Arial",1,15));
        aFechaN1.setBounds(170, 250, 200, 30);
        
        aFechaAlta.setBounds(10, 290,150, 30);
        aFechaAlta.setFont(new Font("Arial",1,15));
        aFechaAlta1.setBounds(170, 290, 200, 30);
        
        siguiente.setBounds(370, 400,100, 30);
        siguiente.addActionListener(new accion());
        
        panelA.add(aNom);
        panelA.add(aNom1);
        panelA.add(aApellidoP);
        panelA.add(aApellidoP1);
        panelA.add(aApellidoM);
        panelA.add(aApellidoM1);
        panelA.add(aDireccion);
        panelA.add(aDireccion1);
        panelA.add(aTelefono);
        panelA.add(aTelefono1);
        panelA.add(aCelular);
        panelA.add(aCelular1);
        panelA.add(aFechaN);
        panelA.add(aFechaN1);
        panelA.add(aFechaAlta);
        panelA.add(aFechaAlta1);
        panelA.add(siguiente);
        
        //Elementos del segundo panel pertenecientes al representante 
        bNom.setBounds(10, 10, 90, 30);
        bNom.setFont(new Font("Arial",1,15));
        bNom1.setBounds(110, 10, 200, 30);
        
        bApellidoP.setBounds(10, 50,120, 30);
        bApellidoP.setFont(new Font("Arial",1,15));
        bApellidoP1.setBounds(140, 50, 200, 30);
        
        bApellidoM.setBounds(10, 90,120, 30);
        bApellidoM.setFont(new Font("Arial",1,15));
        bApellidoM1.setBounds(140, 90, 200, 30);
        
        bDireccion.setBounds(10, 130,90, 30);
        bDireccion.setFont(new Font("Arial",1,15));
        bDireccion1.setBounds(110, 130, 200, 30);
        
        bTelefono.setBounds(10, 170,150, 30);
        bTelefono.setFont(new Font("Arial",1,15));
        bTelefono1.setBounds(170, 170, 200, 30);
        
        bCelular.setBounds(10, 210,150, 30);
        bCelular.setFont(new Font("Arial",1,15));
        bCelular1.setBounds(170, 210, 200, 30);
        
        bFechaN.setBounds(10, 250,150, 30);
        bFechaN.setFont(new Font("Arial",1,15));
        bFechaN1.setBounds(170, 250, 200, 30);
        
        anterior.setBounds(10, 400, 100, 30);
        anterior.addActionListener(new accion());
        
        panelB.add(bNom);
        panelB.add(bNom1);
        panelB.add(bApellidoP);
        panelB.add(bApellidoP1);
        panelB.add(bApellidoM);
        panelB.add(bApellidoM1);
        panelB.add(bDireccion);
        panelB.add(bDireccion1);
        panelB.add(bTelefono);
        panelB.add(bTelefono1);
        panelB.add(bCelular);
        panelB.add(bCelular1);
        panelB.add(bFechaN);
        panelB.add(bFechaN1);
        panelB.add(anterior);
    }
    
    public class accion implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
}
