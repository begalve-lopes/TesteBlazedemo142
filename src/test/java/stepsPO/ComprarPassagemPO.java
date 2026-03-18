package stepsPO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import pages.Base;
import pages.HomePage;
import pages.ReservePage;

public class ComprarPassagemPO {

    final WebDriver driver;
    private HomePage homePage;
    private ReservePage reservePage;
    public String origem;
    public String destino;

    public ComprarPassagemPO(Base base) {
        this.driver = base.driver;
        homePage = new HomePage(driver);
        reservePage = new ReservePage(driver);
    }

    @Dado("que acesso o site {string} PO")
    public void que_acesso_o_site_po(String url) {
        homePage.acessarHomePage(url);
        assertEquals("BlazeDemo", homePage.lerNomeDaGuia());
    }

    @Quando("seleciono a {string} e {string} PO")
    public void seleciono_a_e_po(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        homePage.selecionarOrigemDestino(origem, destino);

        synchronized (driver) {
            try {
                driver.wait(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Quando("clico no botao Find Flights PO")
    public void clico_no_botao_find_flights_po() {
        homePage.clicarBotaoFindFlights();
    }

    @Entao("visualiza a lista de voos PO")
    public void visualiza_a_lista_de_voos_po() {
        assertEquals("BlazeDemo - reserve", reservePage.lerNomeDaGuia());
        assertEquals("Flights from " + this.origem + " to " + this.destino + ":", reservePage.lerCabecalhoVoos());
        System.out.println("Passagem comprada com sucesso!");
        synchronized (driver) {
            try {
                driver.wait(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Quando("cliclo na {int} PO")
    public void cliclo_na_po(Integer ordem_do_voo) {
       reservePage.cliclarNoVoo(ordem_do_voo);
        synchronized (driver) {
            try {
                driver.wait(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
