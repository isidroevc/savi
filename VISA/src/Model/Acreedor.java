package Model;

public class Acreedor extends Persona{
    private int idRepresentante;
    private int id;
    
    
    public void setid(int id){
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

}
