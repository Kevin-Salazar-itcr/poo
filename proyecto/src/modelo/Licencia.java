
package modelo;

import java.util.*;


/**
 * CLase Licencia
 * @author Andrey Salamanca Campos, Maverick Magrigal Bryan, Estefani Valverde Marín
 * @version (24/11/2022)
 */ 
public class Licencia {
    private String numero;
    private Calendar fechaEmision;
    private Calendar fechaExpiracion;
    private TipoLicencia tipoLicencia;
    private String imagenLicencia;
    
    
    /**
     * 
     * @param pNumero Numero
     * @param pFechaEmision Fecha de Emision
     * @param pFechaExpiracion Fecha de Expiracion
     * @param pTipoLicencia Tipo de Licencia 
     * @param pImagenLicencia  Imagen de la Licencia
     */
    public Licencia(String pNumero, Calendar pFechaEmision, Calendar pFechaExpiracion, 
            TipoLicencia pTipoLicencia, String pImagenLicencia) {
      numero = pNumero;
      fechaEmision = pFechaEmision;
      fechaExpiracion = pFechaExpiracion;
      tipoLicencia = pTipoLicencia;
      imagenLicencia = pImagenLicencia;
    }

    public String getFoto() {
      return imagenLicencia;
    }
}
