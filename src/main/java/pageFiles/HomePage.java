package pageFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    // @FindBy(xpath = "//span[text()='Gear']//../following-sibling::ul/li/a/span[text()='Bags']")

    @FindBy(xpath="//span[text()='Gear']")
    WebElement gear;
    @FindBy(xpath = "//span[text()='Bags']")
    WebElement Bags;

    @FindBy(xpath="//a[@class='action showcart']")
    WebElement cart;

    @FindBy(xpath = "//div[contains(@class,'block block-minicart ')]")
    WebElement emptycart;

    public void selectBag() throws InterruptedException {
        Thread.sleep(10);
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).perform();
        Thread.sleep(1000);
        actions.moveToElement(Bags).click().perform();
        cart.click();
        Assert.assertTrue(emptycart.isDisplayed());
        System.out.println(emptycart.getText());
    }
}