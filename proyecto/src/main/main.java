
package main;

import controlador.ControladorMain;
import vista.Menu;

/**
 *
 * @author Andrey Salamanca
 */
public class main {
    public static void main(String[] args){
        Menu ventana = new Menu();
        ControladorMain c = new ControladorMain(ventana);
        
        c.vistaMenu.setVisible(true);
        c.vistaMenu.setLocationRelativeTo(null);
    }
    
}
