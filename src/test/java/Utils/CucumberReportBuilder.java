package Utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CucumberReportBuilder {

    /**
     *
     * @param inputPath
     * @param outPutPath
     * @param projectName
     */
    public static void genrateCucumberReport(String inputPath, String outPutPath, String projectName){
        File json = new File(inputPath);
        if(json.exists()){
           Collection<File> jsonFiles = FileUtils.listFiles(new File(inputPath), new String[] {"json"}, true);
            final List<String> jsonPaths = new ArrayList<String>();
            jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));

            File reportOutputDir = new File(outPutPath);
            ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, setReportConfiguration(reportOutputDir,projectName));
            reportBuilder.generateReports();
        }

    }

    /**
     *
     * @param reportOutputDir
     * @param projectName
     * @return
     */
    private static Configuration setReportConfiguration(File reportOutputDir, String projectName) {
        Configuration config = new Configuration(reportOutputDir, projectName);
        config.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);

        return config;

    }
}
