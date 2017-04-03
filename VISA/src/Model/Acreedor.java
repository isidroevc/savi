package Model;

import Controller.ControladorDB;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Utilidades.Formatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    @Override
    public String toString(){
        return  "id: " + this.id + "\nidRepresentante: \n" + super.toString()
                +"\nfechaAlta: " + Formatos.toDateMysql(fechaAlta);
    }
    //Métodos estáticos de lectura de datos.
    
    public static Acreedor buscarPorId(int id){
       return null;
     } 
    public static boolean registrar(Acreedor r){
        try{
             Connection conexion = ControladorDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(
             "INSERT INTO Representante (nombres,apellidoP,apellidM,telefono,celular,direccion,fechaNacimiento,fechaAlta)"
             +" VALUES(?,?,?,?,?,?,?,?)");
             
             consulta.setString(1, r.getNombres());
             consulta.setString(2, r.getApellidoP());
             consulta.setString(3, r.getApellidoM());
             consulta.setLong(4, r.getTelefono());
             consulta.setLong(5, r.getTelefono());
             consulta.setString(6, r.getDireccion());
             consulta.setString(7,Formatos.toDateMysql(r.getFechaNacimiento()));
             consulta.setString(8, Formatos.toDateMysql(new Date()));
             consulta.executeUpdate();
             
             r.setId(consulta.getGeneratedKeys().getInt("id"));
             return true;
             
         }catch(Exception ex){
             //TODO: Controlar exceptiones
             System.out.println(ex.getMessage());
             return false;
         }
    }
}
