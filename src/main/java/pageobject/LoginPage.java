package pageobject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.NAME,using = "userName")
    private WebElement txtbx_username;

    @FindBy(how = How.NAME,using = "password")
    private WebElement txtbx_pswd;

    @FindBy(how = How.NAME,using="login")
    private WebElement btn_signIn;

    @FindBy(how = How.XPATH,using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/font/font/b/font/font")
    private WebElement pg_title;

    public void mt_login(String uname,String pswd){
    	try {
    		txtbx_username.sendKeys(uname);
    		txtbx_pswd.sendKeys(pswd);
    		btn_signIn.click();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    public void After_Login(WebDriver driver,String Status) throws Exception{

    	String dStatus="FAIL";
    	
    	try {
	      if(pg_title.getText().equalsIgnoreCase("Flight Details")) {
	    	  dStatus="PASS";
	      }
    	}catch(Throwable e) {
    		e.printStackTrace();
    	}finally {  		
	        if (dStatus.equalsIgnoreCase(Status)) {
//	        	Reporter.addStepLog("Login Validation Successful");
	        }else {
//	           	Reporter.addStepLog("Login Validation Not Successful");
//			    Reporter.addScreenCaptureFromPath(common.takeSnapShot(driver, "login_validation"));	
			    Assert.assertEquals("Login Validation : ", Status, dStatus);
	        }
    	}
    }
}