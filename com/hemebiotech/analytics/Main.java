package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Reads the file "symptoms.txt", then writes the symptoms and its occurrences in a Map, which will get sorted then written in a file named "result.out"
 */
public class Main {

    public static void main(String args[]) {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);
        Map<String, Integer> symptoms = analytics.countSymptoms(analytics.getSymptoms());
        Map<String, Integer> sortedSymptoms = analytics.sortSymptoms(symptoms);
        analytics.writeSymptoms(sortedSymptoms);
    }
}