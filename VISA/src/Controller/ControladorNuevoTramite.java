/**
 * ControladorNuevoTramite.java
 *
 * Este codigo corresponde al controlador para la vista de nuevo tramite
 *
 * ITL-POO
 *
 * Vàsquez Cortès Isidro Emanuel
 */
package Controller;

import Model.Acreedor;
import Model.Agente;
import Model.Expediente;
import Model.Representante;
import Utilidades.Formatos;
import Utilidades.Validaciones;
import View.NuevoTramite;
import View.View;
import java.util.Calendar;
import java.util.Date;

public class ControladorNuevoTramite extends Controller {
    // -Atributos

    private NuevoTramite nuevoTramite;
    private Acreedor acreedor;
    private Representante representante;
    private Expediente expediente;
    private boolean cargados;

    // -Constructores
    public ControladorNuevoTramite() {
        // -Metodos específicos de funcionamiento
    }

    @Override
    public void conectarVista(View v) {
        this.nuevoTramite = (NuevoTramite) v;
        this.nuevoTramite.conectarControlador(this);
    }

    @Override
    public void correr(ControladorPrincipal p) {
        super.correr(p);
        nuevoTramite.mostrar();
    }

    public void manejarSiguienteAcreedor(String nombres, String paterno, String materno,
            String direccion, String telefono, String celular,
            String nacimiento) {
        boolean valido = true;
        if (!Validaciones.validarNombres(nombres)) {
            nuevoTramite.mandarMensaje("El nombre es un campo obligatorio y debe contener solo letras");
            valido = false;
        }
        if (!Validaciones.validarNombres(paterno)) {
            nuevoTramite.mandarMensaje("El Apellido paterno es un campo obligatorio y debe contener solo letras");
            valido = false;
        }
        if (!Validaciones.validarNombres(materno)) {
            nuevoTramite.mandarMensaje("El Apellido materno es un campo obligatorio y debe contener sólo letras");
            valido = false;
        }
        if (Validaciones.haySoloEspacios(direccion)) {
            nuevoTramite.mandarMensaje("La direccion es un campo obligatorio");
            valido = false;
        }
        if (!Validaciones.validarTelefono(telefono)) {
            nuevoTramite.mandarMensaje("El telefono es un campo obligatorio y debe contener sólo numeros, incluir el LADA");
            valido = false;
        }
        if (!Validaciones.validarTelefono(celular)) {
            nuevoTramite.mandarMensaje("El telefono es un campo obligatorio y debe contener sólo numeros, incluir el LADA");
            valido = false;
        }
        if (!Validaciones.validarFecha(nacimiento)) {
            nuevoTramite.mandarMensaje("La fecha de nacimiento es obligatoria y debe tener el formato año-mes-dia (yyyy-MM-dd)");
            valido = false;
        } else {
            Date f = Formatos.toDate(nacimiento);
            Date hoy = Calendar.getInstance().getTime();
            if (f.getTime() > hoy.getTime()) {
                nuevoTramite.mandarMensaje("Fecha de nacimiento inválida ¿El acreedor nació en el futuro?");
                valido = false;
            }
        }
        if (valido) {
            acreedor = new Acreedor(nombres, paterno, materno,
                    Long.parseLong(telefono), Long.parseLong(celular),
                    direccion,
                    Calendar.getInstance().getTime(), Formatos.toDate(nacimiento));
            nuevoTramite.irADatosRepresentante();
        }

    }

    public void manejarAnteriorRepresentante() {
        nuevoTramite.irADatosAcreedor();
    }

    public void manejarRadio(int opcion, boolean estado) {
        switch (opcion) {
            case 0:
                nuevoTramite.setEstadoNuevoRep(estado);

                break;
            case 1:
                if (estado) {
                    nuevoTramite.setEstadoYaRegistrado(estado);
                }
                break;
            case 2:
                if (estado) {
                    nuevoTramite.setEstadoSinRepresentante(estado);
                }

                break;
        }
    }

    public void manejarBuscar(String id) {
        if (!Validaciones.validarEntero(id)) {
            nuevoTramite.mandarMensaje("El id debe ser sólo numeros");
            return;

        }
        representante = Representante.buscarPorId(Integer.parseInt(id));
        nuevoTramite.llenarDatos(representante);
        cargados = true;
    }

