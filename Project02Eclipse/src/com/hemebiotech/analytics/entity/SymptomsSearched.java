package com.hemebiotech.analytics.entity;

/**
 * Object who contains the attribute of a symptom searched
 *
 */
public class SymptomsSearched {
	private String name;
	private String modeSearch;
	private Integer occurrences;
	
	/**
	 * Initilisation of a symptom searched
	 * 
	 * @param name
	 * @param modeSearch
	 */
	public SymptomsSearched(String name, String modeSearch) {
		this.name = name;
		this.modeSearch = modeSearch;
		this.occurrences = 0;
	}

	/**
	 * 
	 * @return a name of symptom
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set a name of symptom
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return a mode search for find how process the comparison
	 */
	public String getModeSearch() {
		return modeSearch;
	}

	/**
	 * Set a mode search for find how process the comparison
	 * 
	 * @param modeSearch
	 */
	public void setModeSearch(String modeSearch) {
		this.modeSearch = modeSearch;
	}

	/**
	 * 
	 * @return number of occurrences of a symptom
	 */
	public Integer getOccurrences() {
		return occurrences;
	}
	
	/**
	 * Set number of occurrences of a symptom
	 * @param occurrences
	 */
	public void setOccurrences(Integer occurrences) {
		this.occurrences = occurrences;
	}

	/**
	 * Increment number of occurrences of a symptom
	 */
	public void incrementOccurrences() {
		occurrences++;
	}

	@Override
	public String toString() {
		return "SymptomsSearched [name=" + name + ", modeSearch=" + modeSearch + ", occurrences=" + occurrences + "]";
	}


	
	
}
