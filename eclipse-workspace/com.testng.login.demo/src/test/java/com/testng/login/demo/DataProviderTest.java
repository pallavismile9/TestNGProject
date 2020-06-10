package com.testng.login.demo;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	
	@Test(dataProvider="EmployeeInfo")
	public void validatingEmployeeInfo(String name, String age, String role) {
		System.out.println(name+"\t"+age+"\t"+role);
		}
	
	
	@DataProvider(name="EmployeeInfo")
	Object[][] EmployeeInfoFromExcel()throws Exception{
		String sFile = System.getProperty("user.dir")+"/Dataprovidertestng.xlsx";
		 return readDataFromExcelSheet(sFile);
	}
	
	public Object[][] readDataFromExcelSheet(String sFile) throws Exception {
		File f = new File(System.getProperty("user.dir")+"/Dataprovidertestng.xlsx");
		XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(sFile));
		XSSFSheet myExcelSheet = myExcelBook.getSheet("Sheet1");
		XSSFRow row1 = myExcelSheet.getRow(0);
		System.out.println(row1.getPhysicalNumberOfCells()); //To take total number of collumns
		System.out.println(myExcelSheet.getPhysicalNumberOfRows());//To take total number of Rows
		//System.out.println(row1.getLastCellNum());
		int iCountCol =row1.getLastCellNum();
		int iCountRow = myExcelSheet.getPhysicalNumberOfRows();
		Object[][] excelData= new Object[iCountRow][iCountCol]; //Creating multi dimensional array
		
		for(int countRow=0;countRow<iCountRow;countRow++) {
			for(int countCol = 0; countCol<iCountCol;countCol++) {
				XSSFRow tempRow=myExcelSheet.getRow(countRow);
				String sTemp;
				try {
				//System.out.println(tempRow.getCell(countCol).getStringCellValue());
				sTemp=tempRow.getCell(countCol).getStringCellValue();
				}catch(Exception e) {
					//System.out.println(tempRow.getCell(countCol).getNumericCellValue());
					sTemp=Double.toString(tempRow.getCell(countCol).getNumericCellValue());
				}
				excelData[countRow][countCol] = sTemp;
			}
		}	
		return excelData;
		}

		/*@Test(dataProvider="asposetrainerInfo")
		public void validatingTrainerInfo(String name, int exp, String email) {
			System.out.println(name+"\t"+exp+"\t"+email);
		}*/

}
