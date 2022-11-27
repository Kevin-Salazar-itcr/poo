package dao;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Maverick Madrigal, Andrey Salamanca, Estefani Valverde
 */
public class receptorCorreos {

    public static void main(String[] args){
        
       
        Properties props = new Properties();
        props.setProperty("mail.pop3.starttls.enable", "false");
        props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        props.setProperty("mail.pop3.port", "995");
        props.setProperty("mail.pop3.socketFactory.port", "995");
        Session session = Session.getDefaultInstance(props);

        try {
            Store store = session.getStore("pop3");
            store.connect("pop.gmail.com", "trabajosme03@gmail.com", "mphnptseuojioryk");
            Folder folder = store.getFolder("INBOX"); // This doesn't work for other email account
            folder.open(Folder.READ_ONLY);
            //leer todos los correos no leidos
            Message[] messages = folder.getMessages();
            for (int i = 0; i < messages.length; i++) {
                //leer el contenido del correo solo los que tenga asunto "Crear usuario"      

                System.out.println("Asunto : " + messages[i].getSubject());
                if(messages[i].getSubject().equals("Crear usuario")){
                    System.out.println("Mensaje " + (i + 1));
                    System.out.println("De : " + messages[i].getFrom()[0]);
                    System.out.println("Asunto : " + messages[i].getSubject());
                    System.out.println("Fecha : " + messages[i].getSentDate());
                    System.out.println("Contenido : " + messages[i].getContent());
                    System.out.println("-------------------------------------------------");
                    //leer el contenido del correo
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
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    



    
   


    public static void analizarParteDeMensaje(Part p) {
        try {
            if (p.isMimeType("multipart/*")) {
                Multipart multi;
                multi = (Multipart) p.getContent();

                for (int j = 0; j < multi.getCount(); j++) {
                    analizarParteDeMensaje(multi.getBodyPart(j));
                }
            } else {
                if (p.isMimeType("text/*")) {
                    System.out.println("Texto " + p.getContentType());
                    System.out.println(p.getContent());
                    System.out.println("-------------------------------------------------");
                } else {
                    if (p.isMimeType("image/*")) {
                        System.out.println("Imagen " + p.getContentType());
                        System.out.println("Fichero= " + p.getFileName());
                        System.out.println("-------------------------------------------------");

                        salvarImagenEnFichero(p);
                        visualizarEnJFrame(p);
                    } else {
                        System.out.println("Recibido " + p.getContentType());
                        System.out.println("-------------------------------------------------");
                    }
                }
            }
        } catch (IOException | MessagingException e) {
        }
    }

    private static void visualizarEnJFrame(Part p) throws IOException, MessagingException {
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon(ImageIO.read(p.getInputStream()));
        JLabel label = new JLabel(icon);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private static void salvarImagenEnFichero(Part p) throws IOException, MessagingException, IOException {
        FileOutputStream fichero = new FileOutputStream("d:/" + p.getFileName());
        InputStream in = p.getInputStream();
        byte[] buffer = new byte[1000];
        int leido = 0;

        while ((leido = in.read(buffer)) > 0) {
            fichero.write(buffer, 0, leido);
        }
    }
}