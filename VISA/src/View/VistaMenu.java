package View;


import Controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VistaMenu extends View{
    
    private JPanel panel;
    private JLabel fondo;
    private JLabel marco;
    private JButton registro;
    private JButton seguimiento;
    private JButton salir;
    private String path="src/Imagenes/";
    
    //private ControladorMenu controlador;
    
    public VistaMenu(){
        crear();
        armar();
        
    }
    public void conectarControlador(Controller c){
        //this.controlador = (ControladorMenu)c;
    }
        
    @Override
    protected void crear(){
        panel =       new JPanel();
        fondo =       new JLabel();
        marco =       new JLabel();
        registro =    new JButton("registro");
        seguimiento = new JButton ("mi registro"); 
        salir =       new JButton("Salir");
    }

    @Override
    protected void armar() {
      // este es el frame  
      this.setTitle(null); //  -- Falta el titulo --
      this.setSize(500,400);
      this.setLocationRelativeTo(null);
      this.setResizable(false);
      
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
    
    
    
    //  -- Accion de los botones --
    class accion implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
