/**
 *
 */
package Controller;

import Model.Expediente;
import Model.RegistroProgreso;
import Utilidades.Formatos;
import Utilidades.Validaciones;
import View.SeguirTramite;
import View.View;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

public class ControladorSeguir extends Controller {

    private SeguirTramite seguir;

    @Override
    public void conectarVista(View v) {
        this.seguir = (SeguirTramite) v;
        seguir.conectarControlador(this);
    }

    @Override
    public void correr(ControladorPrincipal p) {
        super.correr(p);
        seguir.mostrar();
    }

    public void manejarBuscar(String id) {
        if (!Validaciones.validarEntero(id)) {
            seguir.mandarMensaje("Id de expediente inválido");
            return;
        }
        cargarTabla(Integer.parseInt(id));
    }
    
    public void manejarRegistrar(String idExpediente,String titulo, String descripcion){
        boolean valido = true;
        int idEx = 0;
        if(!Validaciones.validarEntero(idExpediente)){
            valido = false;
            seguir.mandarMensaje("El numero de expediente es un entero positivo");
        }
        idEx = Integer.parseInt(idExpediente);
        if(Expediente.buscarPorId(idEx) == null){
            seguir.mandarMensaje("Error recuperando expediente, es posible que no exista, verifique el numero de expediente");
        }
        if(Validaciones.haySoloEspacios(titulo)){
            valido = false;
            seguir.mandarMensaje("El título es obligatorio");
        }
        if(Validaciones.haySoloEspacios(descripcion)){
            valido = false;
            seguir.mandarMensaje("La descripcion es obligatoria");
        }
        RegistroProgreso reg = new RegistroProgreso(idEx,titulo, descripcion, new Date());
        
        if(RegistroProgreso.registrar(reg)){
            seguir.mandarMensaje("Registro exitoso");
            cargarTabla(reg.getIdExpediente());
        }
        else{
            seguir.mandarMensaje("Fallo en el registro");
        }
    }
    
    private void cargarTabla(int id){
        try {
            File arch = new File("tabla.html");
            String ruta = arch.getCanonicalPath();
            FileWriter temp = new FileWriter(ruta);
            String html = "<table>";
            ArrayList<RegistroProgreso> exp = RegistroProgreso.buscarPorExpediente(id);
            for (int i = 0, count = exp.size(); i < count; i++) {
                html += "<table border = '1px' >";
                html += "<tr><td>Fecha: " + Formatos.toDateTimeMysql(exp.get(i).getFecha()) + "</td></tr>";
                html += "<tr><td>Titulo: " + exp.get(i).getTitulo() + "</td></tr>";
                html += "<tr><td>Descripcion: " + exp.get(i).getDescripcion() + "</td></tr>";
                html += "</table>";
            }
            temp.write(html);
            temp.close();
            System.out.println(ruta);
            seguir.refrescarHtml(ruta);
        } catch (Exception ex) {
            System.out.println("Error consultando registros");
        }
    }
}
