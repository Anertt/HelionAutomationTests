package helionShop.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement goToCheckout;

    @FindBy(xpath = "//div[@class='plus more']")
    private WebElement addMoreInCartButton;

    @FindBy(xpath = "//div[@class='minus less']")
    private WebElement minusInCartButton;

    @FindBy(xpath = "//label[@class='label-private']")
    private WebElement privatePersonLabel;

    @FindBy(xpath = "//input[@name='name']")
    private  WebElement nameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    private  WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='phone']")
    private  WebElement phoneINput;

    @FindBy(xpath = "//p[@class='change']//span[text()='Edytuj']")
    private  WebElement editAdressButton;

    @FindBy(xpath = "//input[@name='street']")
    private   WebElement streetInput;

    @FindBy(xpath = "//input[@name='houseNumber']")
    private  WebElement houseNumberInput;

    @FindBy(xpath = "//input[@name='code']")
    private WebElement codeInput;

    @FindBy(xpath = "//input[@name='city']")
    private  WebElement cityInput;

    @FindBy(id = "saveAdress")
    private  WebElement saveButton;

    @FindBy(xpath = "//span[text()='BLIK']")
    private WebElement blikButton;

    public CartPage checkButtons() {
        addMoreInCartButton.click();
        minusInCartButton.click();
        goToCheckout.click();
        return new CartPage(driver);
    }

    public CartPage clearForm() {
        privatePersonLabel.click();
        nameInput.clear();
        editAdressButton.click();
        streetInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        streetInput.sendKeys(Keys.DELETE);
        houseNumberInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        houseNumberInput.sendKeys(Keys.DELETE);
        codeInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        codeInput.sendKeys(Keys.DELETE);
        cityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        cityInput.sendKeys(Keys.DELETE);
        return new CartPage(driver);
    }

    public void fillOrderForm(String name, String lastname, String phone,
                              String street, String houseNumber, String code, String city) {
//        privatePersonLabel.click();
        nameInput.sendKeys(name);
        lastNameInput.sendKeys(lastname);
        phoneINput.sendKeys(phone);
//        editAdressButton.click();
        streetInput.sendKeys(street);
        houseNumberInput.sendKeys(houseNumber);
        codeInput.sendKeys(code);
        cityInput.sendKeys(city);
        saveButton.click();
        blikButton.click();
    }


}
