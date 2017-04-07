// -- Prueba del Login --

package View;

import Model.Acreedor;
import Model.Expediente;
import Model.RegistroProgreso;
import Model.Representante;
import Utilidades.Formatos;
import java.util.Date;

public class LoginPrueba {

    public static void main(String[] args) {
        //Login correr= new Login();
        //Acreedor a = Acreedor.buscarPorId(1);
        //System.out.println(a.toString());
           Acreedor a  = new Acreedor();
           a.setIdRepresentante(2);
           a.setNombres("Registrado");
           a.setApellidoP("sigu");
           a.setApellidoM("nada");
           a.setDireccion("Nada");
           a.setTelefono(446546);
           a.setCelular(5564564);
           a.setFechaNacimiento(new Date());
           System.out.println(Acreedor.registrar(a));
           System.out.println(a.toString());
           //Representante r = Representante.buscarPorId(1);
           //System.out.println(r.toString());
           /*r.setNombres("Cristtobal Colon");
           Representante.registrar(r);
           System.out.println(r.toString() + "  id: " + r.getId());*/
           /*Expediente ex = Expediente.buscarPorId(1);
           System.out.println(ex.toString());*/
           /*RegistroProgreso r = RegistroProgreso.buscarPorId(2);
           System.out.println(r.getDescripcion());*/
           
          /*Menu m = new Menu();
          m.mostrar();*/
        }
    
}
