package com.pom.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pom.qa.base.TestBase;
import com.pom.qa.testdata.Xls_Reader;


public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static  long IMPLICIT_WAIT = 20;
	//public static String TESTDATA_SHEET_PATH="C:\\qa\\Selenium_Workspace\\POMTest\\src\\main\\java\\com\\pom\\qa\\testdata\\POM_myaccount.xlsx";
	public static String TESTDATA_SHEET_PATH="C:/qa/Selenium_Workspace/POMTest/src/main/java/com/pom/qa/testdata/POM_myaccount.xlsx";
	static Xls_Reader xlsData = new Xls_Reader(TESTDATA_SHEET_PATH);
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName){
        FileInputStream file = null;

        try {
        	file = new FileInputStream(new File(TESTDATA_SHEET_PATH));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        System.out.println("Sheet path " + TESTDATA_SHEET_PATH);

        try {
            book = WorkbookFactory.create(file);
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable e) {
			e.printStackTrace();
		} 
        sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];        System.out.println(sheet.getLastRowNum());
        System.out.println(sheet.getRow(0).getLastCellNum());
        
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i+1).getCell(k).toString();
                System.out.println(data[i][k]);
            }
        }
        return data;

    }

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}


