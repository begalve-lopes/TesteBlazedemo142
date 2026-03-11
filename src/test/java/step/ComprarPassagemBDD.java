package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ComprarPassagemBDD {

    private WebDriver driver;


    @Dado("que acesso o site {string}")
    public void que_acesso_o_site(String url) {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Quando("seleciono a origem {string} e destino {string}")
    public void seleciono_a_origem_e_destino(String origem, String destino) {
        
        WebElement oriElement = driver.findElement(By.name("fromPort"));
        Select origemDropdown = new Select(oriElement);
        origemDropdown.selectByVisibleText(origem);

        WebElement desElement = driver.findElement(By.name("toPort"));
        Select destinoDropdown = new Select(desElement);
        destinoDropdown.selectByVisibleText(destino);

    }

    @Quando("clico no botao Find Flights")
    public void clico_no_botao_find_flights() {
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @Entao("visualiza a lista de voos")
    public void visualiza_a_lista_de_voos() {
        driver.findElement(By.cssSelector("table.table"));
          System.out.println("Lista de voos exibida");
        driver.quit();
    }
}
