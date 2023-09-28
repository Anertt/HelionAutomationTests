package helionShop.pages;

import helionShop.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//div[@class='input-line']//input[@name='email']")
    WebElement loginInput;

    @FindBy (xpath = "//div[@class='input-line']//input[@name='password']")
    WebElement passwordInput;

    @FindBy (id = "log_in_submit")
    WebElement loginButton;

    @FindBy (xpath = "//h4[text()='Niestety podałeś niewłaściwy adres email lub hasło.']")
    WebElement errorText;

    public LoginPage loginToAccount(String email, String password) {
        loginInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new LoginPage(driver);
    }

    public String getErrorText() {
      return errorText.getText();
    }
}
