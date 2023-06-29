package org.api.constants;

import org.api.utils.CommonHelper;

import java.io.File;

/**
 * Represents Framework specific property/constant values.
 *
 * @author NVK PAVANKUMAR
 * @version 1.0
 */
public class FrameworkConstants {

    public static final String PROJECT_PATH = System.getProperty("user.dir");

    //Project input resources directory
    public static final String RESOURCE_DIR = PROJECT_PATH + "/src/main/resources/";
    public static final String DATASHEET_PATH = RESOURCE_DIR + "TestData.xlsx";
    public static final String CONFIGPROPERTY_PATH = RESOURCE_DIR + "config.properties";

    //Project output resources directory
    public static final String RESPONSE_LOG = PROJECT_PATH + "/logs/response.txt";
    public static final String REQUEST_LOG = PROJECT_PATH + "/logs/request.txt";
    public static final String SCREENSHOT_PATH = PROJECT_PATH + File.separator + "screenShots" + File.separator;

    // Extent reporting
    public static final String REPORT_DIR = PROJECT_PATH + File.separator + "reports" + File.separator;
    public static final String REPORT_PATH = REPORT_DIR + "Extent-TestReport.html";
    public static final String NEW_REPORT_PATH = REPORT_DIR + "Extent-TestReport-" + CommonHelper.getCurrentDateTime() + ".html";

    public static final String REPORT_TITLE = "Test Report";
    public static final String REPORT_NAME = "QA Test Report";
    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String TESTERNAME = "NVK PAVANKUMAR";

}
