package org.orange.hrm.automation.constants;

import java.io.File;
import java.nio.file.Path;

public class GlobalConstants {

    /**
     * Description: Purpose of this class is to store Global Variables in the Project
     */
    public String chromeDriverPath = Path.of("driver","chrome","chromedriver.exe").toAbsolutePath().toString();
    public String edgeDriverPath = Path.of("driver","edge","msedgedriver.exe").toAbsolutePath().toString();
    public String appURLQA = "https://opensource-demo.orangehrmlive.com/";
    public String appURLProd = "https://opensource-demo.orangehrmlive.com/";
    public String userName = "admin";
    public String passWord = "admin123";
    public String orangeHRMTitle = "OrangeHRM";

    public String VERIFY_TEXT_EXACTMATCH = "EXACTMATCH";
    public String VERIFY_TEXT_EXACTMATCHIGNORECASE = "EXACTMATCHIGNORECASE";
    public String VERIFY_TEXT_PARTIAL = "PARTIAL";

    /*
    Uncomment a mode on which the browser should perform
     */
    // Headless Mode
    public String HeadlessMode = "--lang=en-GB;--headless;--disable-gpu;--window-size=1920,1080;";
    //HeadMode
    public String HeadMode = "--lang=en-GBlp-";

    public long SHORT_TIMEOUT = 2;
    public long MEDIUM_TIMEOUT = 8;
    public long LONG_TIMEOUT = 10;

}
