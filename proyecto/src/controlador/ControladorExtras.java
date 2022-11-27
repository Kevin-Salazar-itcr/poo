/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import vista.Extras;
import vista.Menu;


/**
 *
 * @author Andrey Salamanca, Maverick Madrigal, Estefani Valverde
 * @version (25/11/2022)
 */
public class ControladorExtras implements ActionListener {
    Extras e;
    Menu m;
    public ControladorExtras(Extras e, Menu m){
        this.e = e;
        this.m = m;
        e.aceptar.addActionListener(this);
        e.cancelar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Aceptar":{
                procesadoDatos();
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
    public void procesadoDatos(){
        //guardado del nuevo txt
        JOptionPane.showMessageDialog(null,"Reserva agregada exitosamente");
        e.setVisible(false);
        m.setVisible(true);
        m.setLocationRelativeTo(null);
    }
}
