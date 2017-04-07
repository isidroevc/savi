package Model;

import Controller.ControladorDB;
import Utilidades.Formatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Representante extends Persona{
    private int tramitesEnCurso;
    // - Constructores
    
    //Constructoor en blanco
    public Representante(){
        
    }
    
    public Representante(int id, String nombres, String apellidoP, 
        String apellidoM, long telefono, long celular, String direccion,
        Date fechaNacimiento, int tramites ){
        super(nombres,apellidoP,apellidoM,celular,celular,direccion,fechaNacimiento);
        this.tramitesEnCurso = tramites;
    }
    
    public Representante(String nombre, String apellidoP, 
        String apellidoM, long telefono, long celular, String direccion,Date fechaNacimiento){
        super(nombre,apellidoP,apellidoM,celular,celular,direccion,fechaNacimiento);
    }
    
    public int getTramitesEnCurso() {
        return tramitesEnCurso;
    }

    public void setTramitesEnCurso(int tramitesEncurso) {
        this.tramitesEnCurso = tramitesEncurso;
    }
    
    // -Metodos de bases de datos.
    public static Representante buscarPorId(int id){
        try{
             Connection conexion = ControladorDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(
                                          "SELECT * FROM Representante WHERE id = ?");
             ResultSet resultados;
             consulta.setInt(1, id);
             
             resultados = consulta.executeQuery();
             
             if(resultados.next()){
                consulta.close();
                conexion.close();
                 return new Representante(id,
                                   resultados.getString("nombres"),
                                   resultados.getString("apellidoP"),
                                   resultados.getString("apellidoM"),
                                   resultados.getLong("telefono"),
                                   resultados.getLong("celular"),
                                   resultados.getString("direccion"),
                                   Formatos.toDate(resultados.getString("fechaNacimiento")),
                                   Integer.parseInt(resultados.getString("tramitesEnCurso"))
                                   );
             }else{
                 return null;
             }
         }catch(Exception ex){
             //TODO: Controlar exceptiones
             System.out.println(ex.getMessage());
             return null;
         }
    }
    public static boolean registrar(Representante r){
        try{
             Connection conexion = ControladorDB.getConexion();
             ResultSet llaves;
             PreparedStatement consulta = conexion.prepareStatement(
             "INSERT INTO Representante (nombres,apellidoP,apellidoM,telefono,celular,direccion,fechaNacimiento,tramitesEncurso)"
             +" VALUES(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
             
             consulta.setString(1, r.getNombres());
             consulta.setString(2, r.getApellidoP());
             consulta.setString(3, r.getApellidoM());
             consulta.setLong(4, r.getTelefono());
             consulta.setLong(5, r.getTelefono());
             consulta.setString(6, r.getDireccion());
             consulta.setString(7,Formatos.toDateMysql(r.getFechaNacimiento()));
             consulta.setInt(8, 1);
             consulta.executeUpdate();
             llaves = consulta.getGeneratedKeys();
             if(llaves.next())
                r.setId(llaves.getInt(1));
             llaves.close();
             consulta.close();
             conexion.close();
             return true;
             
         }catch(Exception ex){
             //TODO: Controlar exceptiones
             System.out.println(ex.getMessage());
             return false;
         }
    }
}
