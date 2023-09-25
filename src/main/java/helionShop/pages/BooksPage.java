package helionShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {

    private WebDriver driver;

    public BooksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//label[@class='type-audiobook']")
    private WebElement audioBookfilter;

    @FindBy (xpath = "//label[@for='fd']")
    private WebElement helionCheckBoxFilter;

    @FindBy (id = "pricemin")
    private WebElement priceMin;

    @FindBy (id = "pricemax")
    private WebElement priceMax;

    @FindBy (id = "filter_submit")
    private WebElement filterButton;

    @FindBy (xpath = "//form[@class='aside-search notOnMobile']//input")
    private WebElement searchAuthorInput;

    @FindBy (xpath = "//li[contains(@class, 'suggest-autor')]")
    private WebElement firstAuthorSuggestion;

    @FindBy (xpath = "//p[@class='header link-authors-no-border notOnMobile']")
    private WebElement ourAuthors;

    public void setFilters(String minPrice, String maxPrice) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(audioBookfilter).perform();
        audioBookfilter.click();
        helionCheckBoxFilter.click();
        priceMin.sendKeys(minPrice);
        priceMax.sendKeys(maxPrice);
        action.moveToElement(ourAuthors).perform();
        searchAuthorInput.sendKeys("Mechło");
        Thread.sleep(2000);
        firstAuthorSuggestion.click();
        filterButton.click();
    }

}
