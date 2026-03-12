package com.thetestingacademy.DataDrivenTesting;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {
    //Working of Apache poi -
    //1. Read the file  //2. Create a workbook  //3. Go to sheet  //4. In the sheet we have row and cell
    //5. Give the data to 2d object[][] getData() function

    static Workbook book;
    static Sheet sheet;

    public static String Sheet_Path = System.getProperty("user.dir")+ "/src/test/Resourses/TestDataDrivenFile.xlsx";

    public static Object[][] getTestDataFromExcel(String sheetName) throws IOException {

        FileInputStream file = null;
        file = new FileInputStream(Sheet_Path);

        book = WorkbookFactory.create(file);
        sheet = book.getSheet(sheetName);//workbook and sheet both are Interfaces

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        //r*c = 4*2
        for(int i=0; i<sheet.getLastRowNum(); i++) {
            for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }

     @DataProvider
    public Object[][] getData() throws IOException {
        return getTestDataFromExcel("Sheet1");
    }




}
