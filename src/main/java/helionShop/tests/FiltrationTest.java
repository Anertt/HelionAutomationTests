package helionShop.tests;

import helionShop.pages.HomePage;
import org.testng.annotations.Test;

public class filtrationTest extends baseTest {
    @Test
    public void useFilters() throws InterruptedException {
        new HomePage(driver).goToBooks().setFilters("20","40");
    }


}
