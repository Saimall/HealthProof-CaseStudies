package org.example.jobcsv;
import java.io.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CsvBatchJob {
    private static final Logger logger = LoggerFactory.getLogger(CsvBatchJob.class);


    public void processCsv(String inputFile, String outputFile) throws IOException {
        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);


        try {
            Reader reader = Files.newBufferedReader(inputPath);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());

            try  {
                BufferedWriter writer = Files.newBufferedWriter(outputPath);
                writer.write("ID,Name,ProcessedData\n");


                for (CSVRecord record : csvParser) {
                    //getting the data
                    String id = record.get("ID");
                    String name = record.get("Name");
                    String processedData = processData(name);
                    logger.info("Writing: {} , {} , {}", id, name, processedData);
                    //writing the data;
                    writer.write(id + "," + name + "," + processedData + "\n");
                }
                writer.flush();
                // above writer.flush() is important because it will flush the changes into new csv file without that it is not coming.
                logger.info("Data processing completed successfully.");
            } catch (IOException e) {
                logger.error("Error occured during writing the data in a file",e);
                throw e;
            }

        }catch (IOException e) {
            logger.error("Error occurred during file reading ", e);
            throw e;
        }
    }


    public String processData(String name) {
        if (name == null) return "";
        return name.toUpperCase();
        //converting name to upper . Optional function but i used to look more functional.
    }
}
