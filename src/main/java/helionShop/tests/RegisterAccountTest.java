package helionShop.tests;

import helionShop.pages.HomePage;
import helionShop.pages.RegisterAccountPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterAccountTest extends BaseTest{

    @Test
    public void registerAccountTestsInvalidData() {
        String errorTextWrongEmailPasswordsAndRegulations = new HomePage(driver).clickLogin()
                .clickRegisterButton().registerAccount("test", "test", "test").createAccount();
        String errorTextWrongEmailAndPasswords = new RegisterAccountPage(driver).accpetRegulations();
        String errorTextWrongPasswords = new RegisterAccountPage(driver).clearForm()
                .registerAccount("test@o2.pl", "test", "test").createAccount();
        String errorTextDifferentPasswords = new RegisterAccountPage(driver).clearForm().
                registerAccount("test@o2.pl", "test", "tessst").createAccount();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Podanie poprawnego emaila jest konieczne do dokończenia procesu rejestracji\n" +
                "Hasło za słabe(Dobre hasło składa się z dużych i małych liter, cyfr oraz znaków specjalnych).\n" +
                "Musisz zaakceptować regulamin",errorTextWrongEmailPasswordsAndRegulations);
        softAssert.assertEquals("Podanie poprawnego emaila jest konieczne do dokończenia procesu rejestracji\n" +
                "Hasło za słabe(Dobre hasło składa się z dużych i małych liter, cyfr oraz znaków specjalnych).", errorTextWrongEmailAndPasswords);
        softAssert.assertEquals("Hasło za słabe(Dobre hasło składa się z dużych i małych liter, cyfr oraz znaków specjalnych).",
                errorTextWrongPasswords);
        softAssert.assertEquals("Hasło za słabe(Dobre hasło składa się z dużych i małych liter, cyfr oraz znaków specjalnych).\n" +
                "Hasła muszą się zgadzać", errorTextDifferentPasswords);
        softAssert.assertAll();
    }
}
