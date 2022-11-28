
package controlador;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import vista.*;
import modelo.*;
/**
 *
 * @author Andrey Salamanca, Maverick Madrigal Bryan, Estefani Valverde
 * @version (17/11/2022)
 */
public class ControladorMain implements ActionListener{
    public Menu vistaMenu;
    /**
     * Funcion main
     * @param ventana 
     */
    public ControladorMain(Menu ventana){
        vistaMenu = ventana;
        
        this.vistaMenu.Op1.addActionListener(this);
        this.vistaMenu.Op2.addActionListener(this);
        this.vistaMenu.Op3.addActionListener(this);
        this.vistaMenu.Op4.addActionListener(this);
        this.vistaMenu.Op5.addActionListener(this);
        this.vistaMenu.Op6.addActionListener(this);
        this.vistaMenu.Op7.addActionListener(this);
        this.vistaMenu.Op8.addActionListener(this);
    }
    
    @Override
    /**
     * Funcion obtenida por ActionListener
     */
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Registrar Cliente":
                break;
            case "Agregar Vehiculo":
                iniciarVentanaAgregarVehiculo();
                break;
            case "Realizar Reserva":
                iniciarVentanaReserva();
                break;
            case "Consultar Reserva":
                iniciarVentanaConsultaReserva();
                break;
            case "Registrar Sede":
                iniciarVentanaRegistroSedes();
                break;
            case "Analisis de sentimientos":
                // iniciarVentanaRecuperarDatos
                break;
            case "Reportes":
                // iniciarVentanaReportes
                break;   
            case "Salir":
                System.exit(0);
                break;
            default:
                break;
        } 
    }
    
    /**
     * Funcion que inicia la ventana de agregar vehiculo
     */
    public void iniciarVentanaAgregarVehiculo(){
        
        
        AddVehiculo ventana = new AddVehiculo();
        ControladorAddVehiculo c = new ControladorAddVehiculo(vistaMenu, ventana);
        try{
            File dir = new File("sedes");
        
            File[] files = dir.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt");
                }
            });

            if(files.length == 0){
                return;
            }
        
            vistaMenu.setVisible(false);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        }catch(Exception exc){
            
        }
    }
    
    /**
     * Funcion iniciar ventana de reserva 
     */
    public void iniciarVentanaReserva(){
        //se llama a ventana de login
        login ventana = new login();
        ControladorLogin c = new ControladorLogin(ventana,vistaMenu);
        
        File dir = new File("clientes");
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });
        
        if(files.length == 0){
            return;
        }
        
        vistaMenu.setVisible(false);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
    
    /**
     * Funcion que inicia la ventana de registro de sedes
     */
    public void iniciarVentanaRegistroSedes(){
        RegistroSede ventana = new RegistroSede();
        ControladorAddSede c = new ControladorAddSede(ventana,vistaMenu);
        
        vistaMenu.setVisible(false);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
    
    /**
     * Metodo que inicia la ventana consultar reserva
     */
    private void iniciarVentanaConsultaReserva() {
        ConsultaReserva ventana = new ConsultaReserva();
        ControladorConsultas c = new ControladorConsultas(ventana,vistaMenu);

    }
}
