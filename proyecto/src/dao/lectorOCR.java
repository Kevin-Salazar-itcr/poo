/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 */
public class lectorOCR {
   public String lectura;
   
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
