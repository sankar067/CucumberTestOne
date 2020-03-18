package pageobject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightDetails {
    WebDriver driver;

    public FlightDetails(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.CSS, using = "[type='radio'][value='roundtrip']")
    public WebElement roundTrip;

    @FindBy(how = How.CSS, using = "[type='radio'][value='oneway']")
    public WebElement oneWay;

    @FindBy(how = How.NAME,using = "passCount")
    private WebElement list_PassengerCount;

    @FindBy(how = How.NAME,using = "fromPort")
    private WebElement list_fromPort;

    @FindBy(how = How.NAME,using = "fromMonth")
    private WebElement list_fromMonth;

    @FindBy(how = How.NAME,using = "fromDay")
    private WebElement list_fromDay;

    @FindBy(how = How.NAME,using = "toPort")
    private WebElement list_toPort;

    @FindBy(how = How.NAME,using = "toMonth")
    private WebElement list_toMonth;

    @FindBy(how = How.NAME,using = "toDay")
    private WebElement list_toDay;

    @FindBy(xpath = "//input[@value='Business']")
    private WebElement businessRadio;

    @FindBy(xpath = "//input[@value='First']")
    private WebElement FirstRadio;

    @FindBy(xpath = "//input[@value='Coach']")
    private WebElement EconomyRadio;

    @FindBy(how = How.NAME,using = "airline")
    private WebElement list_airline;

    @FindBy(how = How.NAME,using = "findFlights")
    private WebElement btn_findFlights;

   public void select_trip_type(String tripType){

       try {
           if (tripType.replaceAll(" ","").toLowerCase().equals("roundtrip")) {
               roundTrip.click();
           }else if (tripType.replaceAll(" ","").toLowerCase().equals("oneway")) {
               oneWay.click();
           }else {
        	   Assert.fail("Enter correct data for the trip");
               System.out.println("Enter correct data for the trip : One way|oneway|Round Trip|Roundtrip");
             }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   public void select_passenger(String pc){
       //Select Value from Dropdown
       Select list_pc = new Select(list_PassengerCount);
       list_pc.selectByValue(pc);
   }
   public void enter_departure_details(String sVal1,String sVal2,String sVal3){
       Select list_pc = new Select(list_fromPort);
       list_pc.selectByValue(sVal1);
       Select mnth = new Select(list_fromMonth);
       mnth.selectByVisibleText(sVal2);
       Select day = new Select(list_fromDay);
       day.selectByValue(sVal3);

   }
    public void enter_arrival_details(String sVal1,String sVal2,String sVal3){
        Select list_pc = new Select(list_toPort);
        list_pc.selectByValue(sVal1);
        Select mnth = new Select(list_toMonth);
        mnth.selectByVisibleText(sVal2);
        Select day = new Select(list_toDay);
        day.selectByValue(sVal3);
    }
    public void flight_pref_and_airline(String sVal1,String sVal2){

        try {
            if (sVal1.replaceAll(" ","").toLowerCase().equals("economyclass")) {
                EconomyRadio.click();
            }
            else if (sVal1.replaceAll(" ","").toLowerCase().equals("businessclass")) {
                businessRadio.click();
            }
            else if (sVal1.replaceAll(" ","").toLowerCase().equals("firstclass")) {
                FirstRadio.click();
            }
            else {
                System.out.println("Enter correct data for the trip : Business class | businessclass" +
                        "|First class|firstclass" +
                        "| Economy class|economyclass" );
            }
            Select aline = new Select(list_airline);
            aline.selectByVisibleText(sVal2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void find_flightdetails(){
        btn_findFlights.click();
    }
}
