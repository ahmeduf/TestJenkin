package DataDrivenClass;

import base.CommonClass;
import base.ReusableAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends CommonClass{
    @FindBy(id = "userName")
    public static WebElement loginTextBox;
    @FindBy(id = "userPassword")
    public static WebElement passwordTextBox;
    @FindBy(id = "loginButton")
    public static WebElement loginButton;

    public static void navigateToLoginPage(){
        driver.navigate().to("https://ecams.geico.com/ecams/login.xhtml?r=true");
    }

    public String SendLoginInfo(String email, String password) throws InterruptedException {
        loginTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        Thread.sleep(2000);
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userPassword-msgs")));
        WebElement errorMessage = driver.findElement(By.id("userPassword-msgs"));
        String errMessage = errorMessage.getText();
        return errMessage;
    }
}