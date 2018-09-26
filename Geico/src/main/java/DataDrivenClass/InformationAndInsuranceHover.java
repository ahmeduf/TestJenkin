package DataDrivenClass;

import base.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class InformationAndInsuranceHover extends CommonClass {
    @FindBy(css = "ul.desktop-links > li:nth-child(2)>a")
    public static WebElement information;
    @FindBy(xpath = "//div[@data-side-panel='information']/ul")
    public static WebElement informationDiv;
    @FindBy(xpath = "//div[@data-side-panel='information']/ul/li/a/span[2]")
    public static WebElement infoMenuElements;
    public static String informationDivPath = "//div[@data-side-panel='information']/ul";
    public static String infoMenuElementsPath = "//div[@data-side-panel='information']/ul/li/a/span[2]";

    /*public static List<WebElement> LoadInvisibleDiv(WebElement element){
        builder.moveToElement(element).click().pause(2000).perform();
        List<WebElement> unorderedList;
        //if(element.toString().equalsIgnoreCase("information")){
            wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.xpath("//div[@data-side-panel='information']/ul"),By.xpath("//div[@data-side-panel='information']/ul/li")));
            WebElement divUL = driver.findElement(By.xpath("//div[@data-side-panel='information']/ul"));
             unorderedList = divUL.findElements(By.xpath("//div[@data-side-panel='information']/ul/li"));
       // }
        return unorderedList;
    }

    public void testInformationMenuHover() throws InterruptedException {
        List<WebElement> unorderedList = LoadInvisibleDiv(information);
        for(WebElement it : unorderedList){
            builder.moveToElement(it).perform();
            Thread.sleep(1000);

        }
    }*/
    public List<WebElement> retMenuList(String parentXpath, String childXpath){
        //WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.xpath(parentXpath),By.xpath(childXpath)));
        WebElement divUL = driver.findElement(By.xpath(parentXpath));
        List<WebElement> unorderedList = divUL.findElements(By.xpath(childXpath));
        return unorderedList;
    }
    public List<WebElement> retInfoMenu(){
        information.click();
        List<WebElement> li = retMenuList(informationDivPath,infoMenuElementsPath);
        return  li;
    }
}