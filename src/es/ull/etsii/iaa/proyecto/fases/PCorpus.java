/**
 * PCorpus.java
 */
package es.ull.etsii.iaa.proyecto.fases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.regex.Pattern;

/**
 * Clase encargada de unificar todos los documentos pertenecientes al corpus de
 * una clase concreta en un solo archivo, con el siguiente formato por documento
 * unificado:
 * 
 * "Texto:<cadena con texto del fichero>"
 * 
 * Funcionalidad añadida: Crear un archivo unificando los corpus de cada una de
 * las clases del problema (negativo - positivo).
 * 
 * @author Juan Henández Hernández
 * @author Guillermo Rodríguez Pardo
 */

public class PCorpus {
	public enum T_Ejecution {
		C_SIMPLE, C_ALL
	};

	private Vector<File> fileVector = new Vector<File>();;
	private File corporaDirectory;
	private File fullCorpus;
	private File positiveCorpus;
	private File negativeCorpus;

	public File getFullCorpus() {
		return fullCorpus;
	}

	public File getPositiveCorpus() {
		return positiveCorpus;
	}

	public File getNegativeCorpus() {
		return negativeCorpus;
	}

	public File getCorporaDirectory() {
		return corporaDirectory;
	}

	public void setCorporaDirectory(File corporaDirectory) throws IOException {
		if (corporaDirectory.isDirectory()) {
			this.corporaDirectory = corporaDirectory;
		} else {
			throw new IOException("No es un directorio.");
		}
	}
	
	public PCorpus(String destinationDir) {
		corporaDirectory = new File(destinationDir);
		fullCorpus = new File(corporaDirectory + "/corpustodo.txt");
		positiveCorpus = new File(corporaDirectory + "/corpuspos.txt");
		negativeCorpus = new File(corporaDirectory + "/corpusneg.txt");
	}

	/**
	 * Recibe un directorio y añade todos los archivos txt que contiene al
	 * vector de archivos.
	 * 
	 * @param folderName
	 * @return
	 */
	public Vector<File> searchFolder(String folderName) {
		File folderTmp = new File(folderName);
		Pattern regExp = Pattern.compile(".*\\.txt$");
		boolean encontrado = false;
		
		if (folderTmp.exists() && folderTmp.isDirectory()) {			
			for (String file : folderTmp.list()) {
				if (regExp.matcher(file).matches()) {
					fileVector.add(new File(folderName + "/" + file.toString()));
					encontrado = true;
				}
			}
			if (!encontrado) {
				System.out.println(" Ningún archivo .txt");
			}
		} else {
			System.out.println(" --- + ERROR. La carpeta indicada no existe " +
					"o no es un directorio.");
			System.out.println(" --- +++++++ Clase: PCorpus Fucion: public "
					+ "Vector<File> buscarCarpeta (String nombreCarpeta)");
		}
		return fileVector;
	}

	public int createCorpora() {
		FileReader inputFile = null;
		FileWriter outputFile = null;
		FileWriter posOutputFile = null;
		FileWriter negOutputFile = null;
		BufferedReader buffReader = null;
		Pattern positiveRE = Pattern.compile(".*pos.*");
		Pattern negativeRE = Pattern.compile(".*neg.*");
		String line;

		try {
			outputFile = new FileWriter(fullCorpus);
			posOutputFile = new FileWriter(positiveCorpus);
			negOutputFile = new FileWriter(negativeCorpus);
			for (File file : fileVector) {
				inputFile = new FileReader(file);
				buffReader = new BufferedReader(inputFile);
				while ((line = buffReader.readLine()) != null) {
					outputFile.write(line);
					if (positiveRE.matcher(file.toString()).matches()) {
						posOutputFile.write(line);
					} else if (negativeRE.matcher(file.toString()).matches()) {
						negOutputFile.write(line);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputFile != null) {
					inputFile.close();
				}
				if (outputFile != null) {
					outputFile.close();
				}
				if (buffReader != null) {
					buffReader.close();
				}
				if (posOutputFile != null) {
					posOutputFile.close();
				}
				if (negOutputFile != null) {
					negOutputFile.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return 1;
	}
}
