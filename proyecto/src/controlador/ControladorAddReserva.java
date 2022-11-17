/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import vista.Menu;
import vista.RealizarReserva;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import dao.lectorSedes;
import dao.lectorVehiculos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.EstiloVehiculo;
import modelo.Motor;
import modelo.Sede;
import modelo.Vehiculo;

/**
 *
 * @author 
 */
public class ControladorAddReserva implements ActionListener{
    public RealizarReserva vista;
    public Menu menu;
    public com.raven.datechooser.DateChooser dateChooser1;
    public com.raven.datechooser.DateChooser dateChooser2;
    ArrayList<Vehiculo> vehiculos;
    
    public ControladorAddReserva(RealizarReserva ventana, Menu vistaMenu) {
        vista = ventana;
        menu = vistaMenu;
        dateChooser1=new com.raven.datechooser.DateChooser();
        dateChooser1.setTextRefernce(vista.fecha1);
        dateChooser2=new com.raven.datechooser.DateChooser();
        dateChooser2.setTextRefernce(vista.fecha2);
        vehiculos = new ArrayList<Vehiculo>();
        
        vista.Filtrar.addActionListener(this);
        vista.Reservar.addActionListener(this);
        vista.Volver.addActionListener(this);
        vista.setFecha1.addActionListener(this);
        vista.setFecha2.addActionListener(this);
        
        dateChooser1.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                vista.fecha1.setText(String.valueOf(date.getDay()+"/"+date.getMonth()+"/"+date.getYear()));
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser1.hidePopup();
                }
            }
        });
        
        dateChooser2.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                vista.fecha2.setText(String.valueOf(date.getDay()+"/"+date.getMonth()+"/"+date.getYear()));
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser2.hidePopup();
                }
            }
        });
        
        generarComboBoxes();
        
        vista.filtros.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Vehiculo v:vehiculos){
                    vista.costo.setText(String.valueOf(v.getCostoPorDia()));
                    vista.estilo.setText(String.valueOf(v.getEstiloVehiculo()));
                    vista.transmision.setText(String.valueOf(v.getTransmision()));
                    vista.imgCarro.setIcon(new ImageIcon("logos/"+v.getFotoVehiculo()));
                    System.out.println(v.getFotoVehiculo());
                    vista.modelo.setText(String.valueOf(v.getModelo()));
                        
                }
            }
        });
    }

    public void generarComboBoxes(){
        //agregar las sedes
        lectorSedes lector = new lectorSedes();
        try {
            if(lector.run()){
                
            }else{
                JOptionPane.showMessageDialog(null, "No hay sedes registradas");
                vista.dispose();
                menu.setVisible(true);
                return;
            }
                 
        } catch (IOException ex) {
            Logger.getLogger(ControladorAddVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Sede s:lector.sedes){
            vista.lugarRecogida.addItem(s.getNombre());
            vista.lugarDevolucion.addItem(s.getNombre());
            
        }
        
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.COMPACTO));
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.CONVERTIBLE));
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.INTERMEDIO));
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.MINI_VAN));
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.PICKUP));
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.SUV));
        
        for(int i = 2; i<=10; i+=2){
            vista.capacidad.addItem(String.valueOf(i));
        }
        
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "...":{
                dateChooser1.showPopup();
                break;
            }case "....":{
                dateChooser2.showPopup();
                break;
            }case "Filtrar":{
            try {
                filtrar();
            } catch (IOException ex) {
                Logger.getLogger(ControladorAddReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }case "Reservar":{
                JOptionPane.showMessageDialog(null,"Reserva agregada exitosamente");
                vista.setVisible(false);
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
                break;
            }case "Volver al menú":{
                vista.dispose();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
                break;
            }default:
                break;
        } 
    }
    
    public void filtrar() throws IOException{
        String estilo = vista.tipo.getSelectedItem().toString();
        double min = Double.valueOf(vista.min.getText());
        double max = Double.valueOf(vista.max.getText());
        
        int capacidad = Integer.parseInt(vista.capacidad.getSelectedItem().toString());
        
        lectorVehiculos l = new lectorVehiculos();
        if(l.run()){
            
        }else{
            JOptionPane.showMessageDialog(null, "No hay vehiculos registrados");
        }
        
        for(Vehiculo v: l.vehiculos){
            System.out.println(v.getMarca());
            
            System.out.println(v.getCapacidad() >= capacidad);
            
            System.out.println(String.valueOf(v.getEstiloVehiculo()).equals(estilo));
            
            System.out.println(v.getCostoPorDia() <= max && v.getCostoPorDia() >= min);
            
            if(v.getCapacidad() >= capacidad &&
            String.valueOf(v.getEstiloVehiculo()).equals(estilo) &&
            v.getCostoPorDia() <= max && v.getCostoPorDia() >= min){
                System.out.println("hola");
                vista.filtros.addItem(String.valueOf(v.getPlaca()));
            }
            
        }
        
        this.vehiculos = l.vehiculos;
    }
    
}
