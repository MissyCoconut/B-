import com.csvreader.CsvReader;

import java.io.IOException;
import java.lang.String;
import java.nio.charset.Charset;
import java.util.ArrayList;


/**
 * @author: zjy
 * @data: 2018/10/11
 * @description:
 */

public class ReadCSV
{
    public static ArrayList<String[]> read()
    {
        ArrayList<String[]> csvFileList=new ArrayList<String[]>();
        try
        {
            String csvFilePath="应用程序日志.csv";
            CsvReader reader=new CsvReader(csvFilePath,',', Charset.defaultCharset());
            reader.readHeaders();
            while(reader.readRecord())
            {
//                System.out.println(reader.getRawRecord());
                String[] row=reader.getValues();
                if(row.length<6)
                    continue;

                String[] keyAndValue=new String[2];

                keyAndValue[0]=row[1];
//                System.out.println(keyAndValue[0]);

                if(row[5]!=null)
                    keyAndValue[1] = row[5];
                else
                    keyAndValue[1]="信息空缺";
                csvFileList.add(keyAndValue);

            }
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return csvFileList;

    }

}
