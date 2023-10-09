package AutomationExcercise.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By productsButton = By.xpath("//a[@href='/products']");

    By homeButton = By.xpath("//i[@class='fa fa-home']//parent::a");

    By subcriptionTextBox = By.xpath("//input[@id='susbscribe_email']");

    By subscribeButton = By.xpath("//button[@id='subscribe']");

    By subscribeSuccessMessage = By.xpath("//div[@class='alert-success alert']");
    JavascriptExecutor js;


    public HomePage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public void visitSite(){
        driver.get("https://automationexercise.com/");
    }

    public void clickOnProductsButton(){
        driver.findElement(productsButton).click();
    }

    public String getHomeButtonHighlighted(){
        //String s = driver.findElement(homeButton).getText();
        String style = driver.findElement(homeButton).getAttribute("style");
        System.out.println(style);
        return style;
    }

    public void scrollDownPage(){
        js.executeScript("window.scrollBy(0,1000)");
    }

    public String getSubscriptionText(){
        return driver.findElement(By.xpath("//div[@class='single-widget']//h2")).getText();
    }

    public void enterEmail(String email){
        driver.findElement(subcriptionTextBox).sendKeys(email);
    }

    public void clickSubscribe(){
        driver.findElement(subscribeButton).click();
    }

    public boolean subscribeSuccessisTrue(){
        return driver.findElement(subscribeSuccessMessage).isDisplayed();
    }


}
