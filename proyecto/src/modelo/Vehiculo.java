package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Vehiculo {
  private String placa;
  private int anio;
  private EstiloVehiculo estiloVehiculo;// COMPACTO, PICKUP, SUV, MINI_VAN, CONVERTIBLE, ECONOMICO, NONE
  private Motor motor;
  private String color;
  private String marca;
  private int capacidad;
  private int kilometraje;
  private int numeroPuertas;
  private String vin;
  private double mpg;
  private Sede sedePertenencia; // EL ATLANTICO, LA CENTRALITA, AEROPUERTO, OCCIDENTE, PACIFICO NORTE
  private double costoPorDia;
  private int capacidadMaletero;
  private Transmision transmision; // MANUAL AUTOMATICO
  private EstadoVehiculo estadovehiculo; // ACTIVO, MANTENIMIENTO, INACTIVO
  private String fotoVehiculo;
  private List<Mantenimiento> mantenimientos;
  private boolean estaDisponible;
  private String modelo;


  public Vehiculo(String pPlaca, int pAnio, EstiloVehiculo pEstiloVehiculo, Motor pMotor, String pColor,
          String pMarca, int pCapacidad, int pKilometraje, int pNumeroPuertas, String pVin,
          double pMpg, double pCostoPorDia, int pCapacidadMaletero, Transmision pTransmision ,
          EstadoVehiculo pEstadovehiculo, String pFotoVehiculo, Sede pSede) {
    sedePertenencia = pSede;
    placa = pPlaca;
    anio = pAnio;
    estiloVehiculo = pEstiloVehiculo;
    motor = pMotor;
    color = pColor;
    marca = pMarca;
    capacidad = pCapacidad;
    kilometraje = pKilometraje;
    numeroPuertas = pNumeroPuertas;
    vin = pVin;
    mpg = pMpg;
    costoPorDia = pCostoPorDia;
    capacidadMaletero = pCapacidadMaletero;
    transmision = pTransmision;
    estadovehiculo = pEstadovehiculo;
    fotoVehiculo = pFotoVehiculo;
    estaDisponible = true;
    mantenimientos = new ArrayList<Mantenimiento>();
  }
  // CREAR FUNCION TO STRING
  
  
  //constructor sobrecargado con modelo
  public Vehiculo(String pPlaca, int pAnio, EstiloVehiculo pEstiloVehiculo, Motor pMotor, String pColor,
          String pMarca, int pCapacidad, int pKilometraje, int pNumeroPuertas, String pVin,
          double pMpg, double pCostoPorDia, int pCapacidadMaletero, Transmision pTransmision ,
          EstadoVehiculo pEstadovehiculo, String pFotoVehiculo, Sede pSede, String pModelo) {
    sedePertenencia = pSede;
    placa = pPlaca;
    anio = pAnio;
    estiloVehiculo = pEstiloVehiculo;
    motor = pMotor;
    color = pColor;
    marca = pMarca;
    capacidad = pCapacidad;
    kilometraje = pKilometraje;
    numeroPuertas = pNumeroPuertas;
    vin = pVin;
    mpg = pMpg;
    costoPorDia = pCostoPorDia;
    capacidadMaletero = pCapacidadMaletero;
    transmision = pTransmision;
    estadovehiculo = pEstadovehiculo;
    fotoVehiculo = pFotoVehiculo;
    estaDisponible = true;
    mantenimientos = new ArrayList<Mantenimiento>();
    modelo = pModelo;
  }
  
  
  public Motor getMotor(){
      return motor;
  }
  public void setMotor(Motor pMotor){
      motor = pMotor;
  }
  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String pPlaca) {
    placa = pPlaca;
  }

  public int getAnio() {
    return anio;
  }

  public void setAnio(int pAnio) {
    anio = pAnio;
  }

  public EstiloVehiculo getEstiloVehiculo() {
    return estiloVehiculo;
  }

  public void setEstiloVehiculo(EstiloVehiculo pEstiloVehiculo) {
    estiloVehiculo = pEstiloVehiculo;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String pColor) {
    color = pColor;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String pMarca) {
    marca = pMarca;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(int pCapacidad) {
    capacidad = pCapacidad;
  }

  public int getKilometraje() {
    return kilometraje;
  }

  public void setKilometraje(int pkilometraje) {
    kilometraje = pkilometraje;
  }

  public int getNumeroPuertas() {
    return numeroPuertas;
  }

  public void setNumeroPuertas(int pNumeroPuertas) {
    numeroPuertas = pNumeroPuertas;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String pVin) {
    vin = pVin;
  }

  public double getMpg() {
    return mpg;
  }

  public void setMpg(double pMpg) {
    mpg = pMpg;
  }

  public double getCostoPorDia() {
    return costoPorDia;
  }

  public void setCostoPorDia(double pCostoPorDia) {
    costoPorDia = pCostoPorDia;
  }

  public int getCapacidadMaletero() {
    return capacidadMaletero;
  }

  public Sede getSedePertenencia() {
    return sedePertenencia;
  }

  public void setCapacidadMaletero(int pCapacidadMaletero) {
    capacidadMaletero = pCapacidadMaletero;
  }

    public Transmision getTransmision() {
        return transmision;
    }

    public void setTransmision(Transmision pTransmision) {
        transmision = pTransmision;
    }

  public EstadoVehiculo getEstadovehiculo() {
    return estadovehiculo;
  }

  public void setEstadovehiculo(EstadoVehiculo pEstadovehiculo) {
    estadovehiculo = pEstadovehiculo;
  }

  public String getFotoVehiculo() {
    return fotoVehiculo;
  }

  public void setFotoVehiculo(String pFotoVehiculo) {
    fotoVehiculo = pFotoVehiculo;
  }

  public boolean isEstaDisponible() {
    return estaDisponible;
  }

  public void setEstaDisponible(boolean pEstaDisponible) {
    estaDisponible = pEstaDisponible;
  }

  public void setSedePertenencia(Sede pSedePertenencia) {
    sedePertenencia = pSedePertenencia;
  }

  public void agregarMantenimiento(TipoMantenimiento tipoMantenimiento, Calendar fechaInicio, 
          Calendar fechaFinalizacion,double montoPagado, String detalle, Empresa empresa) {
      
    Mantenimiento nuevoMantenimiento = new Mantenimiento(tipoMantenimiento, fechaInicio, fechaFinalizacion,
            montoPagado, detalle, empresa);
    mantenimientos.add(nuevoMantenimiento);
  }

    public Object getModelo() {
        return modelo;
    }


}
