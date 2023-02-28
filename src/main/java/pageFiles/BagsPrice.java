package pageFiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BagsPrice {
    public WebDriver driver;

    public BagsPrice(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//h1[@class='page-title']/span")
      WebElement Name;
    @FindBy(xpath = "//span[text()='Add to Wish List']/parent::a")
    WebElement AddToWishlist;

    @FindBy(xpath = "//span[text()='Impulse Duffle']/../../following-sibling::div/following-sibling::div/div/button[@type='button']")
    WebElement AddToCart;

    @FindBy(xpath = "//span[text()='You have no items in your wish list.']")
    WebElement Alert;

    @FindBy(xpath = "//div/div[@data-block='minicart']")
    WebElement GoingToCart;

    @FindBy(xpath = "//button[text()='Proceed to Checkout']")
    WebElement ProceedToCheckout;







    public void highPrice(){

    List<WebElement> listofallprices = new ArrayList<WebElement>();

        listofallprices = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        List<Double> allproductsamount = new ArrayList<>();
        for (WebElement webElement : listofallprices) {
            allproductsamount.add(Double.parseDouble(webElement.getText().replace("$", "")));
        }System.out.println(Collections.max(allproductsamount));

        Double maxproductamount = Collections.max(allproductsamount);

        System.out.println("highest price of product : " + maxproductamount);



        WebElement highestpriceproduct= driver.findElement(By.xpath("//span[@data-price-type='finalPrice']/span[contains(.,'"+maxproductamount+"')]/parent::span/parent::span/parent::div/preceding-sibling::strong/a"));
        System.out.println("Highest price product : "+highestpriceproduct.getText());
        highestpriceproduct.click();


    }
    public void name(){
        if(true){
            assert Name.isDisplayed();
        }
        else{
            System.out.println(false);
        }


    }
    public void addToWishlist(){
        AddToWishlist.click();
    }
    public void addToCart() throws InterruptedException {
        Thread.sleep(5000);
        AddToCart.click();
        Alert.isDisplayed();
        System.out.println(Alert.getText());
    }
    public void goingToCart() throws InterruptedException {
        Thread.sleep(2000);
        GoingToCart.click();
    }
    public void proceedToCheckout(){
        ProceedToCheckout.click();
    }

}