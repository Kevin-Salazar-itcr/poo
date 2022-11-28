package controlador;


import vista.Menu;
import vista.RealizarReserva;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import dao.lectorReservas;
import dao.lectorSedes;
import dao.lectorVehiculos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.EstadoVehiculo;
import modelo.EstiloVehiculo;
import modelo.Motor;
import modelo.Reserva;
import modelo.Sede;
import modelo.Vehiculo;
import vista.ConsultaReserva;
import vista.Extras;

/**
 * Controlador de reserva
 * @author Andrey Salamanca Campos, Maverick Magrigal Bryan, Estefani Valverde Marín
 * @version (27/11/2022)
 */
public class ControladorConsultas implements ActionListener{
    public ConsultaReserva vista;
    public Menu menu;
    public ArrayList<Reserva> reservas;
    public ArrayList<Vehiculo> vehiculos;
    public int cliente;
    public Vehiculo seleccionado;
    /**
     * 
     * constructor del controlador
     */
    public ControladorConsultas(ConsultaReserva ventana, Menu vistaMenu) {
        vista = ventana;
        menu = vistaMenu;
        reservas = new ArrayList<Reserva>();
        
        menu.setVisible(false);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
  
        vista.Volver.addActionListener(this);
        vista.imgCarro.addActionListener(new ActionListener(){
            @Override
            /**
             * Metodo que detecta cuando en el objeto hay un cambio y
             * Dependiendo de la accion ejecuta un codigo
             */
            public void actionPerformed(ActionEvent e) {
                try{
                    String infoCarro = "año: " + seleccionado.getAnio()
                            + "\nmotor: "+seleccionado.getMotor()
                            + "\nkilometraje: "+seleccionado.getKilometraje()
                            + "\nplaca: "+seleccionado.getPlaca()
                            + "\nvin: "+seleccionado.getVin()
                            + "\nmaletas en maletero: " +seleccionado.getCapacidadMaletero()
                            + "\npuertas: "+seleccionado.getNumeroPuertas()
                            + "\nMillas por galon: "+ seleccionado.getMpg()
                            + "\nSede de recogida: "+ seleccionado.getSedePertenencia().getNombre();
                    JOptionPane.showMessageDialog(null, infoCarro);
                }catch(Exception exc){
                    
                }
            }
        });

        vista.reservas.addItemListener(new ItemListener(){
            @Override
            /**
             * Metodo que detecta cuando en el objeto hay un cambio y
             * Dependiendo de la accion ejecuta un codigo
             */
            public void itemStateChanged(ItemEvent e) {
                try{
                    for(Vehiculo v:vehiculos){
                        if(v.getPlaca().equals(vista.reservas.getSelectedItem().toString())){
                            vista.costo.setText(String.valueOf(v.getCostoPorDia()));
                            vista.estilo.setText(String.valueOf(v.getEstiloVehiculo()));
                            vista.transmision.setText(String.valueOf(v.getTransmision()));
                            vista.imgCarro.setIcon(new ImageIcon("logos/"+v.getFotoVehiculo()));
                            vista.modelo.setText(String.valueOf(v.getModelo()));
                            seleccionado = v;
                            break;
                        }
                    }
                    //llenado de las demas etiquetas
                    
                    vista.wifi.setForeground(Color.RED);
                    vista.asist.setForeground(Color.RED);
                    vista.gps.setForeground(Color.RED);
                    vista.ninio.setForeground(Color.RED);
                    vista.danio.setForeground(Color.RED);
                    
                    for(Reserva r:reservas){
                        if(String.valueOf(r.getPlacaReserva()).equals(vista.reservas.getSelectedItem().toString())){
                            vista.fecha1.setText(r.getFechaRecogida());
                            vista.fecha2.setText(r.getFechaEntrega());
                            vista.fechaReserva.setText(r.getFechaReserva());
                            vista.cliente.setText(String.valueOf(r.getCedulaCliente()));
                            vista.consecutivo.setText(String.valueOf(r.getConsecutivo()));
                            vista.total.setText(String.valueOf(r.getPrecio()));
                            vista.sede3.setText(r.getSedeRecogida());
                            vista.sede2.setText(r.getSedeEntrega());
                            for(String s:r.getExtras()){
                                System.out.println(s);
                            
                                if(s.equals("WiFi ilimitado")){
                                    vista.wifi.setForeground(Color.GREEN);
                                }
                                if(s.equals("Asistencia en carretera")){
                                    vista.asist.setForeground(Color.GREEN);
                                }
                                if(s.equals("GPS")){
                                    vista.gps.setForeground(Color.GREEN);
                                }
                                if(s.equals("Asiento para niños")){
                                    vista.ninio.setForeground(Color.GREEN);
                                }
                                if(s.equals("Cobertura por daños de terceros")){
                                    vista.danio.setForeground(Color.GREEN);
                                }
                                
                            }
                            
                        }
                    }
                    
                }catch(Exception exc){
                    
                }
            }
            
        });
        
        generarComboBoxes();
    }
    
    /**
     * Metodo para generar combobox donde va a aparecer opciones
     */
    public void generarComboBoxes(){
        //agregar las reservas
        lectorReservas lector = new lectorReservas();
        if(lector.run()){
            
        }else{
            JOptionPane.showMessageDialog(null, "No hay reservas registradas");
            vista.dispose();
            menu.setVisible(true);
            return;
        }
        
        reservas = lector.reservas;
        for(Reserva r: reservas){
            vista.reservas.addItem(String.valueOf(r.getPlacaReserva()));
        }
        
        //ingresado de los vehiculos
        lectorVehiculos lv = new lectorVehiculos();
        try {
            if(lv.run()){
                
            }else{
                JOptionPane.showMessageDialog(null, "No hay vehículos registrados");
                vista.dispose();
                menu.setVisible(true);
                return;
            }
                 
        } catch (IOException ex) {
            Logger.getLogger(ControladorAddVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.vehiculos = lv.vehiculos;
    }

    @Override
    /**
     * Metodo que vuelve al menu principal
     */
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Volver al menú":{
                vista.dispose();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
                break;
            }
            default:
                break;
        } 
    }
    
    
}
