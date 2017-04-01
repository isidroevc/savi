
package Data.Test;

import Model.Acreedor;


public class AcreedorTest {


    public static void main(String[] args) {
        Acreedor acreedor = Acreedor.buscarPorId(4);
        System.out.println(acreedor.getNombres());
    }
    
}
