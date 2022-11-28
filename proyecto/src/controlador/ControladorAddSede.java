
package controlador;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import vista.*;
import modelo.*;
/**
 * @author Andrey Salamanca Campos, Maverick Magrigal Bryan, Estefani Valverde Marín
 * @version (24/11/2022)
 */
public class ControladorAddSede implements ActionListener{
    public Menu vistaMenu;
    public RegistroSede vista;
   
    
    /**
     * Constructor de Registrar sede
     * @param ventana Ventana actual
     * @param anterior Ventana anterior
     */
    public ControladorAddSede(RegistroSede ventana, Menu anterior){
        vistaMenu = anterior;
        vista = ventana;
        
        this.vista.guardar.addActionListener(this);
        this.vista.volver.addActionListener(this);
        
        vista.provincia.addItem("San José");
        vista.provincia.addItem("Alajuela");
        vista.provincia.addItem("Cartago");
        vista.provincia.addItem("Heredia");
        vista.provincia.addItem("Guanacaste");
        vista.provincia.addItem("Puntarenas");
        vista.provincia.addItem("Limón");
    }
    
    @Override
    /**
     * Metodo para detectar la opcion pusta por el usuario
     */
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Guardar":
                guardar();
                break;
            case "Volver al menú":
                vista.dispose();
                vistaMenu.setVisible(true);
                break;
            default:
                break;
        } 
    }
    
    
    /**
     * Metodo que guarda la sede segun los datos puestos por el usuario
     * Además de hacer la validaciones correspodientes
     */
    public void guardar(){
        String cedula = vista.cedula.getText();
        String nombre = vista.nombre.getText();
        String provincia = vista.provincia.getSelectedItem().toString();
        String canton = vista.canton.getText();
        String distrito = vista.distrito.getText();
        String senias = vista.senias.getText();
        
        if(cedula.equals("") || nombre.equals("") || canton.equals("") || distrito.equals("") || senias.equals("")){
            JOptionPane.showMessageDialog(null, "Verifique que no hayan campos vacios");
            return;
        }
        
        try{
            if(Integer.parseInt(cedula)>=100000000 && Integer.parseInt(cedula)<=999999999){
                
            }
        }catch(NumberFormatException exc){
            JOptionPane.showMessageDialog(null, "Verifique que la cedula solo contenga 9 digitos");
            return;
        }
        try {
            String ruta = "sedes/"+cedula+".txt";
            String contenido = cedula+"\n"+nombre+"\n"+provincia+"\n"+canton+"\n"+distrito+"\n"+senias;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
                JOptionPane.showMessageDialog(null, "Sede agregada exitosamente");
                
                vista.dispose();
                vistaMenu.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "La sede ya existe");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
