package se.doctrin.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.lang3.CharSet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;
import se.doctrin.base.TestBase;
import se.doctrin.pages.CareerPage;

public class CareerPageTest extends TestBase {
  
 
 String []arrNameTitleList;
 String employeeName;
 String employeeTitle;
 CareerPage careerPage;

 
@BeforeTest

@Parameters({"browser"})

public void setUp(String browser){
	
	initialization(browser);
	careerPage=new CareerPage();

}
 
 @Test
  public void getNameAndTitle() throws EncryptedDocumentException, IOException {
	
 //Click on More Worker Link 
	careerPage.clickElement(careerPage.moreCoWorkers);
	
 //Reterieving the names and title from the list 
	
   List<WebElement> allNamesTitle= careerPage.nameList.findElements(By.tagName("li")); 
	FileInputStream fis= new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\se\\doctrin\\testdata\\EmployeeDetails.xlsx"); 
    Workbook wbk= WorkbookFactory.create(fis);
    Sheet wSheet=wbk.getSheet("Sheet1");
   
   for(int i=0;i<=allNamesTitle.size()-1;i++){
	   
	   Row row = wSheet.createRow(i+1); //Creating the excel row
	  
			String names=allNamesTitle.get(i).getText();
		   
			//Splitting the names and title with new line character
			if(names.contains("\n")){
		   		arrNameTitleList=names.split("\n");
		   		employeeName=arrNameTitleList[0];
		   		Cell cell = row.createCell(0);
		   		cell.setCellValue(employeeName);
		   		employeeTitle=arrNameTitleList[1];
		   		Cell cell1=row.createCell(1);
		   		cell1.setCellValue(employeeTitle);
		   	}
		   	
		   	else{
		   		
		   		employeeName= arrNameTitleList[0];
		   		Cell cell = row.createCell(0);
		   		cell.setCellValue(employeeName);
		   		
		   		employeeTitle="no";
		   		Cell cell1=row.createCell(1);
		   		cell1.setCellValue(employeeTitle);
		   	}   
	
	   
	    
	    fis.close();
	    FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "\\src\\main\\java\\se\\doctrin\\testdata\\EmployeeDetails.xlsx");
	    wbk.write(fos);
		fos.close();
	    System.out.println(employeeName +" with "+ employeeTitle+" title displayed on site");
	        
   }
   
   
  
  }
  
 @AfterTest
 
 public void tearDown(){
	 
	 driver.quit();

}
  
}