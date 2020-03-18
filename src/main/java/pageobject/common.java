package pageobject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class common {

    WebDriver driver;
    TakesScreenshot screenshot;
    
    public common(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void select_value_from_dropdown(WebElement sPropertyObject, String sValue){
    	try {
        Select list_pc = new Select(sPropertyObject);
        list_pc.selectByValue(sValue);
    	}catch(Throwable e){
    		e.printStackTrace();
    	}
    }
    
    public static String takeSnapShot(WebDriver webdriver,String screenshotName) throws Exception{

    	 //below line is just to append the date format with the screenshot name to avoid duplicate names 
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(SrcFile, finalDestination);
		return destination;
    }

}
