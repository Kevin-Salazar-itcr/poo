
package modelo;
import java.util.*;
/**
 *
 * @author Andrey Salamanca
 */
public class Cliente {
    private String nombreCompleto;
    private int cedula;
    private Direccion direccionExacta;
    private String correoElectronico;
    private int telefono;
    private Licencia licencia;

    public Cliente(int cedula, String nombreCompleto){
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
    }
    
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
     * @param nombre
     * @param cedula
     * @param correo
     * @param telefono
     * @param direccionModelo
     * @param licenciaModelo
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

    public void setNombreCompleto(String pNombreCompleto) {
      nombreCompleto = pNombreCompleto;
    }

    public int getCedula() {
      return cedula;
    }

    public void setCedula(int pCedula) {
      cedula = pCedula;
    }

    public Direccion getDireccionExacta() {
      return direccionExacta;
    }

    public void setDireccionExacta(Direccion pDireccionExacta) {
      direccionExacta = pDireccionExacta;
    }

    public String getCorreoElectronico() {
      return correoElectronico;
    }

    public void setCorreoElectronico(String pCorreoElectronico) {
      correoElectronico = pCorreoElectronico;
    }

    public int getTelefono() {
      return telefono;
    }

    public void setTelefono(int pTelefono) {
      telefono = pTelefono;
    }

    public String getFotografiaLicencia() {
      return "";
    }

    public Licencia getLicencia() {
      return licencia;
    }

    public void setLicencia(Licencia licencia) {
      this.licencia = licencia;
    }
    
}
