package com.epam;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GoogleTest {

    final String GOOGLE_URL = "https://www.google.com/";

    @Test
    public void openGoogleSearchPage() {

        WebDriver driver = DriverSingleton.getDriver();
        driver.get(GOOGLE_URL);
        DriverSingleton.closeDriver();
    }
}
