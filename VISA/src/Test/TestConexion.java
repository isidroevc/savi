
package Test;

import java.sql.Connection;
import Controller.ControladorDB;
import Model.Agente;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConexion {

    public static void main(String[] args) {
        System.out.println(Agente.buscarPorId(1).toString());
    }
    
}
