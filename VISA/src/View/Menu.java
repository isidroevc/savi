package View;

import Controller.ControladorMenu;
import Controller.Controller;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Menu extends View{
    
    private ControladorMenu controlador;
    private JPanel panel;
    private JLabel fondo;
    private JButton nuevo,
                    seguir,
                    salir;
    
    private String path="src/Imagenes/";

    @Override
    public void conectarControlador(Controller c) {
        this.controlador = (ControladorMenu)c;
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
      nuevo.addActionListener(new NuevoClick());
      
      seguir.setBounds(200, 400, 100, 30);
      seguir.setFont(new Font("Arial",0,15));
      seguir.addActionListener(new SeguirClick());
      
      salir.setBounds(380, 400, 100, 30);
      salir.setFont(new Font("Arial",0,15));
      salir.addActionListener(new SalirClick());
      
      panel.add(fondo);
      panel.add(nuevo);
      panel.add(seguir);
      panel.add(salir);
      this.setContentPane(panel);
    }
    
    //Accion de los botones
    
    class NuevoClick implements ActionListener{  //Boton para nuevo tramite
        
        @Override
        public void actionPerformed(ActionEvent e) {
            controlador.manejarNuevo();
        }
    }
    
    class SeguirClick implements ActionListener{ //Boton para seguir tramite
        @Override
        public void actionPerformed(ActionEvent e){
            controlador.manejarSeguir();
        }
    }
    
    class SalirClick implements ActionListener{  //Boton para salir
        @Override
        public void actionPerformed(ActionEvent e){
           controlador.manejarSalir();
        }
    }
    
    
}
