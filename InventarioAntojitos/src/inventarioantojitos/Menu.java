/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioantojitos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**Menu
 *
 * @author José
 * @version 0.1
 */
public class Menu {
  Scanner teclado = new Scanner(System.in);
  
  /**Muestra el menu para que usuario lo esocoja 
   * 
   */
  public void menu() {
    System.out.println("\n1. Agregar Ingrediente");
    System.out.println("2. Eliminar Ingrediente");
    System.out.println("3. Mostrar Ingredientes");
    System.out.println("4. Guardar Ingredientes");
    System.out.println("5. Aumentar ingrediente");
    System.out.println("6. Salir");
  }
  
  public void menuModificar() {
    System.out.println("\n1. Modificar nombre");
    System.out.println("2. Modificar cantidad");
    System.out.println("3. Modificar precio");
    System.out.println("4. Modificar unidad de medida");
  }
  
  /**Lee la opcion escogida del menu
   * 
   * @return Regresa la opción que el usuario escogio 
   */
  public int leerOpcion() {
    System.out.println("\nIngrese la opcion deseada: ");
    return leerEntero();
  }
  
  /**Lee el nombre del ingrediente
   *
   * @return Regresa el nombre del ingrediente
   */
  public String leerNombre() {
    System.out.println("\nIngrese nombre del ingrediente: ");
    return leerCadena();
  }

  /**Lee la cantidad del ingrediente
   *
   * @return Regresa la cantidad que hay del ingrediente
   */
  public double leerCantidad() {
    System.out.println("\nIngrese la cantidad adquirida: ");
    return leerDouble();
  }
  
  /**Lee el precio del ingrediente
   *
   * @return Regresa el precio por kilogramo del ingrediente
   */
  public double leerPrecio() {
    System.out.println("\nIngrece precio: ");
    return leerDouble();
  }
  public String leerUnidad() {
    System.out.println("¿En que unidad de medida adquirio el articulo?"
            + "(ejemplo: kilogramos, piezas)");
    return leerCadena();
    
  }
  
  /**Confirmacion de que la opcion sea un entero
   *
   * @return Retorna la opcion en caso de que se valida
   */
  public int leerEntero() {
    int entero = 0;
    boolean bandera = false;
    do{
      try{
        entero = teclado.nextInt();
        bandera = true;
      }catch(InputMismatchException imme) {
        System.out.println("Por favor ingresa un entero");
        bandera = false;
        teclado.nextLine();   
      }
    }while(!bandera);
    return entero;
  }
  
  /**Confirmación que sea un double
   *
   * @return Retorna el valor que tiene cantidad en caso de ser valido
   */
  public double leerDouble() {
    double entero = 0;
    boolean bandera = false;
    do{
      try{
        entero = teclado.nextDouble();
        bandera = true;
      }catch(InputMismatchException imme) {
        System.out.println("Por favor ingresa un entero");
        bandera = false;
        teclado.nextLine();   
      }
    }while(!bandera);
    return entero;
  }
  
  public String leerCadena() {
    String cadena = " ";
    boolean bandera = false;
    do{
      cadena = teclado.next();
      bandera = true;
      if(esNumero(cadena)){
        System.out.println("\nPor faver ingrese un nombre con caracteres");
        bandera = false;
        cadena = teclado.nextLine();
      }
    }while(!bandera);
    return cadena;
  }
  
  /**Evalua si la cadena es de enteros
   *
   * @param cadena Cadena a evaluar
   * @return Regresa si la cadena no es un numero
   */
  public boolean esNumero(String cadena) {
    try{
      Long.parseLong(cadena);
    }catch(Exception e) {
      return false;
    }
    return true;
  }
  

}