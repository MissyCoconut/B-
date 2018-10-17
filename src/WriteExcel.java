import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * @author: zjy
 * @data: 2018/10/14
 * @description:
 */

public class WriteExcel
{
    public static void write( ArrayList<String> elementList)
    {
        Workbook workbook=new HSSFWorkbook();
        Sheet sheet=workbook.createSheet();
        int i=0;

        for(String a:elementList)
        {
            Row row=sheet.createRow(i);

            Cell cell=row.createCell(0);
            cell.setCellValue(elementList.get(i));
            i++;
        }


        try
        {
            FileOutputStream fos=new FileOutputStream("data1.xls");
            workbook.write(fos);
            fos.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
