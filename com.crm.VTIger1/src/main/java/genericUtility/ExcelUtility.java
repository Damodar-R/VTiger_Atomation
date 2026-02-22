package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	 /**
     * this method is to fetch data from external excel workbook sheets
     *@author DDR
     * @param sheetName
     * @param rowNum
     * @param cellNum
     * @param path
     * @return
     * @throws IOException
     */

    public static String getSingleCellDataFromExcel(
            String sheetName,
            int rowIndex,
            int cellIndex
            ) throws IOException {

        FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sh = wb.getSheet(sheetName);
        //Row row = sh.getRow(rowNum);
        //String data = row.getCell(cellNum).toString().trim();
        DataFormatter d=new DataFormatter();
        String value=d.formatCellValue(sh.getRow(rowIndex).getCell(cellIndex));

        wb.close();
       // return data;
       // return sh.getRow(rowIndex).getCell(cellIndex).toString();
        return value;
    }
    /**
     * this generic method is to fetch multiple data from an excel sheet
     * @author DDR
     * @param path
     * @param sheetName
     * @param startRowIndex
     * @param startCellIndex
     * @return
     * @throws EncryptedDocumentException
     * @throws IOException
     */
    public static List<String> getMultipleDataFromExcel(String sheetName, int startRowIndex,int startCellIndex) throws EncryptedDocumentException, IOException {
    FileInputStream fis=new FileInputStream(IPathUtility.excelPath);
    Workbook wb=WorkbookFactory.create(fis);
    DataFormatter df=new DataFormatter();
    Sheet sh=wb.getSheet(sheetName);
    List<String> rowData=new ArrayList<String>();
    for(int i=startRowIndex;i<=sh.getLastRowNum();i++) 
    {
    	Row r=sh.getRow(i);
    	for(int j=startCellIndex;j<=r.getLastCellNum();j++)
    	{
    		rowData.add(df.formatCellValue(r.getCell(j)));
    	}
    }
    	return rowData;
    }
    /**
     * this method is to write data to excel sheet
     * @author DDR
     * @param sheetName
     * @param cellNum
     * @param value
     * @param path
     * @throws IOException
     */
    public static void writeDataToExcelSheetCell(
            String sheetName,
            int cellNum,
            String value
            ) throws IOException {

        FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
        Workbook wb = WorkbookFactory.create(fis); 
        Sheet sh = wb.getSheet(sheetName);
        int lastrow=sh.getLastRowNum();
        Row row = sh.createRow(lastrow+1);
        row.createCell(cellNum).setCellValue(value);
        FileOutputStream fos = new FileOutputStream(IPathUtility.excelPath);
         wb.write(fos);
         wb.close();
      
    }
    /**
     * this generic method is used to write data into a new excel sheet
     * @param path
     * @param sheetName
     * @param rowIndex
     * @param cellIndex
     * @param value
     * @throws IOException
     */
    public static void writeDataToNewExcelSheetCell(
            String sheetName,
            int rowIndex,
            int cellIndex,
            String value
         ) throws IOException {

        FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
        Workbook wb = WorkbookFactory.create(fis); 
        Sheet sh = wb.createSheet(sheetName);
       
        Row row = sh.createRow(rowIndex);
        row.createCell(cellIndex).setCellValue(value);
        FileOutputStream fos = new FileOutputStream(IPathUtility.excelPath);
         wb.write(fos);
         wb.close();
      
    }
    public static void updateRowDataInExcelSheetCell(
            String sheetName,
            int rowIndex,
            int cellNum,
            String value
           ) throws IOException {

        FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
        Workbook wb = WorkbookFactory.create(fis); 
        Sheet sh = wb.getSheet(sheetName);
       
        Row row = sh.createRow(rowIndex);
        row.createCell(cellNum).setCellValue(value);
        FileOutputStream fos = new FileOutputStream(IPathUtility.excelPath);
         wb.write(fos);
         wb.close();
      
    }

}
