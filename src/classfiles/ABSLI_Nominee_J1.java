package classfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.google.common.io.Files;

public class ABSLI_Nominee_J1 {
	
	private static final long TimeOut = 150;
	XSSFCell muser;
	XSSFCell mpass;
	WebDriver driver;
	Properties prop = new Properties();
	@Test
	public void Login() throws IOException, InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\JARS\\ChromeDriver\\chromedriver.exe");
		FileInputStream ip = new FileInputStream("C:\\JARS\\PropertyFiles\\AB.Login_Properties");
		FileInputStream fs = new FileInputStream("C:\\JARS\\DataFiles\\AB_Login_Data.xlsx");
		
		//System.setProperty("webdriver.chrome.driver", "D:\\ABLSI_SB\\absli-portals-service-buddy\\JARS\\ChromeDriver\\chromedriver.exe");
		//FileInputStream ip = new FileInputStream("D:\\ABLSI_SB\\absli-portals-service-buddy\\src\\propertyfiles\\AB.Login_Properties");
		prop.load(ip);
		//FileInputStream fs = new FileInputStream("D:\\ABLSI_SB\\absli-portals-service-buddy\\src\\datafiles\\AB_Login_Data.xlsx");
				
				XSSFWorkbook workbook = new XSSFWorkbook(fs);
				XSSFSheet sheet = workbook.getSheetAt(0);
				
				XSSFRow row = sheet.getRow(0);
				XSSFCell cell = row.getCell(0);
				
				muser = sheet.getRow(1).getCell(1);
				mpass = sheet.getRow(0).getCell(1);
							
		driver = new ChromeDriver();
		System.out.println(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("userID"))).sendKeys(muser.toString());
		driver.findElement(By.xpath(prop.getProperty("next"))).click();
		driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(mpass.toString());
		driver.findElement(By.xpath(prop.getProperty("Login"))).click();
		//java.io.File f3=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  //Files.copy(f3, new java.io.File(".\\ScreenShot\\searchMobilenumber.png"));
		driver.findElement(By.xpath(prop.getProperty("TotalActiveNOP"))).click();
		driver.findElement(By.xpath(prop.getProperty("Customername"))).click();
		driver.findElement(By.xpath(prop.getProperty("Policy"))).click();
		driver.findElement(By.xpath(prop.getProperty("PolicyAerrow"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("policySourcedByYou"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("ViewMore"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("GotoPolicyDetails"))).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("MoreDetails"))).click();
		
		 
		//Thread.sleep(20000);
		driver.quit();
		
		
		
		
		
		
	}

}
