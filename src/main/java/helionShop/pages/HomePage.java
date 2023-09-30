package helionShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "helloUser")
    private WebElement loginButton;

    @FindBy(id = "inputSearch")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='button']")
    private WebElement searchButton;

    @FindBy(xpath = "//nav[@class='main-menu']//a[text()='Książki']")
    private WebElement navBooksButton;


    public LoginPage clickLogin() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public SearchResultPage searchPhrase(String phrase) {
        searchInput.sendKeys(phrase);
        searchButton.click();
        return new SearchResultPage(driver);
    }
    public BooksPage goToBooks() {
        navBooksButton.click();
        return new BooksPage(driver);
    }






}
