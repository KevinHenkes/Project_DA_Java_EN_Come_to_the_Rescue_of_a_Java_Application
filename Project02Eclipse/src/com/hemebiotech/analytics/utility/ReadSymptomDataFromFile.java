package com.hemebiotech.analytics.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.entity.SymptomsSearched;

/**
 * Simple file reader
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		
		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
				String line;
				
				while ((line = reader.readLine()) !=  null) {
					result.add(line);
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		
		return result;
	}

	@Override
	public List<SymptomsSearched> GetSymptomsSearchedForCsv(String csvSeparator) {
		ArrayList<SymptomsSearched> result = new ArrayList<>();
		
		if (filepath != null) {
			try(BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
				String line;
				
				while ((line = reader.readLine()) !=  null) {
					String[] row = line.split(csvSeparator);
					
					// initialisation with symptom name and mode search
					SymptomsSearched symptomsSearched = new SymptomsSearched(row[0], row[1]);
							
					result.add(symptomsSearched);
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		
		return result;
	}
}
