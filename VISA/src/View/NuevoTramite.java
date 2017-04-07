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

import Controller.ControladorNuevoTramite;
import Controller.Controller;
import Model.Representante;
import Utilidades.Formatos;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NuevoTramite extends View {

    // -Atributos
    private int activo = 0;
    private static String[] documentos = {"Acta de nacimiento",
        "Pasaporte Válido",
        "Identificacion",
        "Comprobante de estudios",
        "Visas anteriores"};

    private JPanel panelA,
            panelB;
    private JRadioButton nuevoRep, repAcreedor, yaRegistrado;
    private ButtonGroup grupoRep, grupoDocumentos;
    private JLabel aNom,
            aApellidoP,
            aApellidoM,
            aDireccion,
            aTelefono,
            aCelular,
            aFechaN,
            bNom,
            bApellidoP,
            bApellidoM,
            bDireccion,
            bTelefono,
            bCelular,
            bFechaN,
            fondo, labelIdRep;

    private JTextField aNom1,
            aApellidoP1,
            aApellidoM1,
            aDireccion1,
            aTelefono1,
            aCelular1,
            aFechaN1,
            bNom1,
            bApellidoP1,
            bApellidoM1,
            bDireccion1,
            bTelefono1,
            bCelular1,
            bFechaN1,
            idRepresentante;
    JButton siguiente,
            anterior, anterior2, siguiente2, inalizar, buscar;

    private ControladorNuevoTramite controlador;
    private String path = "src/Imagenes/";

    // -Métodos Constructores
    //Constructor sin parámetros
    public NuevoTramite() {
        crear();
        armar();
        mostrar();
    }

    // -Métodos específicos de funcionamiento
    @Override
    public void conectarControlador(Controller c) {
        this.controlador = (ControladorNuevoTramite) c;
    }

    @Override
    protected void crear() {
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
        labelIdRep = new JLabel("Id");

        aNom1 = new JTextField();
        aApellidoP1 = new JTextField();
        aApellidoM1 = new JTextField();
        aDireccion1 = new JTextField();
        aTelefono1 = new JTextField();
        aCelular1 = new JTextField();
        aFechaN1 = new JTextField();

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
        idRepresentante = new JTextField();

        fondo = new JLabel();
        siguiente = new JButton("siguiente");
        anterior = new JButton("anterior");
        siguiente2 = new JButton("siguiente");
        anterior2 = new JButton("anterior");
        buscar = new JButton("Buscar");

        repAcreedor = new JRadioButton("Sin representante");
        yaRegistrado = new JRadioButton("Representante ya regstrado");
        nuevoRep = new JRadioButton("Nuevo representante");

        grupoRep = new ButtonGroup();
    }

    @Override
    protected void armar() {
        super.armar();
        this.setTitle("Nuevo tramite");
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                controlador.manejarCerrar();
                
            }
        });
        //Apartir de aqui es lo que hice yo 
        panelA.setLayout(null);
        panelB.setLayout(null);

        fondo.setIcon(new ImageIcon(path + "Nombre de la imagen"));   //Fondo del menu
        fondo.setBounds(0, 0, 1000, 1000);

        //Elementos del primer panel pertenecientes al Acreedor
        aNom.setBounds(10, 10, 90, 30);
        aNom.setFont(new Font("Arial", 1, 15));
        aNom1.setBounds(110, 10, 200, 30);

        aApellidoP.setBounds(10, 50, 120, 30);
        aApellidoP.setFont(new Font("Arial", 1, 15));
        aApellidoP1.setBounds(140, 50, 200, 30);

        aApellidoM.setBounds(10, 90, 120, 30);
        aApellidoM.setFont(new Font("Arial", 1, 15));
        aApellidoM1.setBounds(140, 90, 200, 30);

        aDireccion.setBounds(10, 130, 90, 30);
        aDireccion.setFont(new Font("Arial", 1, 15));
        aDireccion1.setBounds(110, 130, 200, 30);

        aTelefono.setBounds(10, 170, 150, 30);
        aTelefono.setFont(new Font("Arial", 1, 15));
        aTelefono1.setBounds(170, 170, 200, 30);

        aCelular.setBounds(10, 210, 150, 30);
        aCelular.setFont(new Font("Arial", 1, 15));
        aCelular1.setBounds(170, 210, 200, 30);

        aFechaN.setBounds(10, 250, 150, 30);
        aFechaN.setFont(new Font("Arial", 1, 15));
        aFechaN1.setBounds(170, 250, 200, 30);

        siguiente.setBounds(370, 400, 100, 30);
        siguiente.addActionListener(new SiguienteClick());

        siguiente2.setBounds(370, 400, 100, 30);
        siguiente2.addActionListener(new SiguienteClick());

        nuevoRep.setBounds(410, 10, 200, 30);
        nuevoRep.addActionListener(new NuevoRepresentanteClick());
        repAcreedor.setBounds(410, 40, 200, 30);
        repAcreedor.addActionListener(new SinRepresentanteClick());

        yaRegistrado.setBounds(410, 70, 200, 30);

        yaRegistrado.addActionListener(new YaRegistradoClick());

        labelIdRep.setBounds(410, 100, 50, 30);
        idRepresentante.setBounds(440, 100, 50, 30);
        buscar.setBounds(490, 100, 100, 30);

        grupoRep.add(nuevoRep);
        grupoRep.add(repAcreedor);
        grupoRep.add(yaRegistrado);

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
        panelA.add(siguiente);

        //Elementos del segundo panel pertenecientes al representante 
        bNom.setBounds(10, 10, 90, 30);
        bNom.setFont(new Font("Arial", 1, 15));
        bNom1.setBounds(110, 10, 200, 30);

        bApellidoP.setBounds(10, 50, 120, 30);
        bApellidoP.setFont(new Font("Arial", 1, 15));
        bApellidoP1.setBounds(140, 50, 200, 30);

        bApellidoM.setBounds(10, 90, 120, 30);
        bApellidoM.setFont(new Font("Arial", 1, 15));
        bApellidoM1.setBounds(140, 90, 200, 30);

        bDireccion.setBounds(10, 130, 90, 30);
        bDireccion.setFont(new Font("Arial", 1, 15));
        bDireccion1.setBounds(110, 130, 200, 30);

        bTelefono.setBounds(10, 170, 150, 30);
        bTelefono.setFont(new Font("Arial", 1, 15));
        bTelefono1.setBounds(170, 170, 200, 30);

        bCelular.setBounds(10, 210, 150, 30);
        bCelular.setFont(new Font("Arial", 1, 15));
        bCelular1.setBounds(170, 210, 200, 30);

        bFechaN.setBounds(10, 250, 150, 30);
        bFechaN.setFont(new Font("Arial", 1, 15));
        bFechaN1.setBounds(170, 250, 200, 30);

        anterior.setBounds(10, 400, 100, 30);
        anterior.addActionListener(new AnteriorClick());

        anterior2.setBounds(10, 400, 100, 30);
        anterior2.addActionListener(new AnteriorClick());

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
        panelB.add(siguiente2);
        panelB.add(yaRegistrado);
        panelB.add(nuevoRep);
        panelB.add(repAcreedor);
        panelB.add(buscar);
        panelB.add(labelIdRep);
        panelB.add(idRepresentante);

        buscar.addActionListener(new BuscarClick());
        nuevoRep.setSelected(true);

        siguiente2.addActionListener(new Siguiente2Click());

        this.irADatosAcreedor();
        setEstadoNuevoRep(true);
    }

    public void irADatosAcreedor() {
        this.setTitle("Nuevo Tramite - Datos del acreedor");
        this.setContentPane(panelA);
        JPanel p = (JPanel) this.getContentPane();
        p.revalidate();
        p.repaint();
    }

    public void irADatosRepresentante() {
        this.setTitle("Nuevo Tramite - Datos del representante");
        this.setContentPane(panelB);
        JPanel p = (JPanel) this.getContentPane();
        p.revalidate();
        p.repaint();
    }

    public void irADocumentos() {
        this.setTitle("Nuevo Tramite - Documentos a entregar");
        this.setContentPane(panelA);
        JPanel p = (JPanel) this.getContentPane();
        p.revalidate();
        p.repaint();
    }

    public void setEstadoNuevoRep(boolean estado) {
        bNom1.setEnabled(estado);
        bApellidoP1.setEnabled(estado);
        bApellidoM1.setEnabled(estado);
        bDireccion1.setEnabled(estado);
        bTelefono1.setEnabled(estado);
        bCelular1.setEditable(estado);
        bFechaN1.setEnabled(estado);

        bNom.setEnabled(estado);
        bApellidoP.setEnabled(estado);
        bApellidoM.setEnabled(estado);
        bDireccion.setEnabled(estado);
        bTelefono.setEnabled(estado);
        bCelular.setEnabled(estado);
        bFechaN.setEnabled(estado);
        if (activo == 2) {
            setEstadoYaRegistrado(false);
        }
        activo = 0;
    }

    public void setEstadoYaRegistrado(boolean estado) {
        labelIdRep.setEnabled(estado);
        buscar.setEnabled(estado);
        idRepresentante.setEnabled(estado);
        if (activo == 0) {
            setEstadoNuevoRep(false);
        }

        activo = 2;
    }

    public void setEstadoSinRepresentante(boolean estado) {
        if (activo == 2) {
            setEstadoYaRegistrado(false);
        } else {
            setEstadoNuevoRep(false);
        }
    }

    public void llenarDatos(Representante rep) {
        bNom1.setText(rep.getNombres());
        bApellidoP1.setText(rep.getApellidoP());
        bApellidoM1.setText(rep.getApellidoM());
        bDireccion1.setText(rep.getDireccion());
        bTelefono1.setText(Long.toString(rep.getTelefono()));
        bCelular1.setText(Long.toString(rep.getCelular()));
        bFechaN1.setText(Formatos.toDateMysql(rep.getFechaNacimiento()));
    }

    public class SiguienteClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlador.manejarSiguienteAcreedor(aNom1.getText(), aApellidoP1.getText(),
                    aApellidoM1.getText(),
                    aDireccion1.getText(), aTelefono1.getText(),
                    aCelular1.getText(), aFechaN1.getText());
        }
    }

    public class AnteriorClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlador.manejarAnteriorRepresentante();
        }
    }

    public class NuevoRepresentanteClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton r = (JRadioButton) e.getSource();
            controlador.manejarRadio(0, r.isSelected());
        }
    }

    public class YaRegistradoClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton r = (JRadioButton) e.getSource();
            controlador.manejarRadio(1, r.isSelected());
        }
    }

    public class SinRepresentanteClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton r = (JRadioButton) e.getSource();
            controlador.manejarRadio(2, r.isSelected());
        }
    }

    public class BuscarClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlador.manejarBuscar(idRepresentante.getText());
        }
    }

    public class Siguiente2Click implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlador.manejarRepresentanteSiguiente(activo, bNom1.getText(), bApellidoP1.getText(),
                    bApellidoM1.getText(),
                    bDireccion1.getText(), bTelefono1.getText(),
                    bCelular1.getText(), bFechaN1.getText());
        }
    }
}
