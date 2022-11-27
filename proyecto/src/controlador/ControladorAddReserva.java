
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.EstiloVehiculo;
import modelo.Motor;
import modelo.Sede;
import modelo.Vehiculo;
import vista.Extras;

/**
 * Controlador de reserva
 * @author Andrey Salamanca Campos, Maverick Magrigal Bryan, Estefani Valverde Marín
 * @version (24/11/2022)
 */
public class ControladorAddReserva implements ActionListener{
    public RealizarReserva vista;
    public Menu menu;
    public com.raven.datechooser.DateChooser dateChooser1;
    public com.raven.datechooser.DateChooser dateChooser2;
    public ArrayList<Vehiculo> vehiculos;
    public Extras extra;
    public Vehiculo seleccionado;
    /**
     * 
     * @param ventana Vista actual
     * @param vistaMenu Vista anterior
     */
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
        vista.imgCarro.addActionListener(new ActionListener(){
            @Override
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
                            + "\nSede de recogida: "+ seleccionado.getSedePertenencia();
                    JOptionPane.showMessageDialog(null, infoCarro);
                }catch(Exception exc){
                    
                }
            }
            
        });
        dateChooser1.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                vista.fecha1.setText(String.valueOf(date.getDay()+"-"+date.getMonth()+"-"+date.getYear()));
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser1.hidePopup();
                }
            }
        });
        
        dateChooser2.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                vista.fecha2.setText(String.valueOf(date.getDay()+"-"+date.getMonth()+"-"+date.getYear()));
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser2.hidePopup();
                }
            }
        });
        
        
        
        
        vista.filtros.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    for(Vehiculo v:vehiculos){
                        if(v.getPlaca().equals(vista.filtros.getSelectedItem().toString())){
                            vista.costo.setText(String.valueOf(v.getCostoPorDia()));
                            vista.estilo.setText(String.valueOf(v.getEstiloVehiculo()));
                            vista.transmision.setText(String.valueOf(v.getTransmision()));
                            vista.imgCarro.setIcon(new ImageIcon("logos/"+v.getFotoVehiculo()));
                            vista.modelo.setText(String.valueOf(v.getModelo()));
                            seleccionado = v;
                            break;
                        }
                    }
                }catch(Exception exc){
                    
                }
            }
            
        });
        
        generarComboBoxes();
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
            vista.lugarRecogida.addItem(s.getCedulaJuridica());
            vista.lugarDevolucion.addItem(s.getCedulaJuridica());
            
        }
        
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.COMPACTO));
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.CONVERTIBLE));
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.INTERMEDIO));
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.MINI_VANoN));
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.PICKUP));
        vista.tipo.addItem(String.valueOf(EstiloVehiculo.SUV));
        
        for(int i = 2; i<=10; i+=2){
            vista.capacidad.addItem(String.valueOf(i));
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
        
        for(Vehiculo v:lv.vehiculos){
            vista.filtros.addItem(v.getPlaca());
            
        }this.vehiculos = lv.vehiculos;
        
        
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
                    seleccionado = null;
                    filtrar();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorAddReserva.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }case "Reservar":{
                if(diferenciaDias(vista.fecha1.getText(),vista.fecha2.getText())<0 || seleccionado == null){
                    JOptionPane.showMessageDialog(null, "Corrobore que los datos sean correctos");
                }else{
                    reservar();
                }
                break;
            }case "Volver al menú":{
                vista.dispose();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
                break;
            }
            default:
                break;
        } 
    }
    
    public void filtrar() throws IOException{
        String estilo = vista.tipo.getSelectedItem().toString();
        double min = 0;
        double max = 0;
        int capacidad = 0;
        try{
            min = Double.valueOf(vista.min.getText());
            max = Double.valueOf(vista.max.getText());

            capacidad = Integer.parseInt(vista.capacidad.getSelectedItem().toString());
        }catch(Exception exc){
            JOptionPane.showMessageDialog(null, "Error: hace falta datos o estos estan incorrectos");
        }
        lectorVehiculos l = new lectorVehiculos();
        if(l.run()){
            
        }else{
            JOptionPane.showMessageDialog(null, "No hay vehiculos registrados");
        }
        vista.filtros.removeAllItems();
        vista.costo.setText("Costo");
        vista.estilo.setText("estilo");
        vista.transmision.setText("transmision");
        vista.imgCarro.setIcon(null);
        vista.modelo.setText("modelo");
        for(Vehiculo v: l.vehiculos){
            if(v.getCapacidad() >= capacidad &&
            String.valueOf(v.getEstiloVehiculo()).equals(estilo) &&
            v.getCostoPorDia() <= max && v.getCostoPorDia() >= min &&
            v.getSedePertenencia().getCedulaJuridica().equals(vista.lugarRecogida.getSelectedItem().toString())){
            vista.filtros.addItem(String.valueOf(v.getPlaca()));
            }
        }
        
        this.vehiculos = l.vehiculos;
    }
    
    public ArrayList<String> extraerData(){
        ArrayList<String> data = new ArrayList<String>();
        //extraccion de los datos de la interfaz
        
        
        return data;
    }    
    
    
    public long diferenciaDias(String start_date, String end_date){
        try {
            Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(start_date);
            Date date2=new SimpleDateFormat("dd-MM-yyyy").parse(end_date);
            long difference_In_Time = date2.getTime() - date1.getTime();
            return (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
        }
        catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public void reservar(){
        ArrayList<String> data = extraerData();
        extra = new Extras();
        ControladorExtras extras1 = new ControladorExtras(extra, menu);
        extra.setVisible(true);
        extra.setLocationRelativeTo(null);
        vista.setVisible(false);
    }
}
