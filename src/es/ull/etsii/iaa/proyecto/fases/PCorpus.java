/**
 * PCorpus.java
 */
package es.ull.etsii.iaa.proyecto.fases;

import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.security.util.Length;

/**
 * Clase encargada de unificar todos los documentos pertenecientes 
 * al corpus de una clase concreta en un solo archivo, con el 
 * siguiente formato por documento unificado:
 * 
 * "Texto:<cadena con texto del fichero>"
 * 
 * Funcionalidad a–adida: Crear un archivo unificando los corpus
 * de cada una de las clases del problema (negativo - positivo).
 * 
 * @author Juan Hen‡ndez Hern‡ndez
 * @author Guillermo Rodr’guez Pardo
 */

public class PCorpus {
   public enum T_Ejecucion {C_SIMPLE, C_TODO };	

   public Vector<File> buscarCarpeta (String nombreCarpeta) {
      // TODO:
      File carpetaCont = new File (nombreCarpeta);
      Vector<File> resultado = new Vector<File> ();
      Pattern patron = Pattern.compile(".*\\.txt$");
      Matcher mat;// = pat.matcher(cadena);
      boolean encontrado = false;
      
      if (carpetaCont.exists()){ 
         System.out.println("La carpeta seleccionada es: " + carpetaCont.getName());
         System.out.println("La carpeta seleccionada es: " + carpetaCont.getAbsolutePath());
         System.out.println("La carpeta seleccionada es: " + carpetaCont.isDirectory());
         try {
            System.out.println("La carpeta seleccionada es: " + carpetaCont.getCanonicalPath());
         } catch (IOException e) {
            e.printStackTrace();
         }
         System.out.println("La carpeta seleccionada es: " + carpetaCont.getParent());
         String[] resultadoC = carpetaCont.list();
         int tamanio = resultadoC.length;
         for (int i = 0; i < tamanio; ++i) {
           mat = patron.matcher(resultadoC[i]);
           if (mat.matches()) {
              System.out.println(resultadoC[i]);
              encontrado = true;
           }
            //System.out.println(resultadoC[i]);
         }
         if (!encontrado) {
            System.out.println(" Ningœn archivo .txt");
         }
      } else { 
         System.out.println(" --- + ERROR. La carpeta indicada no existe.");
         System.out.println(" --- +++++++ Clase: PCorpus Fucion: public " 
                              + "Vector<File> buscarCarpeta (String nombreCarpeta)");
      }

      return resultado;
   }
   
   public void unificarArchivos () {
      // TODO:
   }
}
