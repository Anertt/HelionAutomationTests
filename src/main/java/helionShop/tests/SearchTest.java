package helionShop.tests;

import helionShop.pages.HomePage;
import helionShop.pages.SearchResultPage;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void findAndAddToCart() {
        new HomePage(driver).clickLogin().loginToAccount(getEmail(),getPassword());
        new HomePage(driver).searchPhrase("selenium").chooseBook().click();
        new SearchResultPage(driver).addToCart().checkButtons().clearForm()
                .fillOrderForm("Test name", "Test last name",
                        "12345678", "Test street", "123",
                        "22-222", "Test city");
    }
}
