package helionShop.pages;

import helionShop.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage extends BaseTest {

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//div[@class='login-links']//a[text()='Wyloguj się']")
    private WebElement logOffButton;

    @FindBy (xpath = "//div[@class='successbox oneline']")
    private WebElement logOffText;

    @FindBy (xpath = "//li[@class='item4']")
    private WebElement shelfsButton;

    @FindBy (xpath = "//div[@class='your-profile']//p//a")
    private WebElement myAccountButton;


    @FindBy (id="nowa_polka")
    private WebElement addNewShelfInput;

    @FindBy (xpath = "//div[@class='toast_message']")
    private WebElement shelfAddedCorrectlyMessage;

    @FindBy (xpath = "//div[@class='add-list']")
    private WebElement addNewShelf;

    @FindBy (xpath = "//div[@id='add-to-board-container']//button[@type='submit']")
    private WebElement saveShelf;

    @FindBy (id = "customer_details_imie")
    private WebElement editNameInput;

    @FindBy (id = "customer_details_nazwisko")
    private WebElement editLastNameInput;

    @FindBy (id = "customer_details_telefon")
    private WebElement editTelephoneInput;

    @FindBy (xpath = "//button[@class='button account-order-data']")
    private WebElement saveNewDataUserButton;

    @FindBy (xpath = "//a[@class='addNewAddress addNewShipmentAddress ']")
    private WebElement addNewaddress;

    @FindBy (id = "inputNameOrCompany22")
    private WebElement personInput;

    @FindBy (id = "inputStreet22")
    private WebElement streetInput;

    @FindBy (id = "inputNumber22")
    private WebElement houseNumberInput;

    @FindBy (id = "inputZipCode22")
    private WebElement zipCodeInput;

    @FindBy (id = "inputCity22")
    private WebElement cityInput;

    @FindBy (xpath = "//button[@class='button adres']")
    private WebElement saveShippingInformationButton;

    @FindBy (xpath = "//div[@class='usermenu-box ']//strong[text()='Edycja konta']")
    private WebElement editAccountButton;

    @FindBy (xpath = "//div[@class='usermenu-box  active']//a[text()='Dane zamawiającego']")
    private WebElement shippingUserInformationButton;


    public AccountPage moveToMyAccountButton() {
        Actions action = new Actions(driver);
        action.moveToElement(myAccountButton).perform();
        return new AccountPage(driver);
    }

    public String logOff() {
        logOffButton.click();
        return logOffText.getText();
    }

    public String addShelf(String shelfName) {
        myAccountButton.click();
        shelfsButton.click();
        addNewShelf.click();
        addNewShelfInput.sendKeys(shelfName);
        saveShelf.click();
        shelfAddedCorrectlyMessage.isDisplayed();
        return shelfAddedCorrectlyMessage.getText();
    }

    public void editUserInformations() {
        editAccountButton.click();
        shippingUserInformationButton.click();
        editNameInput.sendKeys(randomWord);
        editLastNameInput.sendKeys(randomWord);
        editTelephoneInput.sendKeys("" + randomNumber +"");
        saveNewDataUserButton.click();
        addNewaddress.click();
        personInput.sendKeys(randomWord);
        streetInput.sendKeys(randomWord);
        houseNumberInput.sendKeys("" + randomNumber +"");
        zipCodeInput.sendKeys("" + randomNumber +"");
        cityInput.sendKeys(randomWord);
        saveShippingInformationButton.click();
    }
}
