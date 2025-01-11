package org.example;

import org.example.jobcsv.CsvBatchJob;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CsvBatchJob job = new CsvBatchJob();


        if (args.length < 2) {
            System.out.println("Please provide both input and output file paths.");
            return;
        }


        String inputFilePath = args[0];
        String outputFilePath = args[1];

        // Run the batch job with the provided file paths
        try {
            job.processCsv(inputFilePath, outputFilePath);
        } catch (IOException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
    }
}