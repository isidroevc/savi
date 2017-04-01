/*

 */
package Utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Formatos {
    
    public static String toDateMysql(Date fecha){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(fecha);
    }
    public static Date toDate(String fecha){
        try{
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            return formato.parse(fecha);
        }catch(Exception ex){
            return null;
        }
    }
    
    public static String toDateTimeMysql(Date fecha){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formato.format(fecha);
    }
    public static Date toDateTime(String fecha){
        try{
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formato.parse(fecha);
        }catch(Exception ex){
            return null;
        }
    }
}