    public void manejarRepresentanteSiguiente(int activo, String nombres, String paterno, String materno,
            String direccion, String telefono, String celular,
            String nacimiento) {
        boolean valido = true, finalizar = false;
        if (activo == 0) {
            if (!Validaciones.validarNombres(nombres)) {
                nuevoTramite.mandarMensaje("El nombre es un campo obligatorio y debe contener solo letras");
                valido = false;
            }
            if (!Validaciones.validarNombres(paterno)) {
                nuevoTramite.mandarMensaje("El Apellido paterno es un campo obligatorio y debe contener solo letras");
                valido = false;
            }
            if (!Validaciones.validarNombres(materno)) {
                nuevoTramite.mandarMensaje("El Apellido materno es un campo obligatorio y debe contener sólo letras");
                valido = false;
            }
            if (Validaciones.haySoloEspacios(direccion)) {
                nuevoTramite.mandarMensaje("La direccion es un campo obligatorio");
                valido = false;
            }
            if (!Validaciones.validarTelefono(telefono)) {
                nuevoTramite.mandarMensaje("El telefono es un campo obligatorio y debe contener sólo numeros, incluir el LADA");
                valido = false;
            }
            if (!Validaciones.validarTelefono(celular)) {
                nuevoTramite.mandarMensaje("El telefono es un campo obligatorio y debe contener sólo numeros, incluir el LADA");
                valido = false;
            }
            if (!Validaciones.validarFecha(nacimiento)) {
                nuevoTramite.mandarMensaje("La fecha de nacimiento es obligatoria y debe tener el formato año-mes-dia (yyyy-MM-dd)");
                valido = false;
            } else {
                Date f = Formatos.toDate(nacimiento);
                Date hoy = Calendar.getInstance().getTime();
                if (f.getTime() > hoy.getTime()) {
                    nuevoTramite.mandarMensaje("Fecha de nacimiento inválida ¿El representante nació en el futuro?");
                    valido = false;
                }
            }
            if (valido) {
                acreedor = new Acreedor(nombres, paterno, materno,
                        Long.parseLong(telefono), Long.parseLong(celular),
                        direccion,
                        Calendar.getInstance().getTime(), Formatos.toDate(nacimiento));
                System.out.println(acreedor.toString());
                finalizar = true;
            }
        } else if (activo == 1) {
            representante = new Representante(acreedor.getNombres(),
                    acreedor.getApellidoP(),
                    acreedor.getApellidoM(),
                    acreedor.getTelefono(),
                    acreedor.getCelular(),
                    acreedor.getDireccion(),
                    acreedor.getFechaNacimiento());
            finalizar = true;
        } else {
            if (!cargados) {
                nuevoTramite.mandarMensaje("No ha seleccionado un id valido para el representante");

            }

        }
        if(finalizar){
            finalizarTramite();
        }
    }

    public void finalizarTramite() {
        boolean registrado = true;
        Agente a;
        if (!Representante.registrar(representante)) {
            registrado = false;
            nuevoTramite.mandarMensaje("Error registrando Representante");
        }
        acreedor.setIdRepresentante(representante.getId());
        if (!Acreedor.registrar(acreedor)) {
            nuevoTramite.mandarMensaje("Error registrando Acreedor");
            registrado = false;
        }
        expediente = new Expediente();
        expediente.setFechaInicio(new Date());
        expediente.setIdAcreedor(acreedor.getId());
        expediente.setIdAgente(p.getAgente().getId());
        expediente.setFinalizado(false);
        if (!Expediente.registrar(expediente)) {
            nuevoTramite.mandarMensaje("Error creando expediente");
            registrado = false;
        }
        a = p.getAgente();
        nuevoTramite.mandarMensaje(("Expediente abierto, datos registrados correctamente"
        + "\nDatos de expediente: \n" + expediente.toString() + "\n Datos acreedor: " + acreedor.toString()
        + "\nDatos del representante: " + expediente.toString() + "\n El trámite será asistido por: "
        + a.getNombres() + " " + a.getApellidoP() + " " + a.getApellidoM()).toUpperCase() );
        p.manejarTramiteFinalizado();
    }
    
    public void manejarCerrar(){
        p.manejarNuevoTramiteCerrado();
    }
    
    public void cerrar(){
        nuevoTramite.setVisible(false);
        nuevoTramite.dispose();
    }
}
