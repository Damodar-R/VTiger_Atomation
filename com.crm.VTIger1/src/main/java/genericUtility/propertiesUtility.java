package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is to perform Data driven from properties Utility
 */

public class propertiesUtility {
	/**
	 * this  generic method is to fetch data from properties file
	 * @author DDR
	 * @param key
	 * @param path
	 * @return
	 * @throws IOException
	 */

    public static String getDataFromProperties(String key) throws IOException {
        FileInputStream fis = new FileInputStream(IPathUtility.propertiesPath);
        Properties pr = new Properties();
        pr.load(fis);
        return pr.getProperty(key);
    }
/**
 * this generic method is to write Data into  to properties file
 * @author DDR
 * @param key
 * @param value
 * @param message
 * @param path
 * @throws IOException
 */
    public static void writeDataToProperties(
            String key,
            String value,
            String message
            ) throws IOException {

        FileInputStream fis = new FileInputStream(IPathUtility.propertiesPath);
        Properties pr = new Properties();
        pr.load(fis);

        FileOutputStream fos = new FileOutputStream(IPathUtility.propertiesPath);
        pr.setProperty(key, value);
        pr.store(fos, message);
    }
   
}
