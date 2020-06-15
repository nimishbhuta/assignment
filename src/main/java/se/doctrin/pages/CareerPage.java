package se.doctrin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import se.doctrin.base.TestBase;

public class CareerPage extends TestBase {
	
	@FindBy(xpath="//*[@id='top']/section[2]/div/div/ul")
	public WebElement nameList;
	@FindBy(xpath="//*[@id='section-people']/div/div/a/span")
	public WebElement moreCoWorkers;
	public CareerPage(){
		
		PageFactory.initElements(driver,this);
	}


	
	 public void clickElement(WebElement elementName){
		 elementName.click();	
		 //if (elementName.isDisplayed()){
			 
		// }
		 //else{
			// Reporter.log("The element does not exist");
		 //}
			
		 
	 }
	

}
