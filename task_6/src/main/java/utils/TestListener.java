package utils;

import com.codeborne.selenide.WebDriverRunner;
import com.google.common.io.BaseEncoding;
import com.google.common.io.Resources;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    private final Logger log = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test [" + result.getName() + "] start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (result.getMethod().getMethodName().equals("isSaveButtonDisabledWithEmptyFields")) {
            //saveScreenshot();
            String screenshot = getScreenshotResource();
            try {
                log.info(
                        "RP_MESSAGE#BASE64#{}#{}",
                        BaseEncoding.base64().encode(Resources.asByteSource(Resources.getResource(screenshot)).read()),
                        "on test success screenshot"
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test [" + result.getName() + "] failed");
        log.error(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) WebDriverRunner
                .getWebDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    "src/main/resources/"
                            +
                            "success_screenshot.png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getScreenshotResource() {
        return "success_screenshot.png";
    }
}