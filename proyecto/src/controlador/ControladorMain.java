
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
 * @author Andrey Salamanca
 */
public class ControladorMain implements ActionListener{
    public Menu vistaMenu;
    
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
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Registrar cliente por medio de correo electrónico":
                break;
            case "Agregar Vehiculo":
                iniciarVentanaAgregarVehiculo();
                break;
            case "Realizar Reserva":
                iniciarVentanaReserva();
                break;
            case "Consultar detalle de una reserva":
                // iniciarVentanaConsultaReserva
                break;
            case "Registrar Sede":
                iniciarVentanaRegistroSedes();
                break;
            case "Recuperar datos para analisis de sentimientos":
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
    
    public void iniciarVentanaAgregarVehiculo(){
        
        
        AddVehiculo ventana = new AddVehiculo();
        ControladorAddVehiculo c = new ControladorAddVehiculo(vistaMenu, ventana);
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
    }
    
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
    
    public void iniciarVentanaRegistroSedes(){
        RegistroSede ventana = new RegistroSede();
        ControladorAddSede c = new ControladorAddSede(ventana,vistaMenu);
        
        vistaMenu.setVisible(false);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
}
