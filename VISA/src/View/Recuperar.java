package View;

import Controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.embed.swing.JFXPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Recuperar extends View{
    private JPanel panel;
    private JLabel fondo;
    private JLabel etiquetaNom;
    private JTextField campo1;
    private JButton buscar;
    private JFXPanel campo2;
    private JButton salir; 
    private String path="src/Imagenes/";
    

    @Override
    public void conectarControlador(Controller c) {     //Le falta el controlador 
        
    }

    @Override
    protected void crear() {
        panel =         new JPanel();
        fondo =         new JLabel();
        etiquetaNom =   new JLabel("Nombre");
        campo2 =        new JFXPanel();
        campo1 =        new JTextField();
        buscar =        new JButton();
        salir =         new JButton();
    }

    @Override
    protected void armar() {
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                
        //Primera parte 
        panel.setLayout(null);
        
        fondo.setIcon(new ImageIcon(path+"AQUI VA EL NOMBRE"));  // Falta el fondo 
        fondo.setBounds(0, 0, 700, 500);
        
        etiquetaNom.setBounds(5, 10, 90, 30);
        etiquetaNom.setFont(new Font("Verdana",2,15));
        etiquetaNom.setForeground(Color.black);
        
        campo1.setBounds(100, 10, 110, 30);
        campo1.setFont(new Font("Arial",3,15));
        campo1.setForeground(Color.gray);
        
        buscar.setBounds(220, 10, 100, 30);
        buscar.setFont(new Font("Verdana",1,15));
        buscar.addActionListener(new accion());
        
        //Segunda parte 
        campo2.setBounds(10, 20, 500, 300);
        
        salir.setBounds(580,420 , 100, 30);
        salir.setFont(new Font("Verdana",1,15));
        salir.addActionListener(new accion());
        
        panel.add(campo1);
        panel.add(etiquetaNom);
        panel.add(buscar);
        panel.add(salir);
        panel.add(campo2);
        panel.add(fondo);
    }
    
    public class accion implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
}
