package se.doctrin.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestNGListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test Case " +  result.getName() + "has Started");
		Reporter.log("Test Case " +  result.getName() + "has Started");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Case " +  result.getName() + "is Passed");
		Reporter.log("Test Case " +  result.getName() + "is Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Test Case " +  result.getName() + "is Failed");
		Reporter.log("Test Case " +  result.getName() + "is Failed");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		//System.out.println("Test Suite " +  context.getSuite().getName() + " has started");
		//Reporter.log("Test Suite " +  context.getSuite().getName() + " has started on" + context.getStartDate()	);
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		//System.out.println("Test Suite " +  context.getName() + " has ended");
		//Reporter.log("Test Suite " +  context.getName() + " has ended");
		
	}
	
	
	

}
