

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class PruebasImagen{
	public static void main(String[] args){
		BufferedImage imagen = new BufferedImage(400,600,BufferedImage.TYPE_INT_ARGB);
        Graphics2D drawTool = imagen.createGraphics();
        
        drawTool.setColor(Color.red);
        
        //drawTool.fillRect(0, 0, 200, 500);
        drawTool.drawString("Hola mundo de imagenes", 200, 500);
        drawTool.drawLine(0, 0, 400, 600);
        drawTool.fillOval(200,300,10,10);
        try{
            ImageIO.write(imagen, "PNG", new File("Suck it and see.png"));
        }catch(Exception ex){
            System.out.println("Sabe que habrá pasao: " + ex.getMessage());
        }
	}
}