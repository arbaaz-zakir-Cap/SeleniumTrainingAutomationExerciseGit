package StepDefinitions;

import AutomationExcercise.Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class VerifySubscription {

    public static WebDriver driver = new EdgeDriver();

    HomePage homePage = new HomePage(driver);
    String message;
    @BeforeAll
    public static void beforeAllTests(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Before Test Run!!");
    }

    @AfterAll
    public static void afterAllTests(){
        driver.quit();
    }

    @When("User have navigated to automationexercise.com home page for subscription")
    public void userHaveNavigatedToHttpsAutomationexerciseComHomePage() {
        homePage.visitSite();
    }

    @Then("Verify that home page is visible successfully for subscription")
    public void verify_website(){
        //System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
    }


    @When("You scroll down to footer")
    public void youScrollDownToFooter() {
        homePage.scrollDownPage();
    }

    @Then("Verify text subscription")
    public void verifyText() {
        Assert.assertEquals(homePage.getSubscriptionText(), "SUBSCRIPTION");
    }

    @When("User enters email in subscription box")
    public void userEntersEmailInSubscriptionBox() {
        homePage.enterEmail("test1@test.com");
    }

    @Then("click arrow button")
    public void clickArrowButton() {
        homePage.clickSubscribe();
        message = homePage.getSubscriptionText();
        //System.out.println("message is: "+ message);
    }

    @And("Verify success message You have been successfully subscribed! is visible")
    public void verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible() {
        Assert.assertTrue(homePage.subscribeSuccessisTrue());
    }
}
