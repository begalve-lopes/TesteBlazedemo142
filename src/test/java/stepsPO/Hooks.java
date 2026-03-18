package stepsPO;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Base;
public class Hooks {
     Base base;

    public Hooks(Base base) {
        this.base = base;
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        base.driver= new ChromeDriver();
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
    }

    @After
    public void tearDown() {
        base.driver.quit();
    }

}
