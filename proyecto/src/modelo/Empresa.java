
package modelo;

/**
 * Clase de Empresa
 * @author Andrey Salamanca Campos, Maverick Magrigal Bryan, Estefani Valverde Marín
 * @version (24/11/2022)
 *
 */
public class Empresa {
    private String razonSocial;
    private int cedulaJuridica;
    private int telefono;
    private Direccion direccion; //PROVINCIA, CANTON, DISTRITOS, SEÑAS
    
    /**
     * 
     * @param pRazonSocial Razon Social
     * @param pCedulaJuridica Cedula Juridica
     * @param pTelefono Telefono
     * @param pDireccion Direcion exacta
     */
    public Empresa(String pRazonSocial, int pCedulaJuridica, int pTelefono, Direccion pDireccion) {
        razonSocial = pRazonSocial;
        cedulaJuridica = pCedulaJuridica;
        telefono = pTelefono;
        direccion = pDireccion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public int getCedulaJuridica() {
        return cedulaJuridica;
    }

    public int getTelefono() {
        return telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    
    /**
     * 
     * @param razonSocial Razon Social 
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    /**
     * 
     * @param cedulaJuridica Cedula Juridica
     */
    public void setCedulaJuridica(int cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }
    
    /**
     * 
     * @param telefono Telefono
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    /**
     * 
     * @param direccion Direccioni 
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
}
