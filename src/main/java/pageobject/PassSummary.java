package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PassSummary {

    @FindBy(how = How.NAME,using = "passFirst0")
    private WebElement edt_cust_fname;

    @FindBy(how = How.NAME,using = "passLast0")
    private WebElement edt_cust_lname;

    @FindBy(how = How.NAME,using = "pass.0.meal")
    private WebElement lst_mealpref;

    @FindBy(how = How.NAME,using = "creditCard")
    private WebElement lst_cc_type;

    @FindBy(how = How.NAME,using = "creditnumber")
    private WebElement edt_cc_number;

    @FindBy(how = How.NAME,using = "cc_exp_dt_mn")
    private WebElement lst_cc_expiry_month;

    @FindBy(how = How.NAME,using = "cc_exp_dt_yr")
    private WebElement lst_cc_expiry_year;

    @FindBy(how = How.NAME,using = "cc_frst_name")
    private WebElement edt_cc_fname;

    @FindBy(how = How.NAME,using = "cc_mid_name")
    private WebElement edt_cc_mname;

    @FindBy(how = How.NAME,using = "cc_last_name")
    private WebElement edt_cc_lname;

    @FindBy(how = How.NAME,using = "ticketLess")
    private WebElement chkbx_ticketLess;

    @FindBy(how = How.NAME,using = "billAddress1")
    private WebElement edt_billAddress1;

    @FindBy(how = How.NAME,using = "billAddress2")
    private WebElement edt_billAddress2;

    @FindBy(how = How.NAME,using = "billCity")
    private WebElement edt_billcity;

    @FindBy(how = How.NAME,using = "billState")
    private WebElement edt_billstate;

    @FindBy(how = How.NAME,using = "billZip")
    private WebElement edt_billzip;

    @FindBy(how = How.NAME,using = "billCountry")
    private WebElement lst_billcountry;

    @FindBy(how = How.XPATH,using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input")
    private WebElement chkbox_sameaddress;

    @FindBy(how = How.NAME,using = "delAddress1")
    private WebElement edt_delAddress1;

    @FindBy(how = How.NAME,using = "delAddress2")
    private WebElement edt_delAddress2;

    @FindBy(how = How.NAME,using = "delCity")
    private WebElement edt_delcity;

    @FindBy(how = How.NAME,using = "delState")
    private WebElement edt_delState;

    @FindBy(how = How.NAME,using = "delZip")
    private WebElement edt_delZip;

    @FindBy(how = How.NAME,using = "delCountry")
    private WebElement lst_delCountry;

    @FindBy(how = How.NAME,using = "buyFlights")
    private WebElement btn_buyFlights;
}
