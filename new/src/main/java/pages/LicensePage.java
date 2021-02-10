package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicensePage {
	
	@FindBy(xpath = "//nobr[.='Product Edition:']/../../td[2]")
	private WebElement productedition;
	
	@FindBy(xpath ="//nobr[.='Issue Date:']/../../td[2]")
	private WebElement issuedate;
	
	@FindBy(xpath ="//nobr[.='Licensed Users:']/../../td[2]")
	private WebElement licensedusers;
	
	public LicensePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void VerifyProductEdition(WebDriver driver, String ExpectedEdition) {
		String ActualEdition = productedition.getText();
		if (ActualEdition.equals(ExpectedEdition)) {
			System.out.println("Expected Edition is dispalyed : " + ExpectedEdition);
		} else {
			System.out.println("Expected product edition is not dispalyed :" + ActualEdition);
		}
		
	}
	
	public void VerifyIssueDate(WebDriver driver, String ExpectedIssuDate) {
		String AcuatlIssueDate = issuedate.getText();
		
		if (AcuatlIssueDate.equals(ExpectedIssuDate)) {
			System.out.println("Expected issue date is :" + ExpectedIssuDate);
		}else {
			System.out.println("Acutal issed date is :" + AcuatlIssueDate);
		}
	}

}
