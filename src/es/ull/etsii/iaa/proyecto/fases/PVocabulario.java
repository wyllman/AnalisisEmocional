/**
 * 
 */
package es.ull.etsii.iaa.proyecto.fases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Clase que toma como entrada el corpus conjunto de todas las clases y genera
 * un archivo con el vocabulario, en orden alfab�tico, usado.
 * 
 * Se usa el siguiente formato para el archivo de salida:
 * 
 * Numero de palabras:<N�mero entero> Palabra:<cadena>
 * 
 * @author Juan Hen�ndez Hern�ndez
 * @author Guillermo Rodr�guez Pardo
 * 
 */
public class PVocabulario {
	private final Hashtable<String, Integer> vocabulario = new Hashtable<String, Integer>();

	public PVocabulario(String file) {
		FileReader fRead = null;
		BufferedReader bufRead = null;
		String line;
		try {
			fRead = new FileReader(file);
			bufRead = new BufferedReader(fRead);

			while ((line = bufRead.readLine()) != null) {
				String[] words = line.split(" ");
				for (int i = 0; i < words.length; ++i) {
					if (vocabulario.containsKey(words[i])) {
						vocabulario.put(words[i], vocabulario.get(words[i]) + 1);
					} else {
						vocabulario.put(words[i], 1);
					}
				}
			}

		} catch (Exception e) {

		} finally {
			try {
				if (fRead != null) {
					fRead.close();
				}
				if (bufRead != null) {
					bufRead.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void dumpToFile(String fileName) {
		FileWriter fWrite = null;
		try {
			fWrite = new FileWriter(fileName);
			Enumeration<Integer> elements = vocabulario.elements();
			while(elements.hasMoreElements()) {
				fWrite.write(elements.nextElement());
			}
		} catch (Exception e) {
			
		} finally {
			try {
				if(fWrite != null) {
					fWrite.close();
				}
			} catch (Exception e) {
				
			}
		}
	}
}
