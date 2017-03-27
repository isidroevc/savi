package Model;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Agente extends Persona {
    private int id;
    private Date fechaIngreso;
    private Date fechaNacimiento;
    private float salario;
    private String password;
    
    //Constructores
    public Agente(){
        
    }
    
    public Agente(int id,Date fechaIngreso, Date fechaNacimiento ){
        
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
     
     public static Agente buscarAgente(int id){
         //
         String[] registro;
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
            return null;
         }
         return null;
     }
