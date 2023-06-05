package com.hemebiotech.analytics;

import java.util.Map;

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