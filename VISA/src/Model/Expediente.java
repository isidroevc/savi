package Model;

import java.util.Date;

public class Expediente {
    private int     idAcreedor,
                    id;
    private Date    fechaInicio,
                    fechaFin;
    private boolean finalizado;

    
    public int getIdAcreedor() {
        return idAcreedor;
    }
    public void setIdAcreedor(int idAcreedor) {
        this.idAcreedor = idAcreedor;
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
    
    
    
}
