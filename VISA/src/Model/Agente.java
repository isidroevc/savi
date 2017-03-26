package Model;

import java.util.Date;

public class Agente {
    private int id;
    private Date fechaIngreso;
    private Date fechaNacimiento;
    private float salario;
    
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
    
    
}
