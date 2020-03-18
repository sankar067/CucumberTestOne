package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SelectFlight {

    WebDriver driver;
    public SelectFlight(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.NAME,using = "outFlight")
    private WebElement radio_depart;

    @FindBy(how = How.NAME,using = "inFlight")
    private WebElement radio_return;

    @FindBy(how = How.NAME,using = "reserveFlights")
    private WebElement btn_reserveFlights;

}
