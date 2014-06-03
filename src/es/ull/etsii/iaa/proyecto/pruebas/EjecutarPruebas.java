/**
 * 
 */
package es.ull.etsii.iaa.proyecto.pruebas;

import es.ull.etsii.iaa.proyecto.interfaz.VentanaPrincipal;

/**
 * Clase utilizada para realizar todas las pruebas necesarias
 * para los subprogramas generados.
 * 
 * @author Juan Hen�ndez Hern�ndez
 * @author Guillermo Rodr�guez Pardo
 *
 */
public class EjecutarPruebas {

   /**
    * @param args
    */
   public static void main(String[] args) {
      /*PCorpus programaCorpusPrueba = new PCorpus ();
      
      Vector<File> prueba = programaCorpusPrueba.searchFolder("doc/CorpusEntrenamiento/negativo/");
      
      for (int i = 0; i < prueba.size(); ++i) {
         try {
            System.out.println("Arch: " + i + "Nomb: " + prueba.get(i).getCanonicalPath());
         } catch (IOException e) {
            e.printStackTrace();
         }
      }*/
      
      new VentanaPrincipal();
	   
      System.out.println(" --- Fin de ejecucion --- ");
   }
}
