package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VistaMenu{
    private JFrame ventana;
    private JPanel panel;
    private JLabel fondo;
    private JLabel marco;
    private JButton registro;
    private JButton seguimiento;
    private JButton salir;
    private String path="src/Imagenes/";
    
    public void show(){
        crear();
        armar();
        lanzar();
    }
    
    void crear(){
        ventana =     new JFrame();
        panel =       new JPanel();
        fondo =       new JLabel();
        marco =       new JLabel();
        registro =    new JButton("registro");
        seguimiento = new JButton ("mi registro"); 
        salir =       new JButton("Salir");
    }

    void armar() {
      // este es el frame  
      ventana.setTitle(null); //  -- Falta el titulo --
      ventana.setSize(500,400);
      ventana.setLocationRelativeTo(null);
      ventana.setResizable(false);
      
      panel.setLayout(null);
            
      fondo.setIcon(new ImageIcon(path+"blue.jpg"));
      fondo.setBounds(0, 0, 500, 400);
      
     
      
      registro.setBounds(10, 330, 100, 30);
      registro.addActionListener(new accion());
      
      seguimiento.setBounds(120, 330, 100, 30);
      seguimiento.addActionListener(new accion());
      
      salir.setBounds(230, 330, 100, 30);
      salir.addActionListener(new accion());
      
      panel.add(registro);
      panel.add(seguimiento);
      panel.add(salir);
      panel.add(fondo);
    }
    
    void lanzar(){
        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //  -- Accion de los botones --
    class accion implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
