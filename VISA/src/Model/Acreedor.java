package Model;

import Controller.ControladorDB;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Utilidades.Formatos;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
public class Acreedor extends Persona{
    private int idRepresentante;
    private Date fechaAlta;
    //Constructores 
    public Acreedor(int id, int idRepresentante,String nombre, String apellidoP, 
        String apellidoM, long telefono, long celular, String direccion,
        Date fechaAlta,Date fechaNacimiento){
        super(nombre,apellidoP,apellidoM,celular,celular,direccion,fechaNacimiento);
        this.id = id;
        this.idRepresentante = idRepresentante;
        this.fechaAlta = fechaAlta;
    }
    public Acreedor(){
        
    }
    public Acreedor(String nombre, String apellidoP, 
        String apellidoM, long telefono, long celular, String direccion,
        Date fechaAlta,Date fechaNacimiento){
        super(nombre,apellidoP,apellidoM,celular,celular,direccion,fechaNacimiento);
        this.fechaAlta = fechaAlta;
    }
    
    public void setIdRepresentante(int idRepresentante){
        this.idRepresentante=idRepresentante;
    }
    public int getIdRepresentante(){
        return idRepresentante;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }
    

    @Override
    public String toString(){
        return  "id: " + this.id + "\nidRepresentante: \n" + super.toString()
                +"\nfechaAlta: " + Formatos.toDateMysql(fechaAlta);
    }
    //Métodos estáticos de lectura de datos.
    
    public static Acreedor buscarPorId(int id){
        try{
             Connection conexion = ControladorDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(
                                          "SELECT * FROM Acreedor WHERE id = ?");
             ResultSet resultados;
             consulta.setInt(1, id);
             
             resultados = consulta.executeQuery();
             
             if(resultados.next()){
                 
                consulta.close();
                conexion.close();
                 return new Acreedor (id,
                                   resultados.getInt("idRepresentante"),
                                   resultados.getString("nombres"),
                                   resultados.getString("apellidoP"),
                                   resultados.getString("apellidoM"),
                                   resultados.getLong("telefono"),
                                   resultados.getLong("celular"),
                                   resultados.getString("direccion"),
                                   Formatos.toDate(resultados.getString("fechaNacimiento")),
                                   Formatos.toDate(resultados.getString("fechaAlta"))
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
    public static boolean registrar(Acreedor r){
        try{
             Connection conexion = ControladorDB.getConexion();
             ResultSet llaves;
             PreparedStatement consulta = conexion.prepareStatement(
             "INSERT INTO Acreedor (nombres,apellidoP,apellidoM,telefono,celular,direccion,fechaNacimiento,fechaAlta,idRepresentante)"
             +" VALUES(?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
             
             consulta.setString(1, r.getNombres());
             consulta.setString(2, r.getApellidoP());
             consulta.setString(3, r.getApellidoM());
             consulta.setLong(4, r.getTelefono());
             consulta.setLong(5, r.getTelefono());
             consulta.setString(6, r.getDireccion());
             consulta.setString(7,Formatos.toDateMysql(r.getFechaNacimiento()));
             r.setFechaAlta(new Date());
             
             consulta.setString(8, Formatos.toDateMysql(r.getFechaAlta()));
             consulta.setInt(9, 1);
             consulta.executeUpdate();
             llaves = consulta.getGeneratedKeys();
             if(llaves.next())
                r.setId(llaves.getInt(1));//le ponemos el id que genero mysql
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
