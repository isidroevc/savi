package Model;

import Controller.ControladorDB;
import Utilidades.Formatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class Expediente {
    private int     id,
                    idAcreedor,
                    idAgente;
    private Date    fechaInicio,
                    fechaFin;
    private boolean finalizado, acta, pasaporte, 
            identificacion, comprobante, anterior;

    public Expediente(int idAcreedor,int idAgente, boolean[] estados){
        acta = estados[0];
        pasaporte = estados[1];
        identificacion  = estados[2];
        comprobante = estados[3];
        anterior = estados[4];
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

    public boolean isActa() {
        return acta;
    }

    public void setActa(boolean acta) {
        this.acta = acta;
    }

    public boolean isPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(boolean pasaporte) {
        this.pasaporte = pasaporte;
    }

    public boolean isIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(boolean identificacion) {
        this.identificacion = identificacion;
    }

    public boolean isComprobante() {
        return comprobante;
    }

    public void setComprobante(boolean comprobante) {
        this.comprobante = comprobante;
    }

    public boolean isAnterior() {
        return anterior;
    }

    public void setAnterior(boolean anterior) {
        this.anterior = anterior;
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
    
    public static boolean registrar(Expediente e){
        try{
             Connection conexion = ControladorDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(
             "INSERT INTO Expediente (idAcreedor,idRAgente,fechaInicio,fechaFin,finalizado, acta, pasaporte,comprobante, identificacion, anterior) "
             +" VALUES(?,?,?,?,?,?,?)");
             consulta.setInt(1, e.getIdAcreedor());
             consulta.setInt(2, e.getIdAgente());
             consulta.setString(3,Formatos.toDateTimeMysql(new Date()));
             consulta.setString(4, "");
             consulta.setBoolean(5, false);
             consulta.setBoolean(6,e.isActa() );
             consulta.setBoolean(7, e.isPasaporte());
             consulta.setBoolean(8, e.isComprobante());
             consulta.setBoolean(9, e.isIdentificacion());
             consulta.setBoolean(9, e.isAnterior());
             consulta.executeUpdate();
             return true;
             
         }catch(Exception ex){
             //TODO: Controlar exceptiones
             System.out.println(ex.getMessage());
             return false;
         }
    }
    
    
}
