/**
 * 
 */
package es.ull.etsii.iaa.proyecto.fases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Clase que toma como entrada el corpus conjunto de todas las clases y genera
 * un archivo con el vocabulario, en orden alfab�tico, usado.
 * 
 * Se usa el siguiente formato para el archivo de salida:
 * 
 * Numero de palabras:<Número entero> Palabra:<cadena>
 * 
 * @author Juan Henández Hernández
 * @author Guillermo Rodríguez Pardo
 * 
 */
public class PVocabulario {
	private final TreeMap<String, Integer> vocabulario = new TreeMap<String, Integer>();

	public PVocabulario(String file) {
		FileReader fRead = null;
		BufferedReader bufRead = null;
		String line;
		String word;
		
		try {
			fRead = new FileReader(file);
			bufRead = new BufferedReader(fRead);

			while ((line = bufRead.readLine()) != null) {
				String[] words = line.split("[^a-zA-Z]+");
				for (int i = 0; i < words.length; ++i) {
					word = words[i].toLowerCase();
					if (word.length() > 1) {
						if (vocabulario.containsKey(word)) {
							vocabulario.put(word, vocabulario.get(word) + 1);
						} else {
							vocabulario.put(word, 1);
						}
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
			Iterator<Map.Entry<String, Integer>> it =
					vocabulario.entrySet().iterator();
			while(it.hasNext()) {
				Map.Entry<String, Integer> word = it.next();
				fWrite.write(word.getKey() + ": " + word.getValue() + "\n");
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
