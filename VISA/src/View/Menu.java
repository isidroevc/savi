package View;

import Controller.Controller;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Menu extends View{
    
    private JPanel panel;
    private JLabel fondo;
    private JButton nuevo,
                    seguir,
                    salir;
    
    private String path="src/Imagenes/";

    @Override
    public void conectarControlador(Controller c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Menu(){
        crear();
        armar();
    }

    @Override
    protected void crear() {
        panel = new JPanel();
        fondo = new JLabel();
        nuevo = new JButton("Nuevo");
        seguir = new JButton("seguir");
        salir = new JButton("Salir");
    }
    
    protected void armar(){
      this.setTitle(null); //  -- Falta el titulo --
      this.setSize(500,500);
      this.setLocationRelativeTo(null);
      
      
      panel.setLayout(null);
            
      fondo.setIcon(new ImageIcon(path+"")); //-- Falta un fondo --
      fondo.setBounds(0, 0, 700, 500);
      
      nuevo.setBounds(20, 400, 100, 30);
      nuevo.setFont(new Font("Arial",0,15));
      nuevo.addActionListener(new Nuevo());
      
      seguir.setBounds(200, 400, 100, 30);
      seguir.setFont(new Font("Arial",0,15));
      seguir.addActionListener(new Seguir());
      
      salir.setBounds(380, 400, 100, 30);
      salir.setFont(new Font("Arial",0,15));
      salir.addActionListener(new Salir());
      
      panel.add(fondo);
      panel.add(nuevo);
      panel.add(seguir);
      panel.add(salir);
    }
    
    //Accion de los botones
    
    class Nuevo implements ActionListener{  //Boton para nuevo tramite
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    class Seguir implements ActionListener{ //Boton para seguir tramite
        @Override
        public void actionPerformed(ActionEvent e){
        
        }
    }
    
    class Salir implements ActionListener{  //Boton para salir
        @Override
        public void actionPerformed(ActionEvent e){
        
        }
    }
    
    
}
