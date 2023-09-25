package helionShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//div[@class='book-info']")
    private List<WebElement> searchedBooks;

    @FindBy(id="addToBasket_sewebd")
    WebElement addToCartButton;

    @FindBy(id="cena_d")
    WebElement price;

    @FindBy(xpath = "//p[@class='logo']")
    WebElement moveToHomePageButton;
    public WebElement chooseBook() {
        return searchedBooks.stream().findFirst().get();
    }

    public CartPage addToCart() {
        addToCartButton.click();
        return new CartPage(driver);
    }

    public SearchResultPage moveToHomePage() {
        moveToHomePageButton.click();
        return new SearchResultPage(driver);
    }


}
