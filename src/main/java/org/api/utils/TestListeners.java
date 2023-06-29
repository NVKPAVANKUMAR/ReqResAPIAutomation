package org.api.utils;

import com.aventstack.extentreports.Status;
import lombok.SneakyThrows;
import org.api.reporting.ExtentManager;
import org.api.reporting.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;

import static org.api.reporting.ExtentTestManager.getTest;


public class TestListeners implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @SneakyThrows
    @Override
    public void onFinish(ITestContext result) {
        Log.info("I am in onFinish method " + result.getName());
        ExtentManager.getInstance().flush();
        File htmlFile = new File(ExtentManager.getReportPath());
        Desktop.getDesktop().browse(htmlFile.toURI());
    }

    @Override
    public void onStart(ITestContext result) {
        Log.info("I am in onStart method " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info(getTestMethodName(result) + " test is failed.");
        getTest().log(Status.FAIL,
                "<b> TEST CLASS :" + result.getInstanceName() +
                        "<br /> TEST METHOD : " + result.getName() +
                        "<br /> STATUS : <font color=red> FAILED" +
                        "<br /> ERROR : </b>" + result.getThrowable().toString());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getTest().log(Status.SKIP, result.getInstanceName() + " : " + result.getName().replace("_", " ") + " -- SKIPPED");
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info(getTestMethodName(result) + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().log(Status.PASS, "<b> TEST CLASS :" + result.getInstanceName() +
                "<br /> TEST METHOD : " + result.getName() +
                "<br /> STATUS : <font color=green> PASSED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
