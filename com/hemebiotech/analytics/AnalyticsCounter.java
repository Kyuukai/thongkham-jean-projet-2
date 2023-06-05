package com.hemebiotech.analytics;

import java.util.*;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;

public class AnalyticsCounter {
	private ISymptomWriter writer;
	private ISymptomReader reader;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public AnalyticsCounter() {

	}

    public List<String> getSymptoms() {
		return this.reader.getSymptoms();
    }

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

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		return new TreeMap<>(symptoms);
	}

    public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}
}