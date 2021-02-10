package generics;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWUtils extends BaseTest{
	
	public static void VerifyPageTitle(WebDriver driver , String expectedtitle) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(expectedtitle));
		String acutaltitle = driver.getTitle();
		if (acutaltitle.equals(expectedtitle)) {
			System.out.println("ecpected title is dispaled " + expectedtitle);
		}else {
			System.out.println("expected title is not dispalytde " + acutaltitle);
		}	
	}
	
	public static String read_XL_Data(String path, String sheetname, int rownum, int cellnum) {
		String data = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static void takescreenshot(WebDriver driver, String path) {
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(path);
			FileUtils.copyFile(src, des);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
