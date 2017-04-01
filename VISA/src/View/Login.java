/*
    *Interfaz para entrar
 */
package View;

import Controller.ControladorLogin;
import Controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import Utilidades.Validaciones;

public class Login extends View{
    private JPanel panel;
    private JLabel fondo;
    private JLabel imgUsuario;
    private JLabel labelId;
    private JLabel labelPass;
    private JTextField id;
    private JTextField password;
    private JButton entrar;
    private String path="src/Imagenes/"; 
    
    private ControladorLogin controlador;
    
    public Login(){
        crear();
        armar();
    }
    // -Métodos de acceso
    
    @Override
    public void conectarControlador(Controller c){
        this.controlador = (ControladorLogin)c;
    }
    @Override
    protected void crear() {
        panel =           new JPanel();
        fondo =           new JLabel();
        imgUsuario=      new JLabel();
        id =             new JTextField();
        password =       new JPasswordField();
        entrar =          new JButton("Entrar");
        labelId = new JLabel("ID");
        labelPass = new JLabel("Contraseña");
    }

    @Override
    protected void armar() {
        this.setTitle("Agent Profile");
        this.setSize(450, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        //ventana.setUndecorated(true); --> Elimina el marco del frame
        this.getContentPane().add(panel);
        
        panel.setLayout(null);
        
        fondo.setIcon(new ImageIcon(path + "")); // -- Imagen del fondo --
        fondo.setBounds(0, 0, 450, 500);
        
        imgUsuario.setIcon(new ImageIcon(path + "usuario_icono.png")); //-- Imagen del centro --
        imgUsuario.setBounds(170, 50, 128, 128);
        
        labelId.setBounds(110,180,40,30);
        
        id.setFont(new Font(null, 0, 15)); //-- Campo de texto 1--
        id.setSelectionColor(Color.GREEN);
        id.setBounds(180,180,100,30);
        
        
        labelPass.setBounds(110, 215, 150, 30);

        password.setSelectionColor(Color.GREEN);
        password.setBounds(180,215,100,30);
        entrar.setBounds(180, 250, 100, 30);
        entrar.addActionListener(new Accion());
        
        panel.add(imgUsuario);
        panel.add(labelId);
        panel.add(id);
        panel.add(labelPass);
        panel.add(password);
        panel.add(entrar);
        panel.add(fondo);
    }
    //  -- Accion del boton --
    class Accion implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            controlador.ingresar(id.getText(), password.getText());
        
        }
    }
    
}
