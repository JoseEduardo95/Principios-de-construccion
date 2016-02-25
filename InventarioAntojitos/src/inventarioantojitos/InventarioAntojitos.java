/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioantojitos;

/**Clase principal
 *
 * @author José
 * @version 0.1
 */
public class InventarioAntojitos {

  /**Main del programa
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    int opcion = 0;
    Inventario inventario = new Inventario();
    inventario.recuperarInventario();
    Menu menu = new Menu();
    System.out.println("\nBienvenido\n");
    do{
      menu.menu();
      opcion = menu.leerOpcion();
      switch(opcion) {
        case 1:
          String nombre = menu.leerNombre();
          double cantidad = menu.leerCantidad();
          String unidad = menu.leerUnidad();
          double precio = menu.leerPrecio();
          Ingrediente ingrediente = new Ingrediente(nombre, cantidad, precio, 
                  unidad);
          inventario.agregarNuevoIngrediente(ingrediente);
          break;
        case 2:
          System.out.println("El inventario contiene lo siguiente:");
          inventario.mostrarInventario();
          String nombreBorrar = menu.leerNombre();
          inventario.borrarIngrediente(nombreBorrar);
          break;
        case 3:
          inventario.mostrarInventario();
          break;
        case 4:
          inventario.guardarInventario();
          break;
        case 5:
          System.out.println("¿Que ingrediente quieres aumentar?");
                    nombre = menu.leerNombre();
                    inventario.modificarIngrediente(nombre);
                    break;
        case 6:
         System.out.println("\nGracias por usar el sistema.");
         break;
        default:
          System.out.println("\nIngrese una opción válida.");
          break;
    }  
    }while(opcion != 6);
    
    }
  }
 
