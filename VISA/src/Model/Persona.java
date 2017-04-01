package Model;

import java.util.Date;

public class Persona {
    // -Atributos
    protected String    nombres,
                        apellidoP,
                        apellidoM,
                        telefono,
                        celular,
                        direccion;
    protected int id;
    protected Date fechaNacimiento;
    public Persona(String nombres, String apellidoP, String apellidoM, String telefono, String celular, String direccion, Date fechaNacimiento){
        this.nombres=nombres;
        this.apellidoP=apellidoP;
        this.apellidoM=apellidoM;
        this.telefono=telefono;
        this.celular=celular;
        this.direccion=direccion;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Persona(){
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombres() {
        return nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCelular() {
        return celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombres(String nombre) {
        this.nombres = nombres;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
