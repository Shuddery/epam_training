package com.epam;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import service.TestDataReader;

public class EnvironmentTest {

    private final static String TESTDATA_SEARCH = "testdata.search";

    @Test
    public void openSearchPageTest() {

        WebDriver driver = DriverSingleton.getDriver();
        driver.get(TestDataReader.getTestData(TESTDATA_SEARCH));
        DriverSingleton.closeDriver();
    }
}
