package modelo;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Reserva {
  private int placaReserva;
  private String sedeRecogida;
  private String sedeEntrega;
  private String fechaRecogida;
  private String fechaEntrega;
  private String fechaReserva;
  private ArrayList<String> extras;
  private double precio;
  private int cedulaCliente;
  private int consecutivo;

  public Reserva(int placa, String sedeRecogida, String sedeEntrega, String fechaRecogida, String fechaEntrega, String fechaReserva, ArrayList<String> extras, double precio, int cedulaCliente, int consecutivo) {
    this.placaReserva = placa;
    this.sedeRecogida = sedeRecogida;
    this.sedeEntrega = sedeEntrega;
    this.fechaRecogida = fechaRecogida;
    this.fechaEntrega = fechaEntrega;
    this.fechaReserva = fechaReserva;
    this.extras = extras;
    this.precio = precio;
    this.cedulaCliente = cedulaCliente;
    this.consecutivo = consecutivo;
  }
    
    public int getConsecutivo(){
        return consecutivo;
    }
    public int getPlacaReserva(){
        return placaReserva;
    }
    public String getSedeRecogida() {
        return sedeRecogida;
    }

    public String getSedeEntrega() {
        return sedeEntrega;
    }

    public String getFechaRecogida() {
        return fechaRecogida;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public ArrayList<String> getExtras() {
        return extras;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }
}
