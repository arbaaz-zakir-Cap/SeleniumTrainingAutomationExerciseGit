package StepDefinitions;

import AutomationExcercise.Pages.HomePage;
import AutomationExcercise.Pages.ProductsPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SearchProduct {

    public static WebDriver driver = new EdgeDriver();

    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

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

    //Navigate to automation exercise website
    @When("You have navigated to automationexercise.com")
    public void navigate_to_website(){
        homePage.visitSite();
    }

    @Then("Verify that home page is visible successfully")
    public void verify_website(){
        //System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
    }

    //Navigate to 'Products' page
    @Given("user is on automation exercise home page")
    public void user_is_on_home(){
        //System.out.println("USER IS ON HOME");
        //System.out.println(homePage.getHomeButtonHighlighted());
        Assert.assertEquals(homePage.getHomeButtonHighlighted(),"color: orange;");
    }

    @When("user clicks on 'products' button")
    public void click_products_button() throws InterruptedException {
        homePage.clickOnProductsButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dismiss-button")));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ad_position_box"))));
        //driver.switchTo().frame("aswift_6");
        driver.switchTo().frame("ad_iframe");
        //Thread.sleep(2000);
        driver.findElement(By.id("dismiss-button")).click();
        driver.switchTo().defaultContent();
    }

    @Then("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_products_page(){
        Assert.assertEquals(productsPage.getProductsButtonHighlighted(),"color: orange;");
    }

    //Search for a product
    @When("user enters product name in search input")
    public void input_product(){
        productsPage.searchProduct("shirt");
    }
    @And("clicks search button")
    public void click_button(){
        productsPage.clickSearchButton();
    }
    @Then("Verify 'SEARCHED PRODUCTS' is visible")
    public void verify_searched_products_is_visible(){
        Assert.assertEquals(productsPage.getSearchedProductsTitleText(),"SEARCHED PRODUCTS");
    }
    @And("Verify all the products related to search are visible")
    public void verify_all_related_products(){
        List<WebElement> list = driver.findElements(By.
                xpath("//div[@class='col-sm-4']/div[@class='product-image-wrapper']"));
        boolean isTrue = true;
        for(WebElement ele : list){
            String keyWord = ele.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/p")).getText();
            if(!keyWord.contains("shirt")){
                isTrue = false;
            }
        }
        Assert.assertTrue(isTrue);
    }



}
