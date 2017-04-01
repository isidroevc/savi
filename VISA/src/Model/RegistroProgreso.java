package Model;

public class RegistroProgreso {
    private int     id,
                    idExpediente;    
                    
    private String  titulo,
                    descripcion,
                    fecha;

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
    

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getFecha(){
        return fecha;
    }
    
    
}
