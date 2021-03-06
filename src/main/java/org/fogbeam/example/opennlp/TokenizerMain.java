
package org.fogbeam.example.opennlp;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

/**
 * Clase TokenizerMain
 * A partir de un fichero permite obtener los tokens que se encuentran en él.
 * @author marre
 *
 */
public class TokenizerMain {
	public final static String PATH = "inputs/file1.txt";
	private final static String PATH_TO_MODEL = "models/en-token.model";
	
	/**
	 * Obtiene los tokens del fichero en inglés del parámetro file
	 * @param file
	 */
	public static ArrayList<String> tokenize(String file) {
		try{
			InputStream modelInput = new FileInputStream(PATH_TO_MODEL);
			TokenizerModel model = new TokenizerModel(modelInput);
			Tokenizer tokenizer = new TokenizerME(model);
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line = "";
			ArrayList<String> result = new ArrayList<String>();
			while((line = buffer.readLine()) != null) {
				String[] tokens = tokenizer.tokenize(line);
				for(String token : tokens) {
					result.add(token);
					System.out.println("Token: " + token);
				}
			}
			modelInput.close();
			buffer.close();
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public static void main( String[] args ) throws Exception {
		tokenize(TokenizerMain.PATH);
	}
}
