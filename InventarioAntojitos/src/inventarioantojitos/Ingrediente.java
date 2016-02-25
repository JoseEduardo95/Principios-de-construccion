 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioantojitos;
import java.io.Serializable;

/**Administrar ingredientes para posteriormente agregarlo al inventario
 *
 * @author José
 * @version 0.1
 */
public class Ingrediente implements Serializable {
  private String nombre;
  private double cantidad;
  private double precio;
  private String unidad;

  /**unidad de medida
   *
   * @return Obtiene la unidad de medida
   */
 
  public String getUnidad(){
    return unidad;
  }
  /**Asignación de la unidad
   *
   * @param unidad de compra del ingrediente
   */
   public void setUnidad(String unidad) {
    this.unidad = unidad;
  }
  

 

  /**Precio por kilograma
   *
   * @return Obtiene el precio por kilogramo
   */
  public double getPrecio() {
    return precio;
  }

  /**Asignación del precio
   *
   * @param precio Precio por kilo del ingrediente
   */
  public void setPrecio(double precio) {
    this.precio = precio;
  }

  /**Nombre del ingrediente
   *
   * @return Obtiene el nombre del ingrediente
   */
  public String getNombre() {
    return nombre;
  }

  /**Asignacion de nombre de ingrediente
   *
   * @param nombre Nombre con el que se registro en nombre
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**Cantidad del ingrediente
   *
   * @return Obtiene la cantidad que hay del ingrediente
   */
  public double getCantidad() {
    return cantidad;
  }

  /**Asignacion de la cantidad
   *
   * @param cantidad Cantidad existente del ingrediente
   */
  public void setCantidad(double cantidad) {
    this.cantidad = cantidad;
  }

  /**Creacion del objeto ingrediente
   *
   * @param nombre Nombre del ingrediente
   * @param cantidad Cantidad que hay del ingrediente
   * @param precio Precio por kilogramo
   * @param unidad de medida
   */  
  public Ingrediente(String nombre, double cantidad, double precio, 
          String unidad) {
    this.nombre = nombre;
    this.cantidad = cantidad;
    this.precio = precio;
    this.unidad = unidad;
  }
  
  @Override
  public String toString() {
    return "\nNombre: " + nombre + " Cantidad: " + cantidad + " " + unidad + 
            " Total: " +  precio + " Pesos mexicanos " + " \n";
  }
  
}

