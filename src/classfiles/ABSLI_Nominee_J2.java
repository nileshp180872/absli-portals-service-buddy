package classfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ABSLI_Nominee_J2 {
	

	private static final long TimeOut = 15;
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
				
				muser = sheet.getRow(1).getCell(2);
				System.out.println(muser);
				mpass = sheet.getRow(0).getCell(1);
				System.out.println(mpass);		
		driver = new ChromeDriver();
		System.out.println(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("userID"))).sendKeys(muser.toString());
		driver.findElement(By.xpath(prop.getProperty("next"))).click();
		driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(mpass.toString());
		driver.findElement(By.xpath(prop.getProperty("Login"))).click();
		driver.findElement(By.xpath(prop.getProperty("myCustomer"))).click();
		driver.findElement(By.xpath(prop.getProperty("AllCustomer"))).click();
		driver.findElement(By.xpath(prop.getProperty("EDitCu"))).click();
		//driver.findElement(By.xpath(prop.getProperty("")))
	
	}
}
