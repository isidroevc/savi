package Model;

import java.io.File;
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
            String telefono, String celular, String direccion,Date fechaIngreso, 
            Date fechaNacimiento,String password ){
        super(nombre,apellidoP,apellidoM,celular,celular,direccion,fechaNacimiento);
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.fechaNacimiento = fechaNacimiento; 
        this.password = password;
        }
    //Métodos de acceso
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
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
    
    //-Métodos estáticos 
     
     //Método para buscar un agente por su id
     
     public static Agente buscarPorId(int id){
         //
         String[] registro = new String[0];
         SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
         boolean encontrado = false;
         try{
            Scanner lector = new Scanner(new File("src/Resources/Agentes.txt"));
            while(lector.hasNextLine()){
                registro = lector.nextLine().split(",");
                //Si el id es igual al id solicitado
                if(registro[0].trim().equals(Integer.toString(id))){
                    encontrado = true;
                    break;
                }
            }
            //Cerrar el flujo del archivo
            lector.close();
         }catch(Exception ex){
             
         }
         //Si si se encontró
         if(encontrado){
             Agente buscado;
             try{
                buscado = new Agente(Integer.parseInt(registro[0].trim()),//id
                                            registro[1].trim(),//nombre
                                            registro[2].trim(),//paterno
                                            registro[3].trim(),//materno
                                            registro[4].trim(),//telefono
                                            registro[5].trim(),//celular
                                            registro[6].trim(),//direccion
                                            format.parse(registro[7].trim()),
                                            format.parse(registro[8].trim()),
                                            registro[9].trim()//password
                                        );
             }catch(Exception ex){
                 System.out.println(ex.getMessage());
                 return null;
             }
            return buscado;
         }
         return null;
     }
}
