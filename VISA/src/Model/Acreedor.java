package Model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Acreedor extends Persona{
    private int idRepresentante;
    private int id;
    private Date fechaAlta,
                 fechaNacimiento;
    //Constructores 
    public Acreedor(int id, int idReprensentsnte,String nombre, String apellidoP, 
        String apellidoM, String telefono, String celular, String direccion,
        Date fechaAlta,Date fechaNacimiento){
        super(nombre,apellidoP,apellidoM,celular,celular,direccion);
        this.id = id;
        this.idRepresentante = idRepresentante;
        this.fechaAlta = fechaAlta;
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    
    
    public void setIdRepresentante(int idRepresentante){
        this.idRepresentante=idRepresentante;
    }
    public int getIdRepresentante(){
        return idRepresentante;
    }

    
    //Métodos estáticos de lectura de datos.
    
    public static Acreedor buscarPorId(int id){
       String[] registro = new String[0];
         SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
         boolean encontrado = false;
         try{
            Scanner lector = new Scanner(new File("src/Resources/Acreedores.txt"));
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
             Acreedor buscado;
             try{
                buscado = new Acreedor(Integer.parseInt(registro[0].trim()),//id
                                            Integer.parseInt(registro[1].trim()),
                                            registro[2].trim(),//nombre
                                            registro[3].trim(),//paterno
                                            registro[4].trim(),//materno
                                            registro[5].trim(),//telefono
                                            registro[6].trim(),//celular
                                            registro[7].trim(),//direccion
                                            format.parse(registro[8].trim()),
                                            format.parse(registro[9].trim())
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
