
package modelo;

/**
 *
 * @author Andrey Salamanca
 */
public class Empresa {
    private String razonSocial;
    private int cedulaJuridica;
    private int telefono;
    private Direccion direccion; //PROVINCIA, CANTON, DISTRITOS, SEÑAS

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

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setCedulaJuridica(int cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
}
