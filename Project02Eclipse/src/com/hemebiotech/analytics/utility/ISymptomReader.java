package com.hemebiotech.analytics.utility;

import java.util.List;

import com.hemebiotech.analytics.entity.SymptomsSearched;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> GetSymptoms();
	
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms searched obtained from a data source, duplicates are not possible
	 */
	List<SymptomsSearched> GetSymptomsSearchedForCsv(String csvSeparator);
}
