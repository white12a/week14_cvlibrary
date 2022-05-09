package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id ="gdpr-consent-notice")
    WebElement iframe;
    @FindBy(xpath = "//button[@id='save']")
    WebElement acceptCookies;
    public void acceptCookies(){
        switchToIframe(iframe);
        clickOnElement(acceptCookies);
        driver.switchTo().defaultContent();
    }

    @FindBy (id = "keywords")
    WebElement jobTitleField;
    public void enterJobTitle(String jobTitle){
        sendTextToElement(jobTitleField,jobTitle);
        Reporter.log("Enter job title ins search field"+ jobTitleField.toString()+"<br>");
    }

    @FindBy (id = "location")
    WebElement locationField;
    public void enterLocation(String location){
        sendTextToElement(locationField,location);
        Reporter.log("enter location"+locationField.toString()+"<br>");
    }

    @FindBy (id = "distance")
    WebElement distanceDropDown;
    public void selectDistanceFromDropDown(String distance) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(distanceDropDown,distance);
        Reporter.log("Select distance from dropdown"+distanceDropDown.toString()+"<br>");
    }

    @FindBy (id = "toggle-hp-search")
    WebElement moreSearchOptionsLink;
    public void clickOnMoreSearchLink(){
        clickOnElement(moreSearchOptionsLink);
        Reporter.log("Click on more search link"+ moreSearchOptionsLink.toString()+"<br>");
    }

    @FindBy (id = "salarymin")
    WebElement salaryMin1;
    public void enterSalaryMin(String salaryMin){
        Reporter.log("Enter Salary Min"+salaryMin1.toString()+"<br>");
        sendTextToElement(salaryMin1,salaryMin);
    }

    @FindBy (id = "salarymax")
    WebElement salaryMax1;
    public void enterSalaryMax(String salaryMax){
        sendTextToElement(salaryMax1,salaryMax);
        Reporter.log("Select salaryMax"+ salaryMax1.toString()+"<br>");
    }

    @FindBy (id = "salarytype")
    WebElement salaryTypeDropDown;
    public void selectSalaryTypeFromDropDown(String salaryType){
      selectByVisibleTextFromDropDown(salaryTypeDropDown,salaryType);
      Reporter.log("select salary type"+salaryTypeDropDown.toString()+"<br>");
    }

    @FindBy (id = "tempperm")
    WebElement jobTypeDropDown;
    public void selectJobTypeFromDropDown(String jobType){
      selectByVisibleTextFromDropDown(jobTypeDropDown,jobType);
      Reporter.log("Select job type"+ jobTypeDropDown.toString()+"<br>");
    }

    @FindBy (id = "hp-search-btn")
    WebElement findJobsBtn;
    public void clickOnFindJobsButton(){
        clickOnElement(findJobsBtn);
        Reporter.log("CLick on findJobs button"+findJobsBtn.toString()+"<br>");
    }

}
