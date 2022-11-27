
package controlador;
import dao.lectorClientes;
import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.*;
import modelo.*;
/**
 *
 * @author Andrey Salamanca, Maverick Madrigal Bryan, Estefani Valverde
 */


public class ControladorLogin implements ActionListener{
    public Menu vistaMenu;
    public login vista;
    public ArrayList<Integer> listaClientes;
    public lectorClientes l;
    
    /**
     * 
     * @param ventana
     * @param anterior 
     */
    public ControladorLogin(login ventana, Menu anterior){
        l = new lectorClientes();
        listaClientes = new ArrayList<Integer>() ;
        vistaMenu = anterior;
        vista = ventana;
        
        this.vista.jButton1.addActionListener(this);
        this.vista.jButton2.addActionListener(this);
        
        initClientes();
    }
    
    @Override
    /**
     * funcion extraida de la interface ActionListener
     * Controla los objetos de la ventana
     */
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Continuar":
                logueo();
                break;
            case "Volver":
                vista.dispose();
                vistaMenu.setVisible(true);
                break;
            default:
                break;
        } 
    }
    
    /**
     * Revisa que haya clientes antes de inicier
     */
    public void initClientes(){    
        try {
            if(l.run()){
                
            }
            else{
                JOptionPane.showMessageDialog(null, "No hay clientes registrados");
                vista.dispose();
                vistaMenu.setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Cliente c: l.clientes)
            listaClientes.add(c.getCedula());
    }
    
    /**
     * Funcion que inicia sesion
     */
    public void logueo(){
        try{
            int cedula = Integer.parseInt(vista.jTextField1.getText());
            if(cedula==0){
                JOptionPane.showMessageDialog(null, "No puede ingresar campos vacíos");
            }else{
                int logger = 0;
                for(int c:listaClientes){
                    if(c == cedula){
                        logger = cedula;
                        break;
                    }
                }
                
                if(logger != 0){
                    
                    RealizarReserva ventana = new RealizarReserva();
                    ControladorAddReserva c = new ControladorAddReserva(ventana,vistaMenu, logger);
                    File dir = new File("sedes");
                    File[] files = dir.listFiles(new FilenameFilter() {
                        public boolean accept(File dir, String name) {
                            return name.toLowerCase().endsWith(".txt");
                        }
                    });

                    if(files.length == 0){
                        return;
                    }
                    vista.setVisible(false);
                    ventana.setVisible(true);
                    ventana.setLocationRelativeTo(null);
                    
                    for(Cliente cliente: l.clientes){
                        if(cliente.getCedula() == logger){
                            JOptionPane.showMessageDialog(null, "Bienvenido, "+cliente.getNombreCompleto());
                            return;
                        }
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "El cliente indicado no existe");
                }
            }
                  
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error en la entrada");
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error inesperado");
            return;
        }
    }
}
