/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Maverick Madrigal
 */

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import modelo.Direccion;
import modelo.Cliente;

public class lectorClientes{

    private final String EXTENSION_A_BUSCAR = ".txt";
    private String directorioCarpetaAExaminar = "";
    private boolean encendido = true;
    public ArrayList<Cliente> clientes;
    
    public lectorClientes() {
        directorioCarpetaAExaminar = "clientes";
        clientes = new ArrayList<Cliente>();
    }

    public boolean run() throws IOException {
        File dir = new File(directorioCarpetaAExaminar);
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            ArrayList<String> losClientes = new ArrayList<>(Files.readAllLines(Paths.get(file.getPath())));
            //agregado del cliente
            clientes.add(new Cliente(Integer.parseInt(losClientes.get(0)), losClientes.get(1)));
        }
        if (files.length == 0) {
            System.out.println("El directorio no contiene extensiones de tipo '"+EXTENSION_A_BUSCAR+"'");
            return false;
        }
        System.out.println("--");
        return true;
    }

    public void setDirectorioABuscar(String dir) {
        this.directorioCarpetaAExaminar = dir;
    }

}
