package StepDefinition;

import managers.WebDriverManager;
import org.openqa.selenium.By;
import pageobject.FlightDetails;
import pageobject.HomePage;
import pageobject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Steps {
    // code optimized creating below class variable
    WebDriver driver;
    HomePage home;
    LoginPage login;
    FlightDetails fd;

    @Before
    public void before(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("------------------------------");
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("------------------------------");
        driver.close();
        driver.quit();
    }
 
    @Given("Launch Browser Chrome in Local environment.")
    public void Launch_Browser() throws Throwable {
        WebDriverManager wdm = new WebDriverManager();
        driver = wdm.getDriver();
    }
    @Given("^Navigate to Home Page \"(.*)\"$")
    public void Navigate_to_Home_Page(String Url) throws Throwable {
        home = new HomePage(driver);
        home.navigateTo_HomePage(Url);
    }
    @When("Validate Login screen")
    public void login_screen() throws Throwable{
        home = new HomePage(driver);
        home.Home_Screen();
    }
    @When("Login to Mercury Site using username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_is_login(String uname,String psw) throws Throwable {
        login=new LoginPage(driver);
        login.mt_login(uname,psw);
    }
    @Then("^Login \"([^\"]*)\"$")
    public void login_sucess(String str) throws Throwable {
        login=new LoginPage(driver);
        login.After_Login(driver,str);
//        driver.close();
    }
    @Given("^Select Trip as \"(.*)\"$")
    public void select_trip_type(String str) throws Throwable {
        fd= new FlightDetails(driver);
        fd.select_trip_type(str);
    }
    @Given("^Select number of passenger from list is \"(.*)\"$")
    public void select_passenger(String str) throws Throwable {
        fd= new FlightDetails(driver);
        fd.select_passenger(str);
    }
    @Given("^Departing from \"(.*)\" on date, month \"(.*)\" day \"(.*)\"$")
    public void enter_departure_details(String str,String str2,String str3) throws Throwable {
        fd= new FlightDetails(driver);
        fd.enter_departure_details(str,str2,str3);
    }
    @Given("^Arriving In \"(.*)\" return date, month \"(.*)\" day \"(.*)\"$")
    public void enter_arrival_details(String str,String str2,String str3) throws Throwable {
        fd= new FlightDetails(driver);
        fd.enter_arrival_details(str,str2,str3);
    }
    @Given("^Ticket Preference \"(.*)\" and select airline from list \"(.*)\"$")
    public void flight_pref_and_airline(String str,String str2) throws Throwable {
        fd= new FlightDetails(driver);
        fd.flight_pref_and_airline(str,str2);
    }
    @Then("continue to select flight")
    public void find_flightdetails() throws Throwable {
        fd= new FlightDetails(driver);
        fd.find_flightdetails();
        driver.close();
    }
//    @When("^Login to Mercury Site Credentials using username and password$")
//    public void datatable_cucumber(DataTable usercredentials){
//        //Write the code to handle Data Table
//        List<List<String>> data = usercredentials.cells();
//
//        login=new LoginPage(driver);
//        login.mt_login(data.get(0).get(0),data.get(0).get(1));
//        //This is to get the first data of the set (First Row + First Column) (data.get(0).get(0));
//
//        //This is to get the first data of the set (First Row + Second Column) (data.get(0).get(1));
//
//        driver.findElement(By.id("login")).click();
//    }
 
}
