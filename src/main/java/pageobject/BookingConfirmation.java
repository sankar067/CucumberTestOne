package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BookingConfirmation {


    @FindBy(how = How.XPATH,using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/b/font/font/b/font[1]")
    private WebElement elmnt_cnfrm_id;

    @FindBy(how = How.XPATH,using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/font/b")
    private WebElement elmnt_cnfrm_date;

    @FindBy(how = How.XPATH,using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[1]/a/img")
    private WebElement btn_back;

    @FindBy(how = How.XPATH,using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[2]/a/img")
    private WebElement btn_home;

    @FindBy(how = How.XPATH,using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[3]/a/img")
    private WebElement btn_logout;
}
