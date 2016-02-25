/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioantojitos;
import java.io.*;
import java.util.ArrayList;

/**Aministracion del inventario
 *
 * @author José
 * @version 0.1
 */
public class Inventario {
  private ArrayList <Ingrediente> Inventario = new ArrayList();
  
  /**Agregar un nuevo ingrediente al inventario
   *
   * @param nuevoIngrediente El nuevo ingrediente que se registro
   */
  public void agregarNuevoIngrediente(Ingrediente nuevoIngrediente) {
      Inventario.add(nuevoIngrediente);
  }
  
  /**Muestra los ingredientes registrados en el inventario
   *
   */
  public void mostrarInventario() {
    for(Ingrediente temporal : Inventario) {
      System.out.print(temporal);
    }
  }
  
  /**Borra un ingrediente
   *
   * @param nombreIngrediente Busca el nombre del ingrediente para borrarlo
   */
  public void borrarIngrediente(String nombreIngrediente) {
    for(int i = 0; i <= Inventario.size(); i++) {
      Ingrediente temporal = Inventario.get(i);
      if(temporal.getNombre().equals(nombreIngrediente)) {
        Inventario.remove(i);
        System.out.println("Ingrediente "+ nombreIngrediente + " eliminado.");
      }
    }
  }
  
  /**Recupera el inventario (en caso de que exista)
   *
   */
  public void recuperarInventario() {
    try{
      FileInputStream entrada = new FileInputStream("Ingredientes.dat");
      ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);
      Inventario = (ArrayList) flujoEntrada.readObject();
      flujoEntrada.close();
      entrada.close();
      }catch(IOException ioe) {
        //ioe.printStackTrace();
        System.out.println("\nNo existe un inventario");
      }catch(ClassNotFoundException c) {
        //c.printStackTrace();
        System.out.println("\nEl archivo esta vacio");
      }
  }

  /**aunmenta la cantidad de los ingredientes y el precio
   *
   * @param nombreIngrediente
   */
  public void modificarIngrediente(String nombreIngrediente) {
        int i;
        Menu menu = new Menu();
        for(i=0; i < Inventario.size(); i++){
            Ingrediente temporal = Inventario.get(i);
            if(temporal.getNombre().equals(nombreIngrediente)) {
                double cantidad = menu.leerCantidad();
                double precio = menu.leerPrecio();
                String Unidad = temporal.getUnidad();
                cantidad=cantidad + temporal.getCantidad();
                precio=precio + temporal.getPrecio();
                Inventario.remove(i);
                Ingrediente ingrediente=new Ingrediente(nombreIngrediente, cantidad, precio, Unidad);
                Inventario.add(ingrediente);
                System.out.println("Ingrdiente "+ nombreIngrediente + " modificado");
                break;
            }
        }
        if(i==Inventario.size())
            System.out.println("No se encontró el ingrediente: " + nombreIngrediente);
    }
  
  /**Guarda el inventario para poder ser recuperado posteriormente
   *
   */
  public void guardarInventario() {
    try{
      FileOutputStream salida = new FileOutputStream("Ingredientes.dat");
      ObjectOutputStream flujoSalida = new ObjectOutputStream(salida);
      flujoSalida.writeObject(Inventario);
      salida.close();
      flujoSalida.close();
      }catch(IOException ioe) {
        System.out.println("\nEl inventario ha sido guardado");
      }
  }
  
 
}
