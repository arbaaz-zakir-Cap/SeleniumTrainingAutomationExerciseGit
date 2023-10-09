package AutomationExcercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;

    By allProducts = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2/text()");

    By productsSearchBox = By.id("search_product");
    By searchButton = By.xpath("//button[@id='submit_search']");
    By searchedProductsTitle = By.xpath("//h2[@class='title text-center']");
    By menTshirtText = By.xpath("//div[@class='productinfo text-center']//p");
    By productsButton = By.xpath("//a[@href='/products']");

    By adDismiss = By.xpath("//div[@id='dismiss-button']");

    By adsFrame = By.xpath("//div[@id='ad_position_box']");
    By dismissButton = By.xpath("//div[@id='dismiss-button']");
    By adBox = By.id("ad_position_box");
    WebDriverWait wait;
    public ProductsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getAllProductsTitleText(){
        System.out.println(driver.findElement(allProducts).getText());
        return driver.findElement(allProducts).getText();
    }

    public void searchProduct(String product){
        driver.findElement(productsSearchBox).sendKeys(product);
    }
    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }
    public String getSearchedProductsTitleText(){
        return driver.findElement(searchedProductsTitle).getText();
    }
    public String getMenTshirt(){
        return driver.findElement(menTshirtText).getText();
    }

    public void adsClick(){
        //wait.until(ExpectedConditions.presenceOfElementLocated(dismissButton));
        driver.findElement(adBox).click();
    }

    public String getProductsButtonHighlighted(){
        //String s = driver.findElement(homeButton).getText();
        String style = driver.findElement(productsButton).getAttribute("style");
        System.out.println(style);
        return style;
    }
}
