/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.lectorSentimientos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import vista.Menu;
import vista.Reportes;

/**
 *
 * @author 
 */
public class ControladorReporte implements ActionListener{
    
    Menu menu;
    Reportes rep;
    public ControladorReporte(Menu m, Reportes rep){
        menu = m;
        this.rep = rep;
        this.rep.historia.addActionListener(this);
        this.rep.promedio.addActionListener(this);
        this.rep.volver.addActionListener(this);
        
        this.rep.setVisible(true);
        this.menu.setVisible(false);
        this.rep.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Promedio de servicio":{
                calcularPromedio();
                break;
            }
            case "Historico de sentimientos":{
                graficadora();
                break;
            }
            case "Volver al menu":{
                rep.dispose();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
                break;
            }
            default:
                break;
        }
    }
    
    
    
    public ArrayList<Integer> contadorSentimientos(){
        ArrayList<Integer> data = new ArrayList<Integer>();
        //positivo, negativo y neutral, como es calificacion del 1 al 10 se toma asi
        int positivo = 0; //positivos >=7
        int negativo = 0; //negativos <=3;
        int neutral = 0;  //3<neutral<7
        
        ArrayList<Integer> tmpData = new ArrayList<Integer>();
        
        lectorSentimientos lr = new lectorSentimientos();
        try {
            if(lr.run()){
                
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No hay datos para procesar, volviendo al menú");
            this.menu.setVisible(true);
            this.menu.setLocationRelativeTo(null);
            this.rep.setVisible(false);
            return null;
        }
        
        for(int i = 0; i<lr.data.size(); i++){
            System.out.println(lr.data.get(i));
            if(lr.data.get(i)>=7){
                positivo++;
            }else if(lr.data.get(i)<=3){
                negativo++;
            }else{
                neutral++;
            }
        }
        
        data.add(positivo);
        data.add(negativo);
        data.add(neutral);
        
        return data;
    }
    
    public void graficadora() {                                         
        ArrayList<Integer> data = contadorSentimientos();
        
        ArrayList<String> ref = new ArrayList<String>();
        ref.add("Positivo");
        ref.add("Negativo");
        ref.add("Neutral");
                
        JFreeChart grafico = null;
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for (int i = 0; i<data.size(); i++){
            datos.addValue(data.get(i), "Grafica", ref.get(i));
        }

        DefaultPieDataset pastel = new DefaultPieDataset();
        for(int i = 0; i<data.size(); i++){
            pastel.setValue(ref.get(i), data.get(i));
        }
        
        
        grafico = ChartFactory.createPieChart("Estadistica", pastel, true, true, false);
        
        ChartPanel cPanel = new ChartPanel(grafico);
        JFrame informacion = new JFrame("Estadisticas");
        informacion.getContentPane().add(cPanel);
        informacion.pack();
        informacion.setVisible(true);        
    }                            

    public void calcularPromedio() {
        //calculo de promedio = (suma de todos los valores) / cantidad de valores existentes
        ArrayList<Integer> data = contadorSentimientos();
        double promedio = 0;
        for(int i = 0; i<data.size(); i++){
            promedio+=data.get(i);
        }
        
        promedio/=data.size();
        
        JOptionPane.showMessageDialog(null, "Rent a Car\n"
                + "Promedio de la nota de servicio general\n"
                + "total: "+(Math.round(promedio*100.0)/100.0)
                + "\nTotal de encuestados: "+data.size());
    }
}
