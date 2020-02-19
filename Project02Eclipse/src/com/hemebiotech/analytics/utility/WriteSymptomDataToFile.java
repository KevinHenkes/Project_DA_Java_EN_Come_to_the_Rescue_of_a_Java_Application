package com.hemebiotech.analytics.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.hemebiotech.analytics.entity.SymptomsSearched;

/**
 * Simple file writter
 *
 */
public class WriteSymptomDataToFile implements ISymptomWritter {
	
	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void WriteResultsToFile(List<SymptomsSearched> symptomsSearched) {
		try(FileWriter writer = new FileWriter(filepath)) {
			for (SymptomsSearched symptom : symptomsSearched) {
				// Write into output file occurrences for each symptom searched
			    writer.write(symptom.getName() + ": " + symptom.getOccurrences() + "\n");
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}	
	}

}
