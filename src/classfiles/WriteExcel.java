package classfiles;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path = "E:\\ABSLI_SELENIUM\\SERVICE_BUDDY\\src\\datafiles\\KeywordData.xlsx";
		FileInputStream fs = new FileInputStream(path);
		
				
		Workbook wb = new XSSFWorkbook(fs);
		Sheet sheet1 = wb.getSheetAt(0);
		int lastRow = sheet1.getLastRowNum();
		for(int i=1; i<=lastRow; i++)
		{
			  Cell chk = sheet1.getRow(i).getCell(2);
			  System.out.println(chk.toString());
		      Row row = sheet1.getRow(i);
		      Cell cell = row.createCell(3);
		      
		      if(chk.toString() == "Y" ) {
     		  cell.setCellValue("Pass");
     	} else 
     	{
     		cell.setCellValue("Fail");
     	}
     	}
		      

		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
	}

}
