package classfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BetaLogin3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Path of the excel file
		FileInputStream fs = new FileInputStream("C:\\JARS\\DataFiles\\TestingData.xlsx");
		
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		System.out.println(workbook.getSheetAt(0));
		//Row row = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		
		//System.out.println(sheet.getRow(0).getCell(0));
		//System.out.println(sheet.getRow(0).getCell(1));
		//System.out.println(sheet.getRow(0).getCell(2));
		
		//Row row1 = sheet.getRow(1);
		//Cell cell1 = row1.getCell(1);
		//System.out.println(sheet.getRow(0).getCell(1));
		//Row row2 = sheet.getRow(1);
		//Cell cell2 = row2.getCell(1);
		//System.out.println(sheet.getRow(1).getCell(0));
		//Row row3 = sheet.getRow(1);
		//Cell cell3 = row3.getCell(1);
		//System.out.println(sheet.getRow(1).getCell(1));
		//String cellval = cell.getStringCellValue();
		//System.out.println(cellval);
		
		 Object arr[][]= new Object[6][2];
			
			for(int i=0; i< 6; i++){
				for(int j=0; j< 2; j++){
					
					arr[i][j]=sheet.getRow(i).getCell(j);
					
					System.out.print(arr[i][j]+"                ");
				}
				System.out.println("");
			}
		
		
		 System.setProperty("webdriver.chrome.driver","C:\\JARS\\ChromeDriver\\chromedriver.exe");
		    //WebDriver driver = new ChromeDriver();
			//driver.manage().window().maximize();
			
			//define file path in Java class
			FileInputStream fi = new FileInputStream("C:\\JARS\\PropertyFiles\\MyPropertiesFile.Properties");
			Properties storage = new Properties();
			//load the propertiesfile
			storage.load(fi);
			
			
			//driver.get(storage.getProperty("ClientURL"));
			
			for(int i=1; i< 6; i++){
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(storage.getProperty("ClientURL"));
				Thread.sleep(5000);
			        //driver.get(storage.getProperty("ClientURL"));
			        Thread.sleep(5000); 
			        driver.findElement(By.xpath(storage.getProperty("UserEmail"))).sendKeys(arr[i][0].toString());
			        driver.findElement(By.xpath(storage.getProperty("UserPS"))).sendKeys(arr[i][1].toString());
			        Thread.sleep(5000);  
			        driver.findElement(By.xpath(storage.getProperty("LoginBtn"))).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath(storage.getProperty("img"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(storage.getProperty("LogoutBtn"))).click();
			Thread.sleep(10000);
			driver.close();
			}
	
	}

}
