package com.hemebiotech.analytics;

import java.util.List;

import com.hemebiotech.analytics.entity.SymptomsSearched;
import com.hemebiotech.analytics.utility.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.utility.WriteSymptomDataToFile;

/**
 * Counts the symptoms of patients.
 *
 */
public class AnalyticsCounter {
	public static void main(String args[]) {
		final String PATH_INPUT_DATA = "symptoms.txt";
		final String PATH_SYMTPOMS_SEARCHED = "symptoms_searched.csv";
		final String PATH_OUTPUT = "result.out";
		final String CSV_SEPARATOR = ";";
		final String MODE_SEARCH_EQUAL = "equal";
		final String MODE_SEARCH_LIKE = "like";
		
		
		List<String> symptomsData = new ReadSymptomDataFromFile(PATH_INPUT_DATA).GetSymptoms();
		List<SymptomsSearched> symptomsSearched = new ReadSymptomDataFromFile(PATH_SYMTPOMS_SEARCHED).GetSymptomsSearchedForCsv(CSV_SEPARATOR);
		
		for (int i = 0; i < symptomsData.size(); i++) {
			System.out.println("symptom from file: " + i);
			
			for(SymptomsSearched symptom : symptomsSearched) {
				String modeSearch = symptom.getModeSearch();
				
				// Process comparison according to mode search
				if (modeSearch.equals(MODE_SEARCH_EQUAL)) {
					if(symptomsData.get(i).equals(symptom.getName())) {
						incrementAndPrintActualSymptom(symptom);
					}
				} else if(modeSearch.equals(MODE_SEARCH_LIKE)) {
					if (symptomsData.get(i).contains(symptom.getName())) {
						incrementAndPrintActualSymptom(symptom);
					}
				} else {
					System.err.println("Mode search not found for symptom searched: " + symptom.getName());
				}
			}
		}
		
		new WriteSymptomDataToFile(PATH_OUTPUT).WriteResultsToFile(symptomsSearched);
	}
	
	public static void incrementAndPrintActualSymptom(SymptomsSearched symptom) {
		symptom.incrementOccurrences();
		System.out.println("number of " + symptom.getName() + ": " + symptom.getOccurrences());
	}
}
