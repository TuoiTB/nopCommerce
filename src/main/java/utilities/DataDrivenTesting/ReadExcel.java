package utilities.DataDrivenTesting;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    public static void main(String[] agrs) throws IOException{
        String excelFilePath = "D:/Automation/TEST/src/main/java/utilities/countries.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);

        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(0); // XSSFSheet sheet = workbook.getSheet("Sheet 1");

        //USING FOR LOOP
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for (int i = 0; i <= rows ; i++) {
            HSSFRow row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                HSSFCell cell = row.getCell(j);
            }
        }
    }
}
