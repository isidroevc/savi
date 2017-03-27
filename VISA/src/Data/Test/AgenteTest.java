
package Data.Test;

import Model.Agente;
import java.text.SimpleDateFormat;

public class AgenteTest {


    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Agente a = Agente.buscarAgente(4);
        System.out.println(format.format(a.getFechaNacimiento()));
    }
    
}
