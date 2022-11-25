
package modelo;
import java.util.*;
/**
 * Clase Cliente
 * @author Andrey Salamanca Campos, Maverick Magrigal Bryan, Estefani Valverde Marín
 * @version (24/11/2022)
 */
public class Cliente {
    private String nombreCompleto;
    private int cedula;
    private Direccion direccionExacta;
    private String correoElectronico;
    private int telefono;
    private Licencia licencia;
    
    
    /**
     * 
     * @param cedula Cedula
     * @param nombreCompleto Nombre Completo 
     */
    public Cliente(int cedula, String nombreCompleto){
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
    }
    
    
    /**
     * 
     * @param pNombreCompleto Nombre Completo
     * @param pCedula Cédula 
     * @param pDireccionExacta Direccion Exacta
     * @param pCorreoElectronico Correo Electronico
     * @param pTelefono Telefono
     * @param pFotografiaLicencia Fotografia de la licencia
     * @param pFechaEmision Fecha de emision
     * @param pFechaExpiracion Fecha de expiracion
     * @param pNumLicencia Numero de licencia
     * @param pTtipoLicencia Tipo de licencia
     */
    public Cliente(String pNombreCompleto, int pCedula, Direccion pDireccionExacta,
            String pCorreoElectronico, int pTelefono, String pFotografiaLicencia,
            Calendar pFechaEmision, Calendar pFechaExpiracion, String pNumLicencia,
            TipoLicencia pTtipoLicencia) {
      nombreCompleto = pNombreCompleto;
      cedula = pCedula;
      direccionExacta = pDireccionExacta;
      correoElectronico = pCorreoElectronico;
      telefono = pTelefono;
      licencia = new Licencia(pNumLicencia, pFechaEmision, pFechaExpiracion, pTtipoLicencia, pFotografiaLicencia);
    }

    /**
     * Constructor clase cliente
     *
     * @param nombre Nombre
     * @param cedula Cedula
     * @param correo Correo
     * @param telefono Telefono
     * @param direccionModelo Direccion  de modelo
     * @param licenciaModelo Licencia de modelo
     */
    public Cliente(String pNombreCompleto, String pCedula, String pCorreoElectronico, String pTelefono, 
            Direccion pDireccionModelo, Licencia licenciaModelo) {
        
      nombreCompleto = pNombreCompleto;
      cedula = Integer.parseInt(pCedula);
      direccionExacta = pDireccionModelo;
      correoElectronico = pCorreoElectronico;
      telefono = Integer.parseInt(pTelefono);
      licencia = licenciaModelo;
    }

    public String getNombreCompleto() {
      return nombreCompleto;
    }
    
    /**
     * 
     * @param pNombreCompleto Nombre Completo
     */
    public void setNombreCompleto(String pNombreCompleto) {
      nombreCompleto = pNombreCompleto;
    }

    public int getCedula() {
      return cedula;
    }
    
    /**
     * 
     * @param pCedula Cedula 
     */
    public void setCedula(int pCedula) {
      cedula = pCedula;
    }

    public Direccion getDireccionExacta() {
      return direccionExacta;
    }

    /**
     * 
     * @param pDireccionExacta Direccion Exacta 
     */
    public void setDireccionExacta(Direccion pDireccionExacta) {
      direccionExacta = pDireccionExacta;
    }

    public String getCorreoElectronico() {
      return correoElectronico;
    }
    
    /**
     * 
     * @param pCorreoElectronico Correo Electronico
     */
    public void setCorreoElectronico(String pCorreoElectronico) {
      correoElectronico = pCorreoElectronico;
    }

    public int getTelefono() {
      return telefono;
    }
    
    /**
     * 
     * @param pTelefono Telefono 
     */
    public void setTelefono(int pTelefono) {
      telefono = pTelefono;
    }

    public String getFotografiaLicencia() {
      return "";
    }

    public Licencia getLicencia() {
      return licencia;
    }
    
    /**
     * 
     * @param licencia Licencia
     */
    public void setLicencia(Licencia licencia) {
      this.licencia = licencia;
    }
    
}
