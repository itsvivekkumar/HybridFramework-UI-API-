package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReport() {
        if (extent == null) {
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setReportName("Hybrid UI + API Automation Report");
            spark.config().setDocumentTitle("Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Framework", "Hybrid UI + API");
            extent.setSystemInfo("Author", "Vivek Kumar");
//            extent.setSystemInfo("OS", System.getProperty("os.name"));
//            extent.setSystemInfo("Java", System.getProperty("java.version"));
        }
        return extent;
    }
}

