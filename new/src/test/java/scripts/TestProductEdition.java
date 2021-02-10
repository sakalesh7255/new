package scripts;

import org.testng.annotations.Test;

import generics.BaseTest;
import generics.FWUtils;
import pages.EnterTimeTrackPage;
import pages.LicensePage;
import pages.LogInPage;

public class TestProductEdition extends generics.BaseTest{
	
	@Test
	public void TestProductEdition() throws InterruptedException {
		String un = generics.FWUtils.read_XL_Data(Read_XL_data, "License Page", 1, 0);
		String pw = FWUtils.read_XL_Data(Read_XL_data, "License Page", 1, 1);
		String ExpectedTitle = FWUtils.read_XL_Data(Read_XL_data, "License Page", 1, 2);
		String ExpectedTitle2 = FWUtils.read_XL_Data(Read_XL_data, "License Page", 1, 3);
		String Productedition = FWUtils.read_XL_Data(Report_Path, "License Page", 1, 4);
		String Issudate = FWUtils.read_XL_Data(Report_Path, "License Page", 1, 5);
		
		LogInPage lp = new LogInPage(driver);
		lp.setusername(un);
		lp.setpassword(pw);
		lp.clickonlogin();
		
		EnterTimeTrackPage Etp = new EnterTimeTrackPage(driver);
		Thread.sleep(1000);
		FWUtils.VerifyPageTitle(driver, ExpectedTitle);
		Etp.clickOnSettingsMenu();
		Etp.clickOnLicensesLink();
		
		LicensePage Lcp = new LicensePage(driver);
		FWUtils.VerifyPageTitle(driver, ExpectedTitle2);
		Lcp.VerifyProductEdition(driver, Productedition);
		Lcp.VerifyIssueDate(driver, Issudate);
	}

}
