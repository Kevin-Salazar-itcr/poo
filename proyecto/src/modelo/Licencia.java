
package modelo;

import java.util.*;


/**
 *
 * @author Andrey Salamanca
 */
public class Licencia {
    private String numero;
    private Calendar fechaEmision;
    private Calendar fechaExpiracion;
    private TipoLicencia tipoLicencia;
    private String imagenLicencia;

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
