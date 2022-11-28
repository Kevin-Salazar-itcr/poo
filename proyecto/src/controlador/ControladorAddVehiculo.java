
package controlador;
import dao.lectorSedes;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.*;
import modelo.*;
import com.raven.datechooser.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/**
 * @author Andrey Salamanca Campos, Maverick Magrigal Bryan, Estefani Valverde Marín
 * @version (24/11/2022)
 */



public class ControladorAddVehiculo implements ActionListener{
    public Menu vistaMenu;
    public AddVehiculo vista;
    public com.raven.datechooser.DateChooser dateChooser;
    
    
    /**
     * 
     * @param anterior Ventana actual
     * @param actual  Ventana anterior
     */
    public ControladorAddVehiculo(Menu anterior, AddVehiculo actual){
        vistaMenu = anterior;
        vista = actual;
        dateChooser=new com.raven.datechooser.DateChooser();
        dateChooser.setTextRefernce(vista.fecha);
        vista.guardar.addActionListener(this);
        vista.volver.addActionListener(this);
        vista.btnFecha.addActionListener(this);
        vista.fecha.setText("");
        generarComboBoxes();
        generarPlacaVIN();
        
        dateChooser.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                vista.fecha.setText(String.valueOf(date.getYear()));
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser.hidePopup();
                }
            }
        });
    }
    
    /**
     * Metodo que genera una placa vin aleatoria
     */
    public void generarPlacaVIN(){
        long vin = (long) Math.floor(Math.random() * 99_000_000_000_000_000L) + 10_000_000_000_000_000L;
        int placa = new Random().nextInt(900000) + 100000;
        
        vista.VIN.setText(String.valueOf(vin));
        vista.placa.setText(String.valueOf(placa));
        
        vista.VIN.setEditable(false);
        vista.placa.setEditable(false);
              
    }
    /**
     * Metodo para generar combobox donde va a aparecer opciones
     */
    
    public void generarComboBoxes(){
        //agregar las sedes
        lectorSedes lector = new lectorSedes();
        try {
            if(lector.run()){
                
            }else{
                JOptionPane.showMessageDialog(null, "No hay sedes registradas");
                vista.dispose();
                vistaMenu.setVisible(true);
            }
                 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No hay sedes registradas");
        }
        
        for(Sede s:lector.sedes){
            vista.sede.addItem(s.getCedulaJuridica());
        }
        
        try {
            ArrayList<String> vehiculos = new ArrayList<>(Files.readAllLines(Paths.get("marcas.txt")));
            for (String elemento:vehiculos){
                vista.marcas.addItem(elemento);
            }
        }
        catch (Exception e) {
        }
        
        vista.estilo.addItem(String.valueOf(EstiloVehiculo.COMPACTO));
        vista.estilo.addItem(String.valueOf(EstiloVehiculo.CONVERTIBLE));
        vista.estilo.addItem(String.valueOf(EstiloVehiculo.INTERMEDIO));
        vista.estilo.addItem(String.valueOf(EstiloVehiculo.MINI_VAN));
        vista.estilo.addItem(String.valueOf(EstiloVehiculo.PICKUP));
        vista.estilo.addItem(String.valueOf(EstiloVehiculo.SUV));
        
        vista.motor.addItem(String.valueOf(Motor.DIESEL));
        vista.motor.addItem(String.valueOf(Motor.ELECTRICO));
        vista.motor.addItem(String.valueOf(Motor.GASOLINA));
        vista.motor.addItem(String.valueOf(Motor.HIBRIDO));
        
        for(int i = 2; i<=10; i+=2){
            vista.capac.addItem(String.valueOf(i));
        }
        
        
        
        //capacidad de maletas
        for(int i = 0; i<=10; i++){
            vista.maletas.addItem(String.valueOf(i));
        }
    }
    
    @Override
    /**
     *  Metodo para detectar la opcion pusta por el usuario
     */
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "...":{
                dateChooser.showPopup();
                break;
            }
            case "Guardar":{
                if(!guardar()){
                    
                }
                else{
                    vista.dispose();
                    vistaMenu.setVisible(true);               
                    vistaMenu.setLocationRelativeTo(null);
                }
                break;
            }case "Volver al menú":{
                vista.dispose();
                vistaMenu.setVisible(true);
                vistaMenu.setLocationRelativeTo(null);
                break;
            }default:
                break;
        } 
    }
    
    /**
     * Metodo que guarda el vehiculo segun los datos puesto por el usuario
     * Ademas de veficar que los datos sean los correctos
     */
    public boolean guardar(){
        
        String vin = vista.VIN.getText();
        boolean auto = vista.auto.isSelected();
        String placa = vista.placa.getText();
        String fabricacion = vista.fecha.getText();
        String marca = vista.marcas.getSelectedItem().toString();
        String estilo = vista.estilo.getSelectedItem().toString();
        String motor = vista.motor.getSelectedItem().toString();
        String color = vista.color.getText();
        String capacidad = vista.capac.getSelectedItem().toString();
        String kilometraje = vista.kilometraje.getText();
        String numeroPuertas = vista.puertas.getText();
        String millas = vista.mxg.getText();
        String sede = vista.sede.getSelectedItem().toString();
        String alquiler = vista.precio.getText();
        String maletas = vista.maletas.getSelectedItem().toString();
        String modelo = vista.modelo.getText();
        
        //validar que los datos sean correctos
        try{
            if(marca != ""
               && color != ""
               && Integer.parseInt(kilometraje)>0
               && Integer.parseInt(numeroPuertas)>=2
               && Integer.parseInt(millas)>0
               && Integer.parseInt(alquiler)>0
               && modelo != ""){
               //validacion completa
            }
        }catch(Exception exc){
            JOptionPane.showMessageDialog(null, "Verifique que los datos ingresados sean correctos");
            return false;
        }
        
        int transm = 0;
        if(auto){
            transm = 1;
        }
        
        try {
            
            String ruta = "vehiculos/"+placa+".txt";
            String contenido = "";
            contenido = placa+"\n"+                 //0
                    fabricacion+"\n"+               //1
                    estilo+"\n"+                    //2
                    motor+"\n"+                     //3
                    color+"\n"+                     //4
                    marca+"\n"+                     //5
                    capacidad+"\n"+                 //6
                    kilometraje+"\n"+               //7
                    numeroPuertas+"\n"+             //8
                    vin+"\n"+                       //9
                    millas+"\n"+                    //10
                    sede+"\n"+                      //11
                    alquiler+"\n"+                  //12
                    maletas+"\n"+                   //13
                    String.valueOf(transm)+         //14 
                    "\nACTIVO\n"+                   //15
                    marca+".png"+                   //16
                    "\n1\n"                         //17 
                    +modelo;                        //18
            
            
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
                JOptionPane.showMessageDialog(null, "Vehículo agregado exitosamente");
                
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "El vehículo ya existe");
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
    }
}
