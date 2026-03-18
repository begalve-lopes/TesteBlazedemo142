package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservePage extends CommonPage {
    public ReservePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //mapeamento

    @FindBy(css = "h3")
    WebElement flightsHeader;

    public By byOrdem(int ordem_do_voo) {
        return By.xpath("//table/tbody/tr[" + ordem_do_voo + "]//input");
    }

    //acoes

    public String lerCabecalhoVoos() {
        return flightsHeader.getText();
    }

    public void cliclarNoVoo(int orderm_do_voo){
        driver.findElement(byOrdem(orderm_do_voo)).click();
    }

}
