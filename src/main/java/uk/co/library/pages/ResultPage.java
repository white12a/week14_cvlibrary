package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import uk.co.library.utility.Utility;

public class ResultPage extends Utility {
    public ResultPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h1[@class='search-header__title']")
    WebElement resultText;
    public void verifyResults(String expected){
        String actualText=getTextFromElement(resultText);
        String expectedText=expected;
        Assert.assertEquals(actualText,expectedText,"Verify Results Title");
        Reporter.log("Verify result title"+resultText.toString()+"<br>");
    }

}
