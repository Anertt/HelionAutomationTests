package helionShop.tests;

import helionShop.pages.NaviBar;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class NaviTests extends BaseTest{

    @Test
    public void naviBarTest() {
        new NaviBar(driver).clickNaviLinks();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://program-partnerski.helion.pl/", currentUrl);
    }
}
