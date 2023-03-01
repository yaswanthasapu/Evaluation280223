package shippingAddress;
import ReadfromFile.Readfromjson;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import seleniumActions.SeleniumActions;

import java.io.IOException;

public class ShipingAddressPage {
    WebDriver driver;
SeleniumActions seleniumActions;
    Readfromjson readfromjson;
    public ShipingAddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions=new SeleniumActions(driver);
        readfromjson = new Readfromjson();
    }


    @FindBy (xpath = "//input[@ name='company']")
    WebElement companytextfield;

    @FindBy (xpath ="//input[@ name='street[0]']")
    WebElement addressline1;

    @FindBy(xpath = "//input[@ name='street[1]']")
    WebElement addressline2;

    @FindBy(xpath = "//input[@ name='street[2]']")
    WebElement addressline3;

    @FindBy(xpath = "//input[@ name='city']")
    WebElement citytextfield;

    @FindBy(xpath = "//select[@ name='region_id']")
    WebElement statedropdown;
    @FindBy(xpath = "//input[@ name='postcode']")
    WebElement postcodetextfield;

    @FindBy(xpath = "//select[@ name='country_id']")
    WebElement countrydropdown;

    @FindBy(xpath = "//input[@name='telephone']")
    WebElement phonenumbertextfield;

    @FindBy(xpath = "//span[text()='Cancel']")
    WebElement cancel;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement next;

    @FindBy(xpath = "//div[@class='checkout-billing-address']/div/input[@type='checkbox']")
    WebElement addressCheckBox;
    @FindBy(xpath = "//div[@class='checkout-agreements-block']/following-sibling::div/div[@class='primary']")
    WebElement placeorder;

    @FindBy(xpath = "//div[@class='checkout-success']/p/a")
    WebElement checkout;

//@FindBy(xpath="//div[@class='order-date']")
//WebElement currentDate;

@FindBy(xpath = "//span[@class='base']")
WebElement ordernum;

    public void fillShippingAddress() throws IOException, InterruptedException {
        seleniumActions.EnterValueOnTextfield(companytextfield,readfromjson.readFile("company"));
        seleniumActions.EnterValueOnTextfield(addressline1, readfromjson.readFile("address1"));
        seleniumActions.EnterValueOnTextfield(addressline2, readfromjson.readFile("address2"));
        seleniumActions.EnterValueOnTextfield(addressline3, readfromjson.readFile("address3"));
        seleniumActions.EnterValueOnTextfield(citytextfield,readfromjson.readFile("city"));
        Thread.sleep(1000);
        seleniumActions.selectValueFromDropDown(countrydropdown,readfromjson.readFile("countryvalue"),"value");
        seleniumActions.selectValueFromDropDown(statedropdown,readfromjson.readFile("statevalue"), "value");
        seleniumActions.EnterValueOnTextfield(postcodetextfield,readfromjson.readFile("postcode"));

        seleniumActions.EnterValueOnTextfield(phonenumbertextfield,readfromjson.readFile("phone"));
    }
    public void cancelAndNextButton(){

     seleniumActions.clickOnElement(cancel);
     seleniumActions.clickOnElement(next);
    }
    public void placeOrderButton() throws InterruptedException {
        Thread.sleep(5000);
//        Actions actions=new Actions(driver);
//        actions.moveToElement(placeorder).click().perform();

        //seleniumActions.clickOnElement(placeorder);
        placeorder.click();
    }
    public void Checkout() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(checkout.isDisplayed());
        System.out.println("Your order number : " + checkout.getText());
        checkout.click();
        Assert.assertTrue(ordernum.isDisplayed());


    }

}