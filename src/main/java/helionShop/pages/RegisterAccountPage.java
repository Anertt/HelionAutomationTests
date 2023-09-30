package helionShop.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {

    private WebDriver driver;

    public RegisterAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirm_password")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//div[@class='error-info']")
    private WebElement errorText;

    @FindBy(xpath = "//label[@for='zgoda']")
    private WebElement acceptRegulationsCheckbox;

    @FindBy(id = "registration_form_submit")
    private WebElement createAccountButton;

    public RegisterAccountPage registerAccount(String email, String password, String confrimPassword) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confrimPassword);
        return new RegisterAccountPage(driver);
    }

    public String accpetRegulations() {
        acceptRegulationsCheckbox.click();
        return errorText.getText();
    }

    public String createAccount() {
        createAccountButton.click();
        return errorText.getText();
    }

    public RegisterAccountPage clearForm() {
        emailInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        emailInput.sendKeys(Keys.DELETE);
        passwordInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        passwordInput.sendKeys(Keys.DELETE);
        confirmPasswordInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        confirmPasswordInput.sendKeys(Keys.DELETE);
        return new RegisterAccountPage(driver);
    }

}
