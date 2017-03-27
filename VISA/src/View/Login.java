/*
    *Interfaz para entrar
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login {
    private JFrame ventana;
    private JPanel panel;
    private JLabel fondo;
    private JLabel imgUsuario;
    private JTextField id;
    private JTextField password;
    private JButton entrar;
    private String path="src/Imagenes/";
    
    void show(){
        crear();
        armar();
        mostrar();
    }

    private void crear() {
        ventana=         new JFrame();
        panel=           new JPanel();
        fondo=           new JLabel();
        imgUsuario=      new JLabel();
        id =             new JTextField("ID");
        password =       new JTextField("PASSWORD");
        entrar=          new JButton("entrar");
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
        
        imgUsuario.setIcon(new ImageIcon(path+"usuario_icono.png")); //-- Imagen del centro --
        imgUsuario.setBounds(170, 50, 128, 128);
        
        id.setFont(new Font(null, Font.ITALIC, 15)); //-- Campo de texto 1--
        id.setForeground(Color.GRAY);
        id.setSelectionColor(Color.GREEN);
        id.setBounds(180,180,100,30);
        
        password.setFont(new Font(null, Font.ITALIC, 15));  //-- Campo de texto 2--
        password.setForeground(Color.GRAY);
        password.setSelectionColor(Color.GREEN);
        password.setBounds(180,215,100,30);
        
        entrar.setBounds(180, 250, 100, 30);
        entrar.addActionListener(new accion());
        
        panel.add(imgUsuario);
        panel.add(id);
        panel.add(password);
        panel.add(entrar);
        panel.add(fondo);
    }

    private void mostrar() {
        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //  -- Accion del boton --
    class accion implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
