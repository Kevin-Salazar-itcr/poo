package modelo;

import java.util.ArrayList;

/**
 * Enumerador de sedes de un rentACar
 *
 * @author Maverick Madrigal Bryan, Andrey Salamanca, Estefani Valverde
 * @version 1
 */
public class Sede {
    private String nombre;
    private String cedulaJuridica;
    private Direccion direccion;
    private ArrayList<Vehiculo> vehiculos;
    
    /**
     * 
     */
    public Sede(){
        
    }
    /**
     * 
     * @param nombre
     * @param cedulaJuridica
     * @param direccion 
     */
    public Sede(String nombre, String cedulaJuridica, Direccion direccion) {
        this.nombre = nombre;
        this.cedulaJuridica = cedulaJuridica;
        this.direccion = direccion;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    /**
     * Metodos accesores 
     * @return 
     */
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
