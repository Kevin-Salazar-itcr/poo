/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Maverick Madrigal, Andrey Salamanca, Estefani Valverde
 */

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Reserva;


public class lectorReservas{

    private final String EXTENSION_A_BUSCAR = ".txt";
    private String directorioCarpetaAExaminar = "";
    private boolean encendido = true;
    public ArrayList<Reserva> reservas;
    
    /**
     * Funcion que lee las reservas
     */
    public lectorReservas() {
        directorioCarpetaAExaminar = "reservas";
        reservas = new ArrayList<Reserva>();
    }
    /**
     * 
     * @return
     * @throws IOException 
     */
    public boolean run(){
        File dir = new File(directorioCarpetaAExaminar);
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            ArrayList<String> lasReservas = null;
            try {
                lasReservas = new ArrayList<>(Files.readAllLines(Paths.get(file.getPath())));
            } catch (IOException ex) {
                //no existen reservas
                return false;
            }
            ArrayList<String> extra = new ArrayList<String>();
            //recopilado de las partes extra
            try{
                for(int x = 6; x<=10;x++){
                    if(lasReservas.get(x).equals("WiFi ilimitado")){
                        extra.add(lasReservas.get(x));
                    }
                    if(lasReservas.get(x).equals("Asistencia en carretera")){
                        extra.add(lasReservas.get(x));
                    }
                    if(lasReservas.get(x).equals("GPS")){
                        extra.add(lasReservas.get(x));
                    }
                    if(lasReservas.get(x).equals("Asiento para niños")){
                        extra.add(lasReservas.get(x));
                    }
                    if(lasReservas.get(x).equals("Cobertura por daños de terceros")){
                        extra.add(lasReservas.get(x));
                    }    
                }
                
            
            }catch(Exception exc){
                
            }
            
            this.reservas.add(new Reserva(Integer.parseInt(lasReservas.get(0)),
                lasReservas.get(1),
                lasReservas.get(2),
                lasReservas.get(3),
                lasReservas.get(4),
                lasReservas.get(5),
                extra,
                Double.parseDouble(lasReservas.get((lasReservas.size())-3)),
                Integer.parseInt(lasReservas.get((lasReservas.size())-2)),
                Integer.parseInt(lasReservas.get((lasReservas.size())-1))));
        }
        if (files.length == 0) {
            System.out.println("El directorio no contiene extensiones de tipo '"+EXTENSION_A_BUSCAR+"'");
            return false;
        }
        System.out.println("--");
        return true;
    }
    /**
     * 
     * @param dir 
     */
    public void setDirectorioABuscar(String dir) {
        this.directorioCarpetaAExaminar = dir;
    }

}
