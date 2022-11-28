package dao;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import javax.imageio.ImageIO;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JOptionPane;

/**
 *
 * @author Maverick Madrigal, Andrey Salamanca, Estefani Valverde
 * @version (11/26/2022)
 */
public class receptorCorreos {
    public receptorCorreos(){
        
    }
    /**
     * Lee los correos recibidos
     * @param asunto asunto a buscar
     * @param carpeta donde se guarda los correos no leidos
     */
    public void leerCorreos(String asunto, String carpeta){ 
        Properties props = new Properties();
        props.setProperty("mail.pop3.starttls.enable", "false");
        props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        props.setProperty("mail.pop3.port", "995");
        props.setProperty("mail.pop3.socketFactory.port", "995");
        Session session = Session.getDefaultInstance(props);

        try {
            Store store = session.getStore("pop3");
            store.connect("pop.gmail.com", "trabajosme03@gmail.com", "mphnptseuojioryk"); //correo usado para propositos del proyecto
            Folder folder = store.getFolder("INBOX"); // This doesn't work for other email account
            folder.open(Folder.READ_ONLY);
            //leer todos los correos no leidos
            Message[] messages = folder.getMessages();
            int i = 0;
            for (i = 0; i < messages.length; i++) {
                //leer el contenido del correo solo los que tenga asunto igual al dado     
                
                if(messages[i].getSubject().equals(asunto)){
                    File f = new File(carpeta+"/usuario"+i+".txt");
                    f.createNewFile();
                    FileWriter fwtr = new FileWriter(f);
                    BufferedWriter bwtr = new BufferedWriter(fwtr);
                    bwtr.write((String) messages[i].getContent()); //guardar el contenido en el txt
                    bwtr.close();
                    
                    Multipart multiPart = (Multipart) messages[i].getContent();
                    for (int j = 0; j < multiPart.getCount(); j++) {
                        Part part = multiPart.getBodyPart(j);
                        //verificar si el contenido es un archivo pdf 
                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            //guardar el archivo pdf en la carpeta del proyecto
                            String fileName = part.getFileName();
                            //part.saveFile(fileName);
                            System.out.println("Archivo adjunto : " + fileName);
                        } else {
                            
                            //verificar si el contenido es una imagen
                            if (part.isMimeType("image/*")) {
                                //guardar la imagen en la carpeta del proyecto
                                String fileName = part.getFileName();
                                //part.saveFile(fileName);
                                System.out.println("Imagen adjunta : " + fileName);
                            } else {
                                //verificar si el contenido es un texto
                                if (part.isMimeType("text/plain")) {
                                    System.out.println("Contenido : " + part.getContent());
                                }
                            }
                        }
                        
                    }

                }
            }

            folder.close(false);
            store.close();
            JOptionPane.showMessageDialog(null, "Se han recuperado "+(i-1)+" nuevos correos no leídos");
            
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}