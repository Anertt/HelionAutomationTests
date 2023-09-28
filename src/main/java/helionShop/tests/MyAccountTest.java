package helionShop.tests;

import helionShop.pages.AccountPage;
import helionShop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class myAccountTest extends baseTest{

    @Test
    public void addingNewShelf() {
        new HomePage(driver).clickLogin().loginToAccount(getEmail(),getPassword());
        String x = new AccountPage(driver).addShelf(randomWord);
        Assert.assertEquals(x,"Twoja półka \"" + randomWord + "\" została dodana.");
    }

    @Test
    public void ds() {
        new HomePage(driver).clickLogin().loginToAccount(getEmail(),getPassword());
        new AccountPage(driver).editUserInformations();
    }


}
