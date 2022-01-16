package com.nitesh.appuploaderservice.utils;

import com.nitesh.appuploaderservice.models.Adjustment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Component
public class ExcelUtil {

    public static List<Adjustment> readExcelData(File file) {
        FileInputStream fs = null;
        List<Adjustment> adjustmentData = null;
        if (file != null) {
            try {
                fs = new FileInputStream(file);
                try {
                    Workbook workBook = new XSSFWorkbook(fs);
                    Sheet sheet = workBook.getSheetAt(0);
                    adjustmentData = new ArrayList<>();
                    Iterator<Row> rowIterator = sheet.iterator();
                    int count = 0;
                    while (rowIterator.hasNext()) {
                        Row currentRow = rowIterator.next();
                        if (currentRow.getRowNum() == 0) {
                            System.out.println("Skipping headers while reading excel file data...");
                            continue;
                        }
                        Adjustment d = assignValuesToAdjustment(currentRow, count);
                        count++;
                        adjustmentData.add(d);
                    }
                    return adjustmentData;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There is no File found to read ..!!");
        }

        return null;
    }

    private static Adjustment assignValuesToAdjustment(Row currentRow, int count) {
        Adjustment adjustment = new Adjustment();
        adjustment.setAdjustmentStartDate(currentRow.getCell(0).getDateCellValue());
        adjustment.setAdjustmentEndDate(currentRow.getCell(1).getDateCellValue());
        adjustment.setAvailableForReviewer(currentRow.getCell(2).getStringCellValue());
        adjustment.setAdjustmentStatus(currentRow.getCell(3).getStringCellValue());
        System.out.println("Adjustment while reading excel sheet "+adjustment);
        return adjustment;
    }
}
