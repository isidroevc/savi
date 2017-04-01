package Model;

import Controller.ControladorDB;
import java.io.File;
import Utilidades.Formatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Agente extends Persona {
    // -Atributos
    private Date fechaIngreso;
    private float salario;
    private String password;
    
    //Constructores
    public Agente(){
        
    }
    
    public Agente(int id,String nombre, String apellidoP, String apellidoM, 
            long telefono, long celular, String direccion,Date fechaIngreso, 
            Date fechaNacimiento,float salario,String password ){
        super(nombre,apellidoP,apellidoM,telefono,celular,direccion,fechaNacimiento);
        this.id = id;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
        this.password = password;
        }
    
    
    public void setFechaIngreso(Date fechaIngreso){
        this.fechaIngreso=fechaIngreso;
    }
    public Date getFechaIngreso(){
        return fechaIngreso;
    }
    
    
    public void setFechaNacimiento(Date fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
    }
    public Date getFechaNacimiento(){
        return fechaNacimiento;
    }

    
    public void setSalario(float salario) {
        this.salario = salario;
    }
     public float getSalario() {
        return salario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     // -Métodos varios
     
     @Override
     public String toString(){
         return   "id: " + Integer.toString(this.id) 
                  + super.toString()
                  + "\nfechaIngreso: " + Formatos.toDateMysql(this.fechaIngreso)
                  + "\nsalario: " + Float.toString(this.salario);
     }
    //-Métodos estáticos 
     
     //Método para buscar un agente por su id
     
     public static Agente buscarPorId(int id){
         try{
             Connection conexion = ControladorDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(
                                          "SELECT * FROM Agente WHERE id = ?");
             ResultSet resultados;
             consulta.setInt(1, id);
             
             resultados = consulta.executeQuery();
             
             if(resultados.next()){
                 return new Agente(id,
                                   resultados.getString("nombres"),
                                   resultados.getString("apellidoP"),
                                   resultados.getString("apellidoM"),
                                   resultados.getLong("telefono"),
                                   resultados.getLong("celular"),
                                   resultados.getString("direccion"),
                                   Formatos.toDate(resultados.getString("fechaIngreso")),
                                   Formatos.toDate(resultados.getString("fechaNacimiento")),
                                   resultados.getFloat("salario"),
                                   resultados.getString("password"));
             }else{
                 return null;
             }
         }catch(Exception ex){
             //TODO: Controlar exceptiones
             return null;
         }
     }
}
