package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	/**
	 *   method getinputexcelfile is the method that  read the path of excel file and put it in the src file
	 *   and then read file from  FileInputStream 
	 */
	static FileInputStream fis = null ;
	public FileInputStream getinputexcelfile() 
	{

		String filePath = System.getProperty("user.dir")+"/src/test/java/data/Data.xlsx"; 
		File srcFile = new File(filePath);
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println(" Data file not found");

		}

		return fis ; 
	}


	/**
	 * Returns Object of two dimension array that contaion rows and coulmns in excel sheet
	 *   method getExcelData is the method that read data from excel file and use external library attached to maven in order to read data  
	 *   and write data in excel file  (Apache POI)
	 *   first reaad  workbook it is the sheet in excel that help to read sheet that conatain coulmns and rows that help to read data
	 *   and then read file from  FileInputStream 
	 *   contain loop to get data from excel sheet in 2D array
	 *   @return      2D array contain data in coulmns and rows
	 */

	public Object[][] getExcelData() throws IOException
	{
		fis = getinputexcelfile(); 
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0); 
		int TotalNumberOfRows = 1;
		int TotalNumberOfCols = 7; 
		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 

		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString(); 
			}
		}
		wb.close();
		return arrayExcelData; 
	}

}
