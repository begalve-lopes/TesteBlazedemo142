package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservePage  extends CommonPage{
    public ReservePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    
    @FindBy(css = "h3")
    WebElement flightsHeader;

    public String lerCabecalhoVoos(){
        return flightsHeader.getText();
    }

    
}
