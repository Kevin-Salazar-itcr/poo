package dao;
import net.sourceforge.tess4j.Tesseract;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
/**
 *
 * @author Andrey Salamanca, Estefani Valverde, Maverick Madrigal
 * @version 11/25/2022
 */
public class lectorOCR {
   public String lectura;
   
   /**
    * Constructor del ocr para leer imagenes
    */
   public lectorOCR() throws IOException{
       lectura = leer("foto.png");
       System.out.println(lectura);
   }
   
   public String leer(String img){
       ITesseract t = new Tesseract();
       try {
           return t.doOCR(new File(img));
       } catch (TesseractException ex) {
           ex.printStackTrace();
       }return "";
   }
   
   /*public static void main(String[] args) throws IOException{
       lectorOCR l = new lectorOCR();
   }*/
}
