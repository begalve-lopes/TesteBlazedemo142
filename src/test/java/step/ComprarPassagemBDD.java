package step;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ComprarPassagemBDD {

    private WebDriver driver;
    String origem;
    String destino;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Dado("que acesso o site {string}")
    public void que_acesso_o_site(String url) {
        driver.get(url);
    }

    @Quando("seleciono a origem {string} e destino {string}")
    @Quando("seleciono a {string} e {string}")
    public void seleciono_a_origem_e_destino(String origem, String destino) {

        this.origem = origem;
        WebElement origin = driver.findElement(By.name("fromPort"));
        origin.click();
        origin.findElement(By.xpath("//option[. = '" + origem + "']")).click();

        this.destino = destino;
        WebElement destination = driver.findElement(By.name("toPort"));
        destination.click();
        destination.findElement(By.xpath("//option[. = '" + destino + "']")).click();
    }

    @Quando("clico no botao Find Flights")
    public void clico_no_botao_find_flights() {
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @Entao("visualiza a lista de voos")
    public void visualiza_a_lista_de_voos() {
        assertEquals(
            "Flights from " + origem + " to " + destino + ":",
            driver.findElement(By.cssSelector("h3")).getText()
        );

        System.out.println("Passagem comprada com sucesso!");
        
    }
}
