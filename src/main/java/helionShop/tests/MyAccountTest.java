package helionShop.tests;

import helionShop.pages.AccountPage;
import helionShop.pages.HomePage;
import org.openqa.selenium.Alert;
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

    @Test
    public void editInvalidUserEmail() {
        new HomePage(driver).clickLogin().loginToAccount(getEmail(),getPassword());
        String errorText = new AccountPage(driver).clickSaveEmailButton().getWrongEmailText();
        Assert.assertEquals("Przykro nam. Zmiana adresu email nie była możliwa, w bazie istnieje już konto o podanym adresie email", errorText);
    }

    @Test
    public void invalidDataUserInfo() {
        new HomePage(driver).clickLogin().loginToAccount(getEmail(),getPassword());
        new AccountPage(driver).clearFormDaneZamawiajacego();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "\n" +
                "Brak nazwiska.");
        alert.accept();
        String errorTextNoData = new AccountPage(driver).getErrorChangePassword();
        Assert.assertEquals(errorTextNoData, "Podanie starego hasła jest wymagane.\n" +
                "Wprowadź hasło (min. 12 znaków).\n" +
                "Wprowadź hasło (min. 12 znaków).");
        String errorDifferentPassText = new AccountPage(driver).differentPassword();
        Assert.assertEquals(errorDifferentPassText, "Podanie starego hasła jest wymagane.\n" +
                "Wprowadź hasło (min. 12 znaków).\n" +
                "Wprowadzone hasła nie są identyczne.");
        String wrongEmailText = new AccountPage(driver).newEmail();
        Assert.assertEquals(wrongEmailText, "Podaj właściwy adres email.");
    }



}
