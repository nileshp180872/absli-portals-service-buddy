package classfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.formula.functions.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class ABSLI_Login {
	
	private static final long TimeOut = 15;
	XSSFCell muser;
	XSSFCell mpass;
	WebDriver driver;
	Properties prop = new Properties();
	@Test
	public void Login() throws IOException, InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\ABLSI_SB\\absli-portals-service-buddy\\JARS\\ChromeDriver\\chromedriver.exe");
		//FileInputStream ip = new FileInputStream("D:\\ABLSI_SB\\absli-portals-service-buddy\\src\\propertyfiles\\AB.Login_Properties");
		//FileInputStream fs = new FileInputStream("D:\\ABLSI_SB\\absli-portals-service-buddy\\src\\datafiles\\AB_Login_Data.xlsx");

		System.setProperty("webdriver.chrome.driver", "E:\\ABSLI_SELENIUM\\SERVICE_BUDDY\\JARS\\ChromeDriver\\chromedriver.exe");
		FileInputStream ip = new FileInputStream("E:\\ABSLI_SELENIUM\\SERVICE_BUDDY\\src\\propertyfiles\\AB.Login_Properties");
		FileInputStream fs = new FileInputStream("E:\\ABSLI_SELENIUM\\SERVICE_BUDDY\\src\\datafiles\\AB_Login_Data.xlsx");
		
		//Creating a workbook
		//System.setProperty("webdriver.chrome.driver", "D:\\ABLSI_SB\\absli-portals-service-buddy\\JARS\\ChromeDriver\\chromedriver.exe");
		//FileInputStream ip = new FileInputStream("D:\\ABLSI_SB\\absli-portals-service-buddy\\src\\propertyfiles\\AB.Login_Properties");
		prop.load(ip);
		// TODO Auto-generated method stub
				//Path of the excel file
				//FileInputStream fs = new FileInputStream("D:\\ABLSI_SB\\absli-portals-service-buddy\\src\\datafiles\\AB_Login_Data.xlsx");
				//Creating a workbook
//>>>>>>> branch 'Dev' of https://gitlab.com/nileshp180872/absli-portals-service-buddy.git
				XSSFWorkbook workbook = new XSSFWorkbook(fs);
				XSSFSheet sheet = workbook.getSheetAt(0);
				//System.out.println(workbook.getSheetAt(0));
				XSSFRow row = sheet.getRow(0);
				XSSFCell cell = row.getCell(0);
				
				//System.out.print(sheet.getRow(0).getCell(0));
				//System.out.print("      ");
				//System.out.println(sheet.getRow(0).getCell(1));
				//System.out.println(sheet.getRow(1).getCell(1));
				//System.out.println(sheet.getRow(0));
				//System.out.println(muser);
				
				muser = sheet.getRow(1).getCell(1);
				mpass = sheet.getRow(0).getCell(1);
						
		
		driver = new ChromeDriver();
		System.out.println(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("userID"))).sendKeys(muser.toString());
		driver.findElement(By.xpath(prop.getProperty("next"))).click();
		driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(mpass.toString());
		driver.findElement(By.xpath(prop.getProperty("Login"))).click();
		String confirmMessage = driver.findElement(By.xpath(prop.getProperty("DashboardText"))).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Dashboard"));
		//driver.quit();
		
		
	}

}
