package part1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    }

    @Test
    public void logIn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement user = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("username"))));
        WebElement password = driver.findElement(By.name("password"));

        WebElement loginButton = driver.findElement(By.tagName("button"));

        user.sendKeys("Admin");
        password.sendKeys("admin123");

        loginButton.click();

        WebElement dashboard = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h6"))));
        String actualResult = driver.findElement(By.tagName("h6")).getText();
        String expectedResult = "Dashboard";

        Assert.assertEquals(actualResult, expectedResult);
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
