package modelo;

import java.util.Calendar;
import dao.Fechas;

/**
 * Clase que modela un mantenimiento
 *
 * @author Andrey Salamanca
 */
public class Mantenimiento {
  private static int i = 1;
  private int id;
  private TipoMantenimiento tipoMantenimiento;
  private Calendar fechaInicio;
  private Calendar fechaFinalizacion;
  private double montoPagado;
  private String detalle;
  private Empresa empresa;

    public Mantenimiento(TipoMantenimiento pTipoMantenimiento, Calendar pFechaInicio, 
            Calendar pFechaFinalizacion, double pMontoPagado, String pDetalle, Empresa pEmpresa) {
        
        tipoMantenimiento = pTipoMantenimiento; // PREVENTIVO O CORRECTIVO
        fechaInicio = pFechaInicio;
        fechaFinalizacion = pFechaFinalizacion;
        montoPagado = pMontoPagado;
        detalle = pDetalle;
        empresa = pEmpresa;
        this.id = i;
        i++;
    }

    public static int getI() {
        return i;
    }

    public int getId() {
        return id;
    }

    public TipoMantenimiento getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public Calendar getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public String getDetalle() {
        return detalle;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public static void setI(int i) {
        Mantenimiento.i = i;
    }

    public void setId(int pId) {
        id = pId;
    }

    public void setTipoMantenimiento(TipoMantenimiento pTipoMantenimiento) {
        tipoMantenimiento = pTipoMantenimiento;
    }

    public void setFechaInicio(Calendar pFechaInicio) {
        fechaInicio = pFechaInicio;
    }

    public void setFechaFinalizacion(Calendar pFechaFinalizacion) {
        fechaFinalizacion = pFechaFinalizacion;
    }

    public void setMontoPagado(double pMontoPagado) {
        montoPagado = pMontoPagado;
    }

    public void setDetalle(String pDetalle) {
        detalle = pDetalle;
    }

    public void setEmpresa(Empresa pEmpresa) {
        empresa = pEmpresa;
    }
    
    
  
  


  

}
