package helionShop.tests;

import helionShop.pages.AccountPage;
import helionShop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

    @Test
    public void addingNewShelf() {
        new HomePage(driver).clickLogin().loginToAccount(getEmail(),getPassword());
        String x = new AccountPage(driver).addShelf(randomWord);
        Assert.assertEquals(x,"Twoja półka \"" + randomWord + "\" została dodana.");
    }

    @Test
    public void editUserInfo() {
        new HomePage(driver).clickLogin().loginToAccount(getEmail(),getPassword());
        new AccountPage(driver).editUserInformations();
    }


}
