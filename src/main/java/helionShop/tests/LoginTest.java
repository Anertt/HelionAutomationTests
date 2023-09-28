package helionShop.tests;

import helionShop.pages.AccountPage;
import helionShop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithCorrectData() {
        new HomePage(driver).clickLogin().loginToAccount(getEmail(), getPassword());
    }

    @Test
    public void loginWithWrongData() {
        String error = new HomePage(driver)
                .clickLogin().loginToAccount("test@o2.pl", "test").getErrorText();

        Assert.assertEquals("Niestety podałeś niewłaściwy adres email lub hasło.", error);
    }

    @Test
    public void logOffAccount() {
        new HomePage(driver).clickLogin().loginToAccount(getEmail(), getPassword());
        String loggOffMessage = new AccountPage(driver).moveToMyAccountButton().logOff();
        Assert.assertEquals("Zostałeś poprawnie wylogowany", loggOffMessage);
    }
}
