package helionShop.tests;

import helionShop.utils.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class baseTest {
    protected WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://helion.pl/");
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    }


    @BeforeMethod
    public void x() {
        WebElement rodo = driver.findElement(By.id("rodo-ok"));
        rodo.click();
    }


    private String email = "pinglusik@gmail.com";

    public String getEmail() {
        return email;
    }

    private String password = "a!eWgzXQPKr6qC7";

    protected String randomWord = RandomStringUtils.randomAlphabetic(8);
    protected int randomNumber = (int) (Math.random() * 1000);


    public String getPassword() {
        return password;
    }
}
