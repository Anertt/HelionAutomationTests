package helionShop.tests;

import helionShop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FiltrationTest extends BaseTest {
    @Test
    public void useFilters() throws InterruptedException {
        String actualAuthor = new HomePage(driver).goToBooks().setFilters("20","40");
        Assert.assertEquals("Paulina Mechło - książki", actualAuthor);
    }


}
