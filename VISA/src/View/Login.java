/*
    *Interfaz para entrar
 */
package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login {
    private JFrame ventana;
    private JPanel panel;
    private JLabel fondo;
    private JLabel imgUsuario;
    private JLabel etiquetaId;
    private JLabel etiquetaPassword;
    private JButton entrar;
    private String path="src/Imagenes/";
    
    void show(){
        crear();
        armar();
        mostrar();
    }

    private void crear() {
        ventana=         new JFrame();
        panel=         new JPanel();
        fondo=         new JLabel();
        imgUsuario=    new JLabel();
        etiquetaId=     new JLabel();
        etiquetaPassword=new JLabel();
        entrar=         new JButton("entrar");
    }

    private void armar() {
        ventana.setTitle("Agent Profile");
        ventana.setSize(450, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        //ventana.setUndecorated(true); --> Elimina el marco del frame
        
        panel.setLayout(null);
        
        fondo.setIcon(new ImageIcon(path+"")); // -- Imagen del fondo --
        fondo.setBounds(0, 0, 450, 500);
        
        imgUsuario.setIcon(new ImageIcon(path+"usuario_icono.png"));
        imgUsuario.setBounds(150, 50, 128, 128);
        
        
        
        panel.add(fondo);
        
        
    }

    private void mostrar() {
        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
