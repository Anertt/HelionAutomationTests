package helionShop.tests;

import helionShop.pages.HomePage;
import org.testng.annotations.Test;

public class FiltrationTest extends BaseTest {
    @Test
    public void useFilters() throws InterruptedException {
        new HomePage(driver).goToBooks().setFilters("20","40");
    }


}
