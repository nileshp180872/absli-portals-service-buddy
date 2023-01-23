package classfiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.Table.Cell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Path of the excel file
		FileInputStream fs = new FileInputStream("C:\\JARS\\DataFiles\\TestingData.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		System.out.println(workbook.getSheetAt(0));
		//Row row = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		/*
		System.out.print(sheet.getRow(0).getCell(0));
		System.out.print("      ");
		System.out.println(sheet.getRow(0).getCell(1));
		
		
		System.out.print(sheet.getRow(1).getCell(0));
		System.out.print("      ");
		System.out.println(sheet.getRow(1).getCell(1));
		
		System.out.print(sheet.getRow(2).getCell(0));
		System.out.print("      ");
		System.out.println(sheet.getRow(2).getCell(1));
		
		System.out.print(sheet.getRow(3).getCell(0));
		System.out.print("      ");
		System.out.println(sheet.getRow(3).getCell(1));
		
		System.out.print(sheet.getRow(4).getCell(0));
		System.out.print("      ");
		System.out.println(sheet.getRow(4).getCell(1));
		
		System.out.print(sheet.getRow(5).getCell(0));
		System.out.print("      ");
		System.out.println(sheet.getRow(5).getCell(1));
		*/
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

}
}