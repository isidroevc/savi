package Model;

import java.text.SimpleDateFormat;
import Utilidades.Formatos;
import java.util.Date;

public class Persona {
    // -Atributos
    protected String    nombres,
                        apellidoP,
                        apellidoM,
                        direccion;
    
    private long telefono,
                 celular;
    protected int id;
    protected Date fechaNacimiento;
    public Persona(String nombres, String apellidoP, String apellidoM, long telefono, long celular, String direccion, Date fechaNacimiento){
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

    public long getTelefono() {
        return telefono;
    }

    public long getCelular() {
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

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    // -Métodos
    @Override
    public String toString(){
        return    "nombres: "         + this.nombres
                + "\napellidoP: "       + this.apellidoP
                + "\napellidoM: "       + this.apellidoM
                + "\ntelefono: "        + Long.toString(this.telefono)
                + "\ncelular: "         + Long.toString(this.celular)
                + "\ndireccion: "       + this.direccion
                + "\nfechaNacimiento: " + Formatos.toDateMysql(this.fechaNacimiento);
                
    }
    
}
