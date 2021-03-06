
package IO.Excel;

import GUI.Sweet.SweetAlert;
import static IO.Excel.ObjectExcel.autosizeColumn;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DoanhThuQuyExcel extends ObjectExcel{
    public static final int CELL_NAM = 0;
    public static final int CELL_QUY  = 1;
    public static final int CELL_DOANHTHU  = 2;
    public static final int CELL_CHI  = 3;
    public static final int CELL_LOINHUAN  = 4;
    public static void ExportExcelFile( String excelFilePath, ArrayList<String[]> list ) throws IOException
    {
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet();            
    // Chỉnh font,...
    Font headerFont = workbook.createFont();
    headerFont.setBoldweight((short)3);
    headerFont.setFontHeightInPoints((short) 14);
    headerFont.setColor(IndexedColors.RED.getIndex());

    // Ghi Header
    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);
    Row title = sheet.createRow(0);
    Cell cellHeader = title.createCell(0);
    cellHeader.setCellStyle(headerCellStyle);
    cellHeader.setCellValue("Doanh Thu Theo Quý");    
    Row headerRow = sheet.createRow(1);
    cellHeader = headerRow.createCell(CELL_NAM);
    cellHeader.setCellStyle(headerCellStyle);
    cellHeader.setCellValue("Năm");

    cellHeader = headerRow.createCell(CELL_QUY);
    cellHeader.setCellStyle(headerCellStyle);
    cellHeader.setCellValue("Quý");

    cellHeader = headerRow.createCell(CELL_DOANHTHU);
    cellHeader.setCellStyle(headerCellStyle);
    cellHeader.setCellValue("Doanh Thu");

    cellHeader = headerRow.createCell(CELL_CHI);
    cellHeader.setCellStyle(headerCellStyle);
    cellHeader.setCellValue("Chi");

    cellHeader = headerRow.createCell(CELL_LOINHUAN);
    cellHeader.setCellStyle(headerCellStyle);
    cellHeader.setCellValue("Lợi nhuận");

    int rowNum = 2;
    for (int i = 0;i < list.size();i++){
        Row row =  sheet.createRow(rowNum++);
        Cell cell = row.createCell(CELL_NAM);
        cell.setCellValue(list.get(i)[0]);

        cell = row.createCell(CELL_QUY);
        cell.setCellValue(list.get(i)[1]);

        cell = row.createCell(CELL_DOANHTHU);
        cell.setCellValue(list.get(i)[2]);

        cell = row.createCell(CELL_CHI);
        cell.setCellValue(list.get(i)[3]);

        cell = row.createCell(CELL_LOINHUAN);
        cell.setCellValue(list.get(i)[4]);
        
    }
    // Canh đều column
    int numberOfColumn = sheet.getRow(1).getPhysicalNumberOfCells();
    autosizeColumn(sheet, numberOfColumn);

    OutputStream fileOut = new FileOutputStream(new File(excelFilePath));
    workbook.write(fileOut);
    fileOut.close();
    SweetAlert.showSweetAlert(new JFrame(), "Hoàn thành", "Xuất dữ liệu thành công", 1);
    System.out.println("6120-Success");
} 
}
