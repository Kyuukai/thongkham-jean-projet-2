package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

// WRITE YOUR CODE HERE
public class WriteSymptomDataToFile implements ISymptomWriter {

    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {

            Iterator<String> iterator = symptoms.keySet().iterator();

                while (iterator.hasNext()) {

                    String key = iterator.next();
                    FileWriter writer = new FileWriter ("result.out");
                } 
            } catch (IOException e) {
				e.printStackTrace();
			}
        }
}