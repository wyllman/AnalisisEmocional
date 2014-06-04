/**
 * 
 */
package es.ull.etsii.iaa.proyecto.fases;

import java.io.File;

/**
 * Clase que toma como entrada el archivo con el vocabulario
 * y los corpus de cada una de las clases para generar un archivo,
 * por cada una de las clases, con las estimaciones probabilísticas
 * de cada una de las palabras del vocabulario.
 * 
 * El archivo de salida tendrá la siguiente cabecera:
 * 
 * "Numero de documentos del corpus :<número entero>"
 * "Número de palabras del corpus:<número entero>"
 * 
 * Cada una de las palabras del vocabulario se guardarán
 * en el archivo de salida con el siguiente formato:
 * 
 * "Palabra:<cadena> Frec:<número entero> LogProb:<número real>"
 * 
 * @author Juan Henández Hernández
 * @author Guillermo Rodríguez Pardo
 *
 */
public class PAprendizaje {
	private File vocabulario;
	private File positiveCorpus;
	private File negativeCorpus;
	
	public PAprendizaje(String vocabulario, String posCorpus, String negCorpus) {
		this.vocabulario = new File(vocabulario);
		this.positiveCorpus = new File(posCorpus);
		this.negativeCorpus = new File(negCorpus);
		try {
			System.out.println(this.vocabulario.getPath());
			System.in.read();
		} catch (Exception e) {
			
		}
	}
}
