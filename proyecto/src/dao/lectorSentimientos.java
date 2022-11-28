
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

public class lectorSentimientos{

    private final String EXTENSION_A_BUSCAR = ".txt";
    private String directorioCarpetaAExaminar = "";
    private boolean encendido = true;
    public ArrayList<Integer> data;
    
    /**
     * Funcion que lee las sedes
     */
    public lectorSentimientos() {
        directorioCarpetaAExaminar = "sentimientos";
        data = new ArrayList<Integer>();
    }
    /**
     * Lee los sentimientos registrados
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
            ArrayList<String> sents = new ArrayList<>(Files.readAllLines(Paths.get(file.getPath())));
            System.out.println(sents.get(0));
            //recortar la parte del numero
            String numero = String.valueOf(sents.get(0).charAt((sents.get(0).length())-2 ))
                    +String.valueOf(sents.get(0).charAt((sents.get(0).length())-1 )); //el numero se encuentra en las ultimas 2 posiciones de la primera linea
            System.out.println("*"+numero+"*");
            
            try{
                if(numero.charAt(0)==' '){
                    numero = String.valueOf(numero.charAt(1));
                }
                data.add(Integer.parseInt(numero));
            }catch(Exception e){
                
            }
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
