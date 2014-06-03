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

	private Vector<File> result;
	private String fullCorpus;

	/**
	 * Recibe un directorio y añade todos los archivos txt que contiene al
	 * vector de archivos.
	 * 
	 * @param folderName
	 * @return
	 */
	public Vector<File> searchFolder(String folderName) {
		File folderTmp = new File(folderName);
		result = new Vector<File>();
		Pattern regExp = Pattern.compile(".*\\.txt$");
		Matcher matching;
		boolean encontrado = false;
		File archivoTmp;

		if (folderTmp.exists()) {
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
				System.out.println(" Ningún archivo .txt");
			}
		} else {
			System.out.println(" --- + ERROR. La carpeta indicada no existe.");
			System.out.println(" --- +++++++ Clase: PCorpus Fucion: public "
					+ "Vector<File> buscarCarpeta (String nombreCarpeta)");
		}
		return result;
	}

	public void addFile(File inFile, FileWriter outFile) {
		FileReader fileReader = null;
		BufferedReader buffReader = null;
		PrintWriter printWriter = null;
		String line;

		try {
			fileReader = new FileReader(inFile);
			buffReader = new BufferedReader(fileReader);
			printWriter = new PrintWriter(outFile);

			if ((line = buffReader.readLine()) != null) {
				System.out.println(line);
				printWriter.println("Texto: " + line);

				while ((line = buffReader.readLine()) != null) {
					System.out.println(line);
					printWriter.println(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fileReader) {
					fileReader.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void addFolderFiles(Vector<File> filesGroup, String nameOutFile) {
		FileWriter outFile = null;
		try {
			outFile = new FileWriter(nameOutFile);
			for (int i = 0; i < filesGroup.size(); ++i) {
				addFile(filesGroup.get(i), outFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != outFile) {
					outFile.close();
				}
				filesGroup.removeAllElements();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void createCorpus(String output) {
		FileReader inputFile = null;
		FileWriter outputFile = null;
		BufferedReader buffReader = null;
		PrintWriter writer = null;
		String line;

		fullCorpus = output;

		try {
			outputFile = new FileWriter(output);
			for (File file : result) {
				System.out.println(file.toString());
				inputFile = new FileReader(file);
				buffReader = new BufferedReader(inputFile);
				while ((line = buffReader.readLine()) != null) {
					outputFile.write(line);
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
