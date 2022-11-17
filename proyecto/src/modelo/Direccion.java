
package modelo;

/**
 *
 * @author Andrey Salamanca
 */
public class Direccion {
    
    private String provincia;
    private String canton;
    private String distrito;
    private String sennas;


    public Direccion(String pProvincia, String pCanton, String pDistrito, String pSennas) {
      provincia = pProvincia;
      distrito = pDistrito;
      canton = pCanton;
      sennas = pSennas;
    }

    public String getDistrito(){
        return distrito;
    }
    
    public void setDistrito(String pDistrito) {
      distrito = pDistrito;
    }
    
    public String getProvincia() {
      return provincia;
    }

    public void setProvincia(String pProvincia) {
      provincia = pProvincia;
    }

    public String getCanton() {
      return canton;
    }

    public void setCanton(String pCanton) {
      canton = pCanton;
    }

    public String getSennas() {
      return sennas;
    }

    public void setSennas(String pSennas) {
      sennas = pSennas;
    }
}
