/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Maverick Madrigal,Estedani Valverde, Estefani Valverde
 */

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import modelo.Direccion;
import modelo.EstadoVehiculo;
import modelo.EstiloVehiculo;
import modelo.Motor;
import modelo.Sede;
import modelo.Transmision;
import modelo.Vehiculo;


public class lectorVehiculos{

    private final String EXTENSION_A_BUSCAR = ".txt";
    private String directorioCarpetaAExaminar = "";
    private boolean encendido = true;
    public ArrayList<Vehiculo> vehiculos;
    
    /**
     * Funcion que lee los vehiculos
     */
    public lectorVehiculos() {
        directorioCarpetaAExaminar = "vehiculos";
        vehiculos = new ArrayList<Vehiculo>();
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    public boolean run() throws IOException {
        File dir = new File(directorioCarpetaAExaminar);
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            ArrayList<String> losVehiculos = new ArrayList<>(Files.readAllLines(Paths.get(file.getPath())));
            
            Transmision t= Transmision.MANUAL;
            if(Integer.valueOf(losVehiculos.get(14)) == 1){
                t = Transmision.AUTOMATICO;
            }
            
            lectorSedes l = new lectorSedes();
            l.run();
            String sede = losVehiculos.get(11);
            Sede laSede=null;
            for(Sede s: l.sedes){
                System.out.println(s.getCedulaJuridica());
                System.out.println(sede);
                if(s.getCedulaJuridica().equals(sede)){
                    laSede = s;
                    break;
                }
            }
            
            vehiculos.add(new Vehiculo(losVehiculos.get(0),
                                       Integer.parseInt(losVehiculos.get(1)),
                                       EstiloVehiculo.valueOf(losVehiculos.get(2)),
                                       Motor.valueOf(losVehiculos.get(3)),
                                       losVehiculos.get(4),
                                       losVehiculos.get(5),
                                       Integer.parseInt(losVehiculos.get(6)),
                                       Integer.parseInt(losVehiculos.get(7)),
                                       Integer.parseInt(losVehiculos.get(8)),
                                       losVehiculos.get(9),
                                       Double.parseDouble(losVehiculos.get(10)),
                                       Double.parseDouble(losVehiculos.get(12)),
                                       Integer.parseInt(losVehiculos.get(13)),
                                       t,
                                       EstadoVehiculo.valueOf(losVehiculos.get(15)),
                                       losVehiculos.get(16),
                                       laSede,
                                       losVehiculos.get(18)
            ));
            
            
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
