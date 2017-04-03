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
    public void correr() {
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
            acreedor = new Acreedor(nombres,paterno,materno,
                    Long.parseLong(telefono),Long.parseLong(celular),
                    direccion,
                    Calendar.getInstance().getTime(),Formatos.toDate(nacimiento));
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
        nuevoTramite.irADocumentos();
        boolean valido = true;
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
                nuevoTramite.irADocumentos();
            }
        }else if(activo == 1){
            representante = new Representante(acreedor.getNombres(),
                                              acreedor.getApellidoP(),
                                              acreedor.getApellidoM(),
                                              acreedor.getTelefono(),
                                              acreedor.getCelular(),
                                              acreedor.getDireccion(),
                                              acreedor.getFechaNacimiento());
            nuevoTramite.irADocumentos();
        }else{
            if(!cargados){
                nuevoTramite.mandarMensaje("No ha seleccionado un id valido para el representante");
                
            }
            
        }
    }
    public void manejarFinalizar(boolean estados[] ){
        boolean continuar= true;
        for(int i = 0; i < estados.length; i++){
            if(!estados[i])
            {
                continuar = false;
                break;
            }
        }
        if(!continuar){
            nuevoTramite.mandarMensaje("Se deben entregar todos los documentos");
        }else{
            //Proceder al registro
            boolean registrado = true;
            if(!Representante.registrar(representante)){
                nuevoTramite.mandarMensaje("Error registrando representante");
                registrado = false;
            }
            acreedor.setIdRepresentante(representante.getId());
            if(!Acreedor.registrar(acreedor)){
                nuevoTramite.mandarMensaje("Error registrando Acreedor");
                registrado = false;
            }
            if(Expediente.registrar(expediente)){
                nuevoTramite.mandarMensaje("Error creando expediente");
                registrado = false;
            }
            nuevoTramite.mandarMensaje("Expediente abierto, datos registrados correctamente");
        }
    }
}
