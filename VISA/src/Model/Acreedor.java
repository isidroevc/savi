package Model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Acreedor extends Persona{
    private int idRepresentante;
    private Date fechaAlta;
    //Constructores 
    public Acreedor(int id, int idReprensentsnte,String nombre, String apellidoP, 
        String apellidoM, long telefono, long celular, String direccion,
        Date fechaAlta,Date fechaNacimiento){
        super(nombre,apellidoP,apellidoM,celular,celular,direccion,fechaNacimiento);
        this.id = id;
        this.idRepresentante = idRepresentante;
        this.fechaAlta = fechaAlta;
    }
    
    public void setIdRepresentante(int idRepresentante){
        this.idRepresentante=idRepresentante;
    }
    public int getIdRepresentante(){
        return idRepresentante;
    }

    
    //Métodos estáticos de lectura de datos.
    
    public static Acreedor buscarPorId(int id){
       return null;
     } 
}
