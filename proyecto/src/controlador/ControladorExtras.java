/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Extras;


/**
 *
 * @author Andrey Salamanca, Maverick Madrigal, Estefani Valverde
 * @version (25/11/2022)
 */
public class ControladorExtras implements ActionListener {
    Extras e;
    public ControladorExtras(Extras e){
        this.e = e;
        e.aceptar.addActionListener(this);
        e.cancelar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
