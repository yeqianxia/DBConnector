package com.qianxia.experiment.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

/**
 * @author qianxia
 * @date 2021/12/16  10:51
 */
public class ExcelDemo {


    public static void main(String[] args) throws Exception {

        FileInputStream file = new FileInputStream("/Users/qianxia/IdeaProjects/Experiment/src/main/resources/static/excelDemo.xlsx");
//        FileInputStream file = new FileInputStream("/Users/qianxia/IdeaProjects/Experiment/src/main/resources/static/csvDemo.csv")
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println(sheet.getLastRowNum());
        System.out.println(sheet.getRow(0).getCell(0).getCellType());
        System.out.println(sheet.getRow(0).getCell(0).getColumnIndex());

        CellReference c = new CellReference(0, 0);
        System.out.println(CellReference.convertNumToColString(0));

    }


}
