package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class CommonPage {
    public WebDriver driver;

    public CommonPage(WebDriver driver){
        this.driver = driver;
    }

    @BeforeEach
    public void setUp(){
        
    }

    @AfterEach
    public void tearDown(){
        
    }
}
