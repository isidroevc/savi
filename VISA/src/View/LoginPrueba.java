// -- Prueba del Login --

package View;

import Model.Acreedor;
import java.util.Date;

public class LoginPrueba {

    public static void main(String[] args) {
        //Login correr= new Login();
           Acreedor a  = new Acreedor();
           a.setNombres("Registrado");
           a.setApellidoP("sigu");
           a.setApellidoM("nada");
           a.setDireccion("Nada");
           a.setTelefono(446546);
           a.setCelular(5564564);
           a.setFechaNacimiento(new Date());
           Acreedor.registrar(a);
           System.out.println(a.toString());
        }
    
}
