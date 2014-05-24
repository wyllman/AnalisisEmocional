/**
 * PCorpus.java
 */
package es.ull.etsii.iaa.proyecto.fases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
   public enum T_Ejecution {C_SIMPLE, C_ALL };	

   public Vector<File> searchFolder (String folderName) {
      File folderTmp = new File (folderName);
      Vector<File> result = new Vector<File> ();
      Pattern regExp = Pattern.compile(".*\\.txt$"); // Se usa para buscar los archivos que acaben con ".txt"
      Matcher matching;
      boolean encontrado = false;
      File archivoTmp;
      
      if (folderTmp.exists()){ 
         String[] resultadoC = folderTmp.list();
         int tamanio = resultadoC.length;
         
         for (int i = 0; i < tamanio; ++i) {
           matching = regExp.matcher(resultadoC[i]);
           if (matching.matches()) {
              archivoTmp = new File(resultadoC[i]);
              result.add(archivoTmp);
              encontrado = true;
           }
         }
         if (!encontrado) {
            System.out.println(" Ningœn archivo .txt");
         }
      } else { 
         System.out.println(" --- + ERROR. La carpeta indicada no existe.");
         System.out.println(" --- +++++++ Clase: PCorpus Fucion: public " 
                              + "Vector<File> buscarCarpeta (String nombreCarpeta)");
      }
      return result;
   }
   
   public void addFile (File inFile, FileWriter outFile) {
      FileReader fileRe = null;
      BufferedReader buffRe = null;
      
      //FileWriter fileWr = null;
      PrintWriter printWr = null;
 
      try {
         fileRe = new FileReader (inFile);
         buffRe = new BufferedReader (fileRe);
         
         //fileWr = new FileWriter (outFile);
         printWr = new PrintWriter (outFile);

         String line;
         if ((line = buffRe.readLine()) != null) {
            System.out.println (line);
            printWr.println ("Texto: " + line);
            
            while ((line = buffRe.readLine()) != null) {
               System.out.println (line);
               printWr.println (line);
            }
            
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {                   
            if (null != fileRe) {  
               fileRe.close();    
            }                 
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
   }
   
   public void addFolderFiles (Vector<File> filesGroup, String nameOutFile) {
      FileWriter outFile = null;
      try {
         outFile = new FileWriter (nameOutFile);
         for (int i = 0; i < filesGroup.size(); ++i) {
           addFile (filesGroup.get(i), outFile);
         }
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         try {
            if (null != outFile) {
               outFile.close ();
            }
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
   }
}
