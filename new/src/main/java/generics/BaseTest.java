package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements AutoConstant{
	
	static {
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(gecko_key, gecko_value);
	}
	
	public WebDriver driver;
	public static int passcount = 0 , failcount =0;
	
	@BeforeClass
	@Parameters("sbrowser")
	public void OpenBrowser(String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(ito, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void OpenApplication() {
		driver.get(URL);
	}
	@AfterMethod
	public void closebrowser(ITestResult res) {
		int status = res.getStatus();
		String MethodName = res.getName();
		if (status==1) {
			passcount++;
		}else {
			failcount++;
			String path = Photo_Path+MethodName+".png";
			FWUtils.takescreenshot(driver, path);
		}
		driver.close();
	}

}
