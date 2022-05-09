package uk.co.library.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.TestBase;

public class JobSearchTest extends TestBase {
    HomePage homePage;
    ResultPage resultPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage=new HomePage();
        resultPage=new ResultPage();
    }

    @Test(dataProvider = "JobSearch", dataProviderClass = TestData.class,groups = {"smoke","sanity","regression"})
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String result) throws InterruptedException {
         homePage.acceptCookies();
        //enter job title 'jobTitle'
        homePage.enterJobTitle(jobTitle);
        //enter Location 'location'
        homePage.enterLocation(location);
        //select distance 'distance'
        homePage.selectDistanceFromDropDown(distance);
        //click on moreSearchOptionsLink
        homePage.clickOnMoreSearchLink();
        //enter salaryMin 'salaryMin'
        homePage.enterSalaryMin(salaryMin);
        //enter salaryMax 'salaryMax'
        homePage.enterSalaryMax(salaryMax);
        //select salaryType 'salaryType'
        homePage.selectSalaryTypeFromDropDown(salaryType);
        //select jobType 'jobType'
        homePage.selectJobTypeFromDropDown(jobType);
        //click on 'Find Jobs' button
        homePage.clickOnFindJobsButton();
        //verify the result 'result'
        resultPage.verifyResults(result);

    }



}
