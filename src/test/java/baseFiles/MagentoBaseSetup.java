package baseFiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MagentoBaseSetup {
    protected WebDriver driver;
    @BeforeSuite
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @BeforeClass
//    public void openApp()
//    {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://magento.softwaretestingboard.com/customer/account/");
//    }
    public void lamdatest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        ChromeOptions chromeOptions=new ChromeOptions();
        desiredCapabilities.setCapability("browser", "chrome");
        desiredCapabilities.merge(chromeOptions);
        driver=new RemoteWebDriver(new URL("https://yaswanthasapu946:vxVgfCdo89tpuQxLTiOM2nSk17zP9KZw1RB46dxZinNzisN0SR@hub.lambdatest.com/wd/hub"),chromeOptions);
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
    }
    @AfterClass
    public void quit(){
       driver.quit();
    }
}
