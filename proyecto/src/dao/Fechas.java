package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de utilidades para gestionar fechas
 *
 * @author Andrey Salamanca Campos, Maverick Magrigal Bryan, Estefani Valverde Marín
 * @version (24/11/2022)
 */
public class Fechas {

  /**
   * Método que permite generar un String con la fecha actual del sistema en
   * formato DD/MM/YYYY
   *
   * @return String
   */
  public static String getFecha() {
    Calendar fecha = Calendar.getInstance();
    String res = fecha.get(Calendar.DAY_OF_MONTH) + "/";

    if ((fecha.get(Calendar.MONTH) + 1) < 11) {
      res += "0" + (fecha.get(Calendar.MONTH) + 1) + "/";
    } else {
      res += (fecha.get(Calendar.MONTH) + 1) + "/";
    }

    res += fecha.get(Calendar.YEAR);
    return res;
  }

  /**
   * Método que permite generar un String a partir de un objeto Calendar.
   *
   * @param fecha Objeto Calendar
   * @return String
   */
  public static String formatearFecha(Calendar fecha) {
    String res = "";

    if ((fecha.get(Calendar.DAY_OF_MONTH)) < 10) {
      res += "0" + (fecha.get(Calendar.DAY_OF_MONTH)) + "/";
    } else {
      res += (fecha.get(Calendar.DAY_OF_MONTH)) + "/";
    }
    //Calendar fecha = Calendar.getInstance();

    if ((fecha.get(Calendar.MONTH) + 1) < 10) {
      res += "0" + (fecha.get(Calendar.MONTH) + 1) + "/";
    } else {
      res += (fecha.get(Calendar.MONTH) + 1) + "/";
    }

    res += fecha.get(Calendar.YEAR);
    return res;
  }

  /**
   * Método que permite dar un formato a una fecha con su hora.
   *
   * @param fecha Objeto Calendar
   * @return String
   */
  public static String darFormatoFecha(Calendar fecha) {
    SimpleDateFormat sdf = new SimpleDateFormat();
    return sdf.format(fecha.getTime());
  }

  /**
   * Método que permite generar un objeto Calendar a partir de una fecha con el
   * formato dd/MM/yyyy como entradas
   *
   * @param dia : Día del mes
   * @param mes : Mes del año
   * @param annio : Año a consultar
   * @return cal : objeto de tipo Calendar
   */
  public static Calendar darFormatoFecha(int dia, int mes, int annio) {
    if (dia < 1 || dia > 31) {
      System.out.println("Dia incorrecto");
      return null;
    } else if (mes < 1 || mes > 12) {
      System.out.println("Mes incorrecto");
      return null;
    } else if (annio < 1) {
      System.out.println("Año incorrecto");
      return null;
    } else {
      Calendar cal = Calendar.getInstance();
      cal.set(annio, mes - 1, dia);
      return cal;
    }
  }
  /**
   * 
   * @param fecha
   * @return El formato de la fecha
   */
  public static Calendar toCalendar(String fecha) {
    int dia = Integer.parseInt(fecha.substring(0, 2));
    int mes = Integer.parseInt(fecha.substring(3, 5));
    int anio = Integer.parseInt(fecha.substring(6));

    return darFormatoFecha(dia, mes, anio);
  }

  /**
   * Método que permite contar el total de dias entre dos objetos Calendar
   *
   * @param desde
   * @param hasta
   * @return int
   */
  public static int countOfDays(Calendar desde, Calendar hasta) {
    try {
      int res = 0;
      SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
      Date fechaInicio = date.parse(formatearFecha(desde));
      Date fechaactual = date.parse(formatearFecha(hasta));
      int milisecondsByDay = 86400000;
      res = (int) ((fechaactual.getTime() - fechaInicio.getTime()) / milisecondsByDay);
      return res;
    } catch (ParseException ex) {
      Logger.getLogger(Fechas.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
  }
}
