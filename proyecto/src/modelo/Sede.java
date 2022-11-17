package modelo;

import java.util.ArrayList;

/**
 * Enumerador de sedes de un rentACar
 *
 * @author Milton Barrera
 * @author Jeremy Beckford
 * @author Jonathan Porras
 * @version 1
 */
public class Sede {
    private String nombre;
    private String cedulaJuridica;
    private Direccion direccion;
    private ArrayList<Vehiculo> vehiculos;
    
    public Sede(){
        
    }

    public Sede(String nombre, String cedulaJuridica, Direccion direccion) {
        this.nombre = nombre;
        this.cedulaJuridica = cedulaJuridica;
        this.direccion = direccion;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }  
    
}
