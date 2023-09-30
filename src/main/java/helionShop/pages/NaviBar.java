package helionShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NaviBar {

    private WebDriver driver;

    public NaviBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    String[] linkTexts = {
            "Książki", "Ebooki", "Videokursy", "Audiobooki", "Promocje", "Bestsellery", "PP"
    };

    public void clickNaviLinks() {
        for (String linkText : linkTexts) {
            WebElement link = driver.findElement(By.linkText(linkText));
            link.click();
        }
    }

}
