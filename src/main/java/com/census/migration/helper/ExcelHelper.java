package com.census.migration.helper;

import com.census.migration.model.SourceData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "PatientDetails";

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<SourceData> excelToSourceData(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<SourceData> sourceDataList = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                SourceData sourceData = new SourceData();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            sourceData.setPatientId((int) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            sourceData.setName(currentCell.getStringCellValue());
                            break;
                        case 2:
                            sourceData.setAddress(currentCell.getStringCellValue());
                            break;
                        case 3:
                            sourceData.setState(currentCell.getStringCellValue());
                            break;
                        case 4:
                            sourceData.setZipCode((int) currentCell.getNumericCellValue());
                            break;
                        case 5:
                            sourceData.setCounty(currentCell.getStringCellValue());
                            break;
                        case 6:
                            sourceData.setMobileNumber((long) currentCell.getNumericCellValue());
                            break;
                        case 7:
                            sourceData.setGender(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                sourceDataList.add(sourceData);
            }
            workbook.close();
            return sourceDataList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
