package swaglabs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reportslog {

private static ExtentReports extent;

public static ExtentReports getReportInstance() {
    if (extent == null) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }
    return extent;

	}

}
