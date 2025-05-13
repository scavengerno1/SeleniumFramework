package part2.org.saucedemo.tests.base;

import com.saucedemo.BasePage;
import com.saucedemo.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    private String url = "https://www.saucedemo.com/v1/";

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        loginPage = new LoginPage();
        basePage.setDriver(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
