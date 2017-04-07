package Model;

import Controller.ControladorDB;
import Utilidades.Formatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class RegistroProgreso {
    private int     id,
                    idExpediente;    
                    
    private String  titulo,
                    descripcion;
    
    private Date fecha;
    public RegistroProgreso(int idExpediente, String titulo, String descripcion, Date fecha){
        this.idExpediente = idExpediente;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }
    public int getIdExpediente(){
        return idExpediente;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }
    

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }
    

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getFecha(){
        return fecha;
    }
    
    public static boolean registrar(RegistroProgreso reg){
        boolean registrado = false;
        try{
            Connection conexion = ControladorDB.getConexion();
            ResultSet llaves;
            PreparedStatement consulta = conexion.prepareStatement("INSERT INTO RegistroProgreso "
            + "(idExpediente,titulo,descripcion,fecha) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            
            consulta.setInt(1,  reg.getIdExpediente());
            consulta.setString(2, reg.getTitulo());
            consulta.setString(3, reg.getDescripcion());
            consulta.setString(4, Formatos.toDateTimeMysql(reg.getFecha()));
            
            consulta.executeUpdate();
            
            llaves =  consulta.getGeneratedKeys();
            if(llaves.next()){
                reg.setId(llaves.getInt(1));
            }
            llaves.close();
            consulta.close();
            conexion.close();
            registrado = true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            registrado = false;
        }
        return registrado;
    }
    
    public static RegistroProgreso buscarPorId(int id){
        RegistroProgreso registro;
        try{
            Connection conexion = ControladorDB.getConexion();
            ResultSet resultados;
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM RegistroProgreso "
            + "WHERE id = ? ",Statement.RETURN_GENERATED_KEYS);
            
            consulta.setInt(1, id);
            
            resultados = consulta.executeQuery();
            if(resultados.next()){
                registro = new RegistroProgreso(resultados.getInt("idExpediente"),
                                                resultados.getString("titulo"),
                                                resultados.getString("descripcion"),
                                                Formatos.toDateTime(resultados.getString("fecha")));
                
            }
            else
                registro = null;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            registro = null;
        }
        return registro;
    }
    
    public static ArrayList<RegistroProgreso> buscarPorExpediente(int idExpediente){
        ArrayList<RegistroProgreso> registro = new ArrayList<RegistroProgreso>();
        try{
            Connection conexion = ControladorDB.getConexion();
            ResultSet resultados;
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM RegistroProgreso "
            + "WHERE idexpediente = ? ORDER BY fecha ASC",Statement.RETURN_GENERATED_KEYS);
            
            consulta.setInt(1, idExpediente);
            
            resultados = consulta.executeQuery();
            if(resultados.next()){
                registro.add(new RegistroProgreso(resultados.getInt("idExpediente"),
                                                resultados.getString("titulo"),
                                                resultados.getString("descripcion"),
                                                Formatos.toDateTime(resultados.getString("fecha"))));
  
            }
            else
                registro = null;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            registro = null;
        }
        return registro;
    }
}
