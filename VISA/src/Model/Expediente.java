package Model;

import Controller.ControladorDB;
import Utilidades.Formatos;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Expediente {

    private int id,
            idAcreedor,
            idAgente;
    private Date fechaInicio,
            fechaFin;
    boolean finalizado;

    public Expediente() {

    }

    public Expediente(int idAcreedor, int idAgente) {
        
    }
    public Expediente(int id,int idAcreedor, int idAgente, Date fechaInicio, Date fechaFin, boolean finalizado) {
        this.id = id;
        this.idAcreedor = idAcreedor;
        this.idAgente = idAgente;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.finalizado = finalizado;
    }
    public int getIdAcreedor() {
        return idAcreedor;
    }

    public void setIdAcreedor(int idAcreedor) {
        this.idAcreedor = idAcreedor;
    }

    public int getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    @Override
    public String toString(){
        return "id: " + this.id 
                + "\nidAcreedor: " + this.idAcreedor
                + "\nidAgente: " + this.idAgente
                + "\nfechaInicio: " + ((this.fechaInicio != null)?Formatos.toDateTimeMysql(this.fechaInicio): "nada")
                + "\nfechaFin: " + ((this.fechaFin != null)?Formatos.toDateTimeMysql(this.fechaFin): "nada");
    }
    
    public static Expediente buscarPorId(int id) {
        Expediente exp;
        try {
            
            Connection conexion = ControladorDB.getConexion();
            ResultSet resultados;
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT * FROM Expediente WHERE id = ?", 
                    Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, id);
            
            resultados = consulta.executeQuery();
            if(resultados.next()){
                
                exp = new Expediente(id,
                                      resultados.getInt("idAcreedor"),
                                      resultados.getInt("idAgente"),
                                      Formatos.toDateTime(resultados.getString("fechaInicio")),
                                      Formatos.toDateTime(resultados.getString("fechaFin")),
                                      resultados.getBoolean("finalizado"));
            }
            else 
                exp =  null;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            exp= null;
        }
        return exp;
    }
    
    

    public static boolean registrar(Expediente e) {
        try {
            Connection conexion = ControladorDB.getConexion();
            ResultSet llaves;
            PreparedStatement consulta = conexion.prepareStatement(
                    "INSERT INTO Expediente (idAcreedor,idAgente,fechaInicio,finalizado)VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, e.getIdAcreedor());
            consulta.setInt(2, e.getIdAgente());
            consulta.setString(3, Formatos.toDateTimeMysql(new Date()));
            consulta.setBoolean(4, false);
            consulta.executeUpdate();
            llaves = consulta.getGeneratedKeys();
            if (llaves.next()) {
                e.setId(llaves.getInt(1));
            }
            llaves.close();
            consulta.close();
            conexion.close();
            return true;

        } catch (Exception ex) {
            //TODO: Controlar exceptiones
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
