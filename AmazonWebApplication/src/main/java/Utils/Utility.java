package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String getDataFromExcelSheet(String sheet, int row, int col) throws EncryptedDocumentException, IOException
	{
		String data = "C:\\Users\\Vivek Sawarkar\\Desktop\\testing to etch data.xlsx";
		FileInputStream file = new FileInputStream(data);
		String value = WorkbookFactory.create(file).getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();
		return value;
	}
	
	public static void getScreenShot(WebDriver driver, int testID) throws IOException {
		// TODO Auto-generated method stub
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File (" D:\\SHraddha\\New folder\\Test"+testID+".jpg");
		FileHandler.copy(src, dest);
	}
}
