package com.hemebiotech.analytics;

import java.util.*;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;

/**
 * Reads a chosen file, then writes the result in a chosen named file.
 */
public class AnalyticsCounter {
	private ISymptomWriter writer;
	private ISymptomReader reader;

	/**
	 * Constructor for the reader and writer
	 * @param reader
	 * @param writer
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public AnalyticsCounter() {

	}

	/**
	 * Gets a List of symptoms from a file
 	 * @return
	 */
	public List<String> getSymptoms() {
		return this.reader.getSymptoms();
    }

	/**
	 * Counts the frequency of symptoms from an existing List, then puts them in a Map with its symptom name and value
	 * @param symptoms
	 * @return
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> frequencyMap = new HashMap<>();

		for (String s: symptoms) {
			Integer count = frequencyMap.get(s);
			if (count ==null) {
				count = 0;
			}
			frequencyMap.put(s, count + 1);
		}

		return frequencyMap;
	}

	/**
	 * Sorts the Map in alphabetic order
	 * @param symptoms
	 * @return
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		return new TreeMap<>(symptoms);
	}

	/**
	 * Writes every symptom and its occurrences in a file
	 * @param symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}
}