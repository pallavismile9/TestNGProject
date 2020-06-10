package com.testng.login.demo;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAspose {
	
	@Test(dataProvider="asposeEmployeeInfo")
	public void validatingTrainerInfo(String name, int age, String role) {
		System.out.println(name+"\t"+age+"\t"+role);
	}
	
	
	
	
	@DataProvider(name="asposeEmployeeInfo")
	Object[][] trainerInfoFromExcel_aspose()throws Exception{
		String sFile = System.getProperty("user.dir")+"/Dataprovidertestng.xls";
		 return readDataFromExcelSheet_aspose(sFile);
	}
	//open source free tools can be used anywhere. 
	//private Object[][] readDataFromExcelSheet_aspose(String sFile) throws Exception {
/*		//Creating a file stream containing the Excel file to be opened
				FileInputStream fstream = new FileInputStream(sFile);
				
				//Instantiating a Workbook object
				XSSFWorkbook workbook = new XSSFWorkbook(fstream);
				
				//Accessing the first worksheet in the Excel file
				XSSFSheet worksheet = workbook.getSheetAt(0);
				
				//Exporting the contents of 7 rows and 2 columns starting from 1st cell to Array.
				
				Object[][] dataTable = worksheet.getCells().exportArray(0,0,7,3);
				for (int i = 0 ; i < dataTable.length ; i++)
				{
					System.out.println("["+ i +"]: "+ Arrays.toString(dataTable[i]));
				}
				//Closing the file stream to free all resources
				fstream.close();
				return dataTable;
				*/
		
		private Object[][] readDataFromExcelSheet_aspose(String sFile) throws Exception {
			//Creating a file stream containing the Excel file to be opened
					FileInputStream fstream = new FileInputStream(sFile);
					
					//Instantiating a Workbook object
					Workbook workbook = new Workbook(fstream);
					
					//Accessing the first worksheet in the Excel file
					Worksheet worksheet = workbook.getWorksheets().get(0);
					
					//Exporting the contents of 7 rows and 2 columns starting from 1st cell to Array.
					Object[][] dataTable = worksheet.getCells().exportArray(0,0,7,3);
					/*for (int i = 0 ; i < dataTable.length ; i++)
					{
						System.out.println("["+ i +"]: "+ Arrays.toString(dataTable[i]));
					}*/
					//Closing the file stream to free all resources
					fstream.close();
			return dataTable;
		
		
				
				
				
	}
}
