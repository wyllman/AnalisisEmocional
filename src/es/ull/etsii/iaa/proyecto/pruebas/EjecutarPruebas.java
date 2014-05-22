/**
 * 
 */
package es.ull.etsii.iaa.proyecto.pruebas;

import es.ull.etsii.iaa.proyecto.fases.PCorpus;

/**
 * Clase utilizada para realizar todas las pruebas necesarias
 * para los subprogramas generados.
 * 
 * @author Juan Hen‡ndez Hern‡ndez
 * @author Guillermo Rodr’guez Pardo
 *
 */
public class EjecutarPruebas {

   /**
    * @param args
    */
   public static void main(String[] args) {
      PCorpus programaCorpusPrueba = new PCorpus ();
      
      programaCorpusPrueba.buscarCarpeta(".");
      
      System.out.println(" --- Fin de ejecucion --- ");
   }
}
