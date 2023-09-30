package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {
    public WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    public void myClick(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElemenet(element);
        element.click();
    }

    public void mySendkeys(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        scrollToElemenet(element);
        element.sendKeys(text);
    }
    public void scrollToElemenet(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickToElemenet(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

    public void veifyContainsText(WebElement element,String value){
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
    }

    public void mySelect(WebElement element,int index){
        scrollToElemenet(element);
        Select nesneSelect=new Select(element);
        nesneSelect.selectByIndex(index);
    }
}
