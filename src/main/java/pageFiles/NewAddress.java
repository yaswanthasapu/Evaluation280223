package pageFiles;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddress {
    public WebDriver driver;

    public NewAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//div[@class='new-address-popup']/button")
    WebElement NewAddress;


    public void entryField() throws InterruptedException {
        Thread.sleep(5000);
        NewAddress.click();


    }
}
