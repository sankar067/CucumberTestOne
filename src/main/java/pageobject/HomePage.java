package pageobject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.XPATH,using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
    private WebElement home_screen;

    public void navigateTo_HomePage(String Url) {
        driver.get(Url);
    }
    public void Home_Screen(){
  
    	try {
            Assert.assertEquals(home_screen.getText(),"SIGN-ON");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}