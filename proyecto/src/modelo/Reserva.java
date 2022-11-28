package modelo;

import java.util.ArrayList;

/**
 *
 * @author Andrey Salamanca Campos, Maverick Madrigal Bryan, Estefani Valverde Mainr
 * @version (26/11/2022)
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
  
  /**
   * Constructor de Resevar
   * @param placa Placa
   * @param sedeRecogida Sede de recogida
   * @param sedeEntrega Sede de entrega
   * @param fechaRecogida Fecha de Recogida
   * @param fechaEntrega Fecha de entrega
   * @param fechaReserva Fecha de reserva
   * @param extras Extras
   * @param precio Precio 
   * @param cedulaCliente Cedula del cliente 
   * @param consecutivo  Consecutivo
   */
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
    // Get de Consecutivo
    public int getConsecutivo(){
        return consecutivo;
    }
    // Get de placa 
    public int getPlacaReserva(){
        return placaReserva;
    }
    // Get de sede de recogida
    public String getSedeRecogida() {
        return sedeRecogida;
    }
    // Get de sede de entrega
    public String getSedeEntrega() {
        return sedeEntrega;
    }
    // Get de fecha de recogida
    public String getFechaRecogida() {
        return fechaRecogida;
    }
    // Get de fecha de entrega
    public String getFechaEntrega() {
        return fechaEntrega;
    }
    // Get de fecha reserva
    public String getFechaReserva() {
        return fechaReserva;
    }
    // Get de extras
    public ArrayList<String> getExtras() {
        return extras;
    }
    // Get de precio
    public double getPrecio() {
        return precio;
    }
    // Get de cedula del cliente
    public int getCedulaCliente() {
        return cedulaCliente;
    }
}
