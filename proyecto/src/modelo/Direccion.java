
package modelo;

/**
 * Clase Direccion
 * @author Andrey Salamanca Campos, Maverick Magrigal Bryan, Estefani Valverde Marín
 * @version (24/11/2022)
 */
public class Direccion {
    
    private String provincia;
    private String canton;
    private String distrito;
    private String sennas;
    
    /**
     * 
     * @param pProvincia Provincia
     * @param pCanton Canton
     * @param pDistrito Distrito
     * @param pSennas  Señas
     */
    
    public Direccion(String pProvincia, String pCanton, String pDistrito, String pSennas) {
      provincia = pProvincia;
      distrito = pDistrito;
      canton = pCanton;
      sennas = pSennas;
    }

    public String getDistrito(){
        return distrito;
    }
    
    /**
     * 
     * @param pDistrito Distrito 
     */
    public void setDistrito(String pDistrito) {
      distrito = pDistrito;
    }
    
    public String getProvincia() {
      return provincia;
    }
    
    /**
     * 
     * @param pProvincia Provincia
     */
    public void setProvincia(String pProvincia) {
      provincia = pProvincia;
    }

    public String getCanton() {
      return canton;
    }
    
    /**
     * 
     * @param pCanton Canton 
     */
    
    public void setCanton(String pCanton) {
      canton = pCanton;
    }

    public String getSennas() {
      return sennas;
    }
    
    /**
     * 
     * @param pSennas Señas
     */
    public void setSennas(String pSennas) {
      sennas = pSennas;
    }
}
