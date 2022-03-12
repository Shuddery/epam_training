package listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
    private Logger log = LogManager.getRootLogger();

    public void onTestStart(ITestResult iTestResult) {
        if (iTestResult.getMethod().getMethodName().contains("Blabla")) {
            log.info(iTestResult.getMethod().getMethodName() + " : 1");
        }
    }

    public void onTestSuccess(ITestResult iTestResult) { }

    public void onTestFailure(ITestResult iTestResult) {
        log.info(iTestResult.getMethod().getMethodName() + " : 2");
    }

    public void onTestSkipped(ITestResult iTestResult) { }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) { }

    public void onStart(ITestContext iTestContext) { }

    public void onFinish(ITestContext iTestContext) { }


}