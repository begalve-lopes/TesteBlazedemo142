
//bibliotecas
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//criar a classe de teste
public class PassagemTest {
    // iniciar com as variaveis
    private WebDriver driver;

    @BeforeEach
    public void iniciar() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void fechar() {
        driver.quit();
    }

    @Test
    public void comprarPassagem() {
        driver.get("https://blazedemo.com/");

        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();

        }

        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.click();
            dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
        }

        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        assertEquals("Flights from São Paolo to New York:",
                driver.findElement(By.cssSelector("h3")).getText());

        driver.findElement(By.cssSelector("tr:nth-child(1)  input")).click();

        assertEquals("Your flight from TLV to SFO has been reserved.",
                driver.findElement(By.cssSelector("h2")).getText());

        driver.findElement(By.id("inputName")).sendKeys("Begas");
        driver.findElement(By.id("address")).sendKeys("Rua das Flores, 123");
        driver.findElement(By.id("city")).sendKeys("São Paulo");
        driver.findElement(By.id("state")).sendKeys("SP");
        driver.findElement(By.id("zipCode")).sendKeys("12345");
        driver.findElement(By.name("cardType")).click();
        {
            WebElement dropdown = driver.findElement(By.name("cardType"));
            dropdown.findElement(By.xpath("//*[@id=\"cardType\"]/option[1]"));
        }
        driver.findElement(By.id("creditCardNumber")).sendKeys("4111111111111111");
        driver.findElement(By.id("creditCardMonth")).sendKeys("12");
        driver.findElement(By.id("creditCardYear")).sendKeys("2025");
        driver.findElement(By.id("nameOnCard")).sendKeys("Begas");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        assertEquals("Thank you for your purchase today!",
                driver.findElement(By.cssSelector("h1")).getText());

        

    }

}