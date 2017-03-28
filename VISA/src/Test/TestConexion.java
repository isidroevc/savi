
package Test;

import java.sql.Connection;
import Controller.DatabaseController;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConexion {

    public static void main(String[] args) {
        Connection conn = DatabaseController.getConexion();
        try{
            //De aqui vamos a empezar el ejemplo de seleccion
            Statement consulta = conn.createStatement();
            ResultSet resultados = consulta.executeQuery("SELECT * FROM agente");
            while(resultados.next()){
                System.out.println("=========================================");
                System.out.println("nombre: " + resultados.getString("Nombre"));
                System.out.println("Paterno: " + resultados.getString("apellidoP"));
                System.out.println("Materno: " + resultados.getString("apellidoM"));
            }
            consulta.close();
            resultados.close();
        }catch(Exception ex){
            
        }
    }
    
}
