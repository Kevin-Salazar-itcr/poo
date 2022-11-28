
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
import modelo.Direccion;
import modelo.Sede;


public class lectorSedes{

    private final String EXTENSION_A_BUSCAR = ".txt";
    private String directorioCarpetaAExaminar = "";
    private boolean encendido = true;
    public ArrayList<Sede> sedes;
    
    /**
     * Funcion que lee las sedes
     */
    public lectorSedes() {
        directorioCarpetaAExaminar = "sedes";
        sedes = new ArrayList<Sede>();
    }
    /**
     * Lee las sedes registradas
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
            ArrayList<String> lasSedes = new ArrayList<>(Files.readAllLines(Paths.get(file.getPath())));
            Direccion d = new Direccion(lasSedes.get(2),lasSedes.get(3),lasSedes.get(4),lasSedes.get(5));
            
            sedes.add(new Sede(lasSedes.get(0), lasSedes.get(1),d));
        }
        if (files.length == 0) {
            System.out.println("El directorio no contiene extensiones de tipo '"+EXTENSION_A_BUSCAR+"'");
            return false;
        }
        System.out.println("--");
        return true;
    }
    /**
     * Set de directorio a buscar
     * @param dir 
     */
    public void setDirectorioABuscar(String dir) {
        this.directorioCarpetaAExaminar = dir;
    }

}
