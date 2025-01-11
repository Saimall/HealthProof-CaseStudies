package batchjob;
import org.example.jobcsv.CsvBatchJob;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Testjob {
        @Test
        public void testProcessData() {
            CsvBatchJob job = new CsvBatchJob();


            String input = "John";
            String expected = "JOHN";
            assertEquals(expected, job.processData(input));


            input = null;
            expected = "";
            assertEquals(expected, job.processData(input));
        }
    }

