
package controlador;
import dao.lectorVehiculos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import modelo.EstadoVehiculo;
import modelo.Vehiculo;
import vista.Extras;
import vista.Menu;


/**
 *
 * @author Andrey Salamanca, Maverick Madrigal, Estefani Valverde
 * @version (25/11/2022)
 */
public class ControladorExtras implements ActionListener {
    public Extras e;
    public Menu m;
    public ArrayList<String> data;
    public Vehiculo elegido;
    public long diff;
    public int cliente;
    
    /**
     * Controlador de requerimientos extras
     * @param e Estras
     * @param m Menu
     * @param data ArrayList de Data
     * @param elegido Vehiculo Elegido
     * @param diff  Diferencia
     * @param cliente Cliente
     */
    public ControladorExtras(Extras e, Menu m, ArrayList<String> data, Vehiculo elegido, long diff, int cliente){
        this.e = e;
        this.m = m;
        e.aceptar.addActionListener(this);
        e.cancelar.addActionListener(this);
        this.data = data;
        this.elegido = elegido;
        this.diff = diff;
        this.cliente = cliente;
    }
    
    @Override
    /*
    * Metodo para detectar la opcion pusta por el usuario
     */
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Aceptar":{
            try {
                procesadoDatos();
            } catch (IOException ex) {
                Logger.getLogger(ControladorExtras.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case "Cancelar":{
                this.e.dispose();
                this.m.setVisible(true);
                this.m.setLocationRelativeTo(null);
                break;
            }
            default:{
                break;
            }
        }
    }
    /**
     * Metodo que se encarga de los servicios opcionales
     * @throws IOException 
     */
    public void procesadoDatos() throws IOException{
        //guardado del nuevo txt
        
        double precio = elegido.getCostoPorDia()*diff;
        
        //extraccion de datos extras
        if(e.wifi.isSelected()){
            precio+=(15*diff);
            data.add("WiFi ilimitado");
        }if(e.asist.isSelected()){
            data.add("Asistencia en carretera");
            precio+=(3.99*diff);
        }if(e.gps.isSelected()){
            data.add("GPS");
            precio+=(13.99*diff);
        }if(e.ninio.isSelected()){
            data.add("Asiento para niños");
            precio+=(6.99*diff);
        }if(e.danio.isSelected()){
            data.add("Cobertura por daños de terceros");
            precio+=(12.99*diff);
        }
        
        precio += precio*0.13; //IVA del 13%
        
        data.add(String.valueOf(precio));
        data.add(String.valueOf(cliente));
        int consecutivo = 0;
        try{
            File dir = new File("reservas");
            File[] files = dir.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt");
                }
            });
            consecutivo = files.length;
        }catch(Exception exc){
            
        }
        data.add(String.valueOf(consecutivo+1));
        
        try {
            String ruta = "reservas/reserva_"+elegido.getPlaca()+".txt";
            String contenido = "";
            
            for(String dato: data){
                contenido+=dato+"\n";
            }
            
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
                
                //editado del vehiculo en los datos
                BufferedReader bf = new BufferedReader(new FileReader("vehiculos/"+elegido.getPlaca()+".txt"));
                ArrayList<String> lines = new ArrayList<String>();
                
                String line = bf.readLine();
                int contador = 0;
                while(line != null){
                    if(contador == 15){
                        lines.add("INACTIVO");
                        line = bf.readLine();
                        contador++;
                    }else{
                        lines.add(line);
                        line = bf.readLine();
                        contador++;
                    }
                }
                
                //convertir el arraylist a un string
                String res = "";
                for(String ln: lines){
                    res+=ln+"\n";
                }
                
                File f = new File("vehiculos/"+elegido.getPlaca()+".txt");
                f.createNewFile();
                FileWriter fwtr = new FileWriter(f);
                BufferedWriter bwtr = new BufferedWriter(fwtr);
                bwtr.write(res);
                bwtr.close();
                
                JOptionPane.showMessageDialog(null, "Reserva agregada exitosamente");
                
                e.dispose();
                m.setVisible(true);
                m.setLocationRelativeTo(null);
            }else{
                JOptionPane.showMessageDialog(null, "La reserva ya existe");
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"Reserva agregada exitosamente");
        e.dispose();
        m.setVisible(true);
        m.setLocationRelativeTo(null);
    }
}
