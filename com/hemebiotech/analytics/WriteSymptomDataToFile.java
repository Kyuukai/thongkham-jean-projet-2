package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    public WriteSymptomDataToFile (String filepath) {
        this.filepath = filepath;
    }
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            FileWriter writer = new FileWriter (filepath);
            Iterator<String> iterator = symptoms.keySet().iterator();

                while (iterator.hasNext()) {

                    String symptom = iterator.next();
                    Integer symptomCount = symptoms.get(symptom);
                    String line = String.format("%s %d\n", symptom, symptomCount);

                    writer.write(line);
                }

                writer.close();

            } catch (IOException e) {
				e.printStackTrace();
        }
    }
}