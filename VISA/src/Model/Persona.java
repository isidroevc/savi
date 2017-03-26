package Model;

public class Persona {
    protected String    nombre,
                        apellidoP,
                        apellidoM,
                        telefono,
                        celular,
                        direccion;

    public Persona(String nombre, String apellidoP, String apellidoM, String telefono, String celular, String direccion){
        this.nombre=nombre;
        this.apellidoP=apellidoP;
        this.apellidoM=apellidoM;
        this.telefono=telefono;
        this.celular=celular;
        this.direccion=direccion;
    }
    
    
    public Persona(){
    
    }

}
