package View;

import Controller.ControladorSeguir;
import Controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SeguirTramite extends View {

    private JPanel panel;
    private JLabel fondo;
    //primera parte 
    private JLabel numExp;
    private JTextField campo1;
    private JButton buscar;
    //segunda parte
    private JTextField titulo;
    private JScrollPane barras;
    private TextArea campo2;
    private JButton registro;
    //tercera parte
    private JFXPanel campo3;
    private JButton seguimiento;
    private JButton salir;

    ControladorSeguir controlador;

    private String path = "src/Imagenes/";

    //private ControladorMenu controlador;
    public SeguirTramite() {
        crear();
        armar();

    }

    @Override
    public void conectarControlador(Controller c) {
        this.controlador = (ControladorSeguir) c;
    }

    @Override
    protected void crear() {
        //las partes del frame son de arriba hacia abajo
        panel = new JPanel();
        fondo = new JLabel();
        //primera parte 
        numExp = new JLabel("Num. expe.");
        campo1 = new JTextField("");
        buscar = new JButton("Buscar");
        //Segunda parte
        titulo = new JTextField("Seguir tramite");
        campo2 = new TextArea();
        registro = new JButton("registro");
        barras = new JScrollPane(campo2);
        //Tercera parte
        campo3 = new JFXPanel();
        seguimiento = new JButton("mi registro");
        salir = new JButton("Salir");
    }

    @Override
    protected void armar() {
        // este es el frame  
        this.setTitle(null); //  -- Falta el titulo --
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        panel.setLayout(null);

        fondo.setIcon(new ImageIcon(path + ""));
        fondo.setBounds(0, 0, 700, 500);

        //primera parte
        numExp.setFont(new Font("Arial", 1, 15));
        numExp.setBounds(0, 10, 100, 30);
        numExp.setForeground(Color.black);

        campo1.setFont(new Font(null, 2, 15)); //-- Campo de texto 1--
        campo1.setSelectionColor(Color.GRAY);
        campo1.setBounds(100, 10, 100, 30);

        buscar.setBounds(210, 10, 100, 30);
        buscar.setFont(new Font("Arial", 0, 15));
        buscar.addActionListener(new BuscarClick());

        //Segunda parte
        titulo.setFont(new Font(null,2, 15)); //-- Campo de texto 1--
        titulo.setSelectionColor(Color.GRAY);
        titulo.setBounds(15,50,150,30);
        barras.setViewportView(campo2);

        campo2.setEditable(true);     //Este es el JTextArea
        campo2.setBounds(10, 100, 500, 100);
        //campo2.setLineWrap(true);         // Para que haga el salto de línea en cualquier parte de la palabra
        //campo2.setWrapStyleWord(true);    // Para que haga el salto de línea buscando espacios entre las palabras

        registro.setBounds(10, 265, 100, 30);
        registro.setFont(new Font("Arial", 1, 15));
        registro.addActionListener(new RegistrarClick());

        //Tercera parte
        //campo3 es el  JFXPanel no se ocomo va 
        campo3.setBounds(10, 310, 500, 200);

        seguimiento.setBounds(10, 520, 100, 30);
        seguimiento.addActionListener(new BuscarClick());

        salir.setBounds(590, 520, 100, 30);
        salir.setFont(new Font("Arial", 1, 15));
        salir.setForeground(Color.black);
        salir.addActionListener(new SalirClick());

        panel.add(numExp);
        panel.add(campo1);
        panel.add(buscar);
        panel.add(titulo);
        panel.add(campo2);
        panel.add(registro);
        panel.add(campo3);
        //panel.add(seguimiento);
        panel.add(salir);
        panel.add(fondo);
        this.setContentPane(panel);
    }

    public void refrescarHtml(String ruta) {
        Platform.runLater(() -> {
            WebView webView = new WebView();
            campo3.setScene(new Scene(webView));
            webView.getEngine().load("file:///" + ruta);
        });
    }

    //  -- Accion de los botones --
    class BuscarClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlador.manejarBuscar(campo1.getText());
        }
    }

    class RegistrarClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlador.manejarRegistrar(campo1.getText(),titulo.getText(),campo2.getText());
        }
    }

    class SalirClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlador.manejarSalir();
        }
    }

}
