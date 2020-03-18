package managers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static final String INTERNETEXPLORER_DRIVER_PROPERTY = "webdriver.ie.driver";

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if(driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL : driver = createLocalDriver();
                break;
            case REMOTE : driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {

        // Change this to match the location of your server
        URL server = null;
        try {
            server = new URL(FileReaderManager.getInstance().getConfigReader().getRemoteServer());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch(driverType){

            case CHROME:
                capabilities.setBrowserName("chrome");
                driver = new RemoteWebDriver(server, capabilities);
                break;

            case FIREFOX:
                capabilities.setBrowserName("firefox");
                driver = new RemoteWebDriver(server, capabilities);
                break;
        }
        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX :
                System.setProperty(FIREFOX_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath("fdriverPath"));
                driver = new FirefoxDriver();
                break;
            case CHROME :
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath("cdriverPath"));
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER :
                System.setProperty(INTERNETEXPLORER_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath("iedriverPath"));
                driver = new InternetExplorerDriver();
                break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }


}