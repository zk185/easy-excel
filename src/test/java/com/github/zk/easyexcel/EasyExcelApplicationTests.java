package com.github.zk.easyexcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyExcelApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() throws IOException {
        InputStream is = new FileInputStream("H:/aa.xlsx");
        OutputStream os = new FileOutputStream("H:/2007.xlsx");
        SXSSFWorkbook sheets = new SXSSFWorkbook(new XSSFWorkbook(is));
//        SXSSFSheet sheetAt = sheets.getSheetAt(0);
        XSSFSheet sheetAt = sheets.getXSSFWorkbook().getSheetAt(0);
        System.out.println(sheetAt.getLastRowNum());
        sheetAt.shiftRows(1,20,1);
        XSSFRow row = sheetAt.createRow(1);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue(1);
//        SXSSFSheet sheet = sheets.createSheet();
        sheets.write(os);
        System.out.println();
    }
    @Test
    public void test2() throws IOException {
        InputStream is = new FileInputStream("H:/aa.xlsx");
        OutputStream os = new FileOutputStream("H:/2007.xlsx");
        Workbook sheets = new SXSSFWorkbook(new XSSFWorkbook(is));
        XSSFSheet sheetAt = ((SXSSFWorkbook) sheets).getXSSFWorkbook().getSheetAt(0);
        XSSFRow row = sheetAt.getRow(0);
        XSSFCell cell = row.getCell(0);
        cell.setCellValue(1);
        sheets.write(os);
        System.out.println();
    }

}
