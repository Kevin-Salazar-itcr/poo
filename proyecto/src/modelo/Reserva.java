package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 
 */
public class Reserva {
  private String sedeRecogida;
  private String sedeEntrega;
  private Date fechaRecogida;
  private Date fechaEntrega;
  private Date fechaReserva;
  private ArrayList<String> extras;
  private double precio;
  private String cedulaCliente;

  public Reserva(String sedeRecogida, String sedeEntrega, Date fechaRecogida, Date fechaEntrega, Date fechaReserva, ArrayList<String> extras, double precio, String cedulaCliente) {
    this.sedeRecogida = sedeRecogida;
    this.sedeEntrega = sedeEntrega;
    this.fechaRecogida = fechaRecogida;
    this.fechaEntrega = fechaEntrega;
    this.fechaReserva = fechaReserva;
    this.extras = extras;
    this.precio = precio;
    this.cedulaCliente = cedulaCliente;
  }

    public String getSedeRecogida() {
        return sedeRecogida;
    }

    public String getSedeEntrega() {
        return sedeEntrega;
    }

    public Date getFechaRecogida() {
        return fechaRecogida;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public ArrayList<String> getExtras() {
        return extras;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }
}
