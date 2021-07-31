package karate.example;


import Utils.CucumberReportBuilder;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRunner {

    private final static String JSON_REPORT_PATH = "target/cucumber/json-reports";
    private final static String PROJECT_NAME = "KARATE EXAMPLE";

    @AfterClass
    public static void tearDown(){
        CucumberReportBuilder.genrateCucumberReport(JSON_REPORT_PATH, JSON_REPORT_PATH, PROJECT_NAME);
    }

    @Test
    public void testParallel() {
        // Note: classpath is 'src/test/java'
        Results results = Runner.path("classpath:karate/example")
                .tags("@e2e")
                .outputCucumberJson(true)
                .reportDir(JSON_REPORT_PATH)
                .parallel(1);
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }


}
