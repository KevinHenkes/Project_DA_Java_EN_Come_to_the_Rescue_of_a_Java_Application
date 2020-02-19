package com.hemebiotech.analytics.utility;

import java.util.List;

import com.hemebiotech.analytics.entity.SymptomsSearched;

public interface ISymptomWritter {
	/**
	 * Write the results of symptoms searched occurrences into a file
	 */
	void WriteResultsToFile(List<SymptomsSearched> symptomsSearched);
}
