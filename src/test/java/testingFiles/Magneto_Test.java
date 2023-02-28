package testingFiles;

import baseFiles.MagentoBaseSetup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pageFiles.BagsPrice;
import pageFiles.HomePage;
import pageFiles.Login_Magneto;
import pageFiles.NewAddress;
import shippingAddress.ShipingAddressPage;

import java.io.IOException;

public class Magneto_Test extends MagentoBaseSetup {

    Login_Magneto login;
    HomePage home;
    BagsPrice pricesort;
    NewAddress newAddress;
    ShipingAddressPage shipingAddressPage;

    @Test
    public void Task1() throws InterruptedException, IOException, ParseException {
        login = new Login_Magneto(driver);
        home=new HomePage(driver);
        pricesort=new BagsPrice(driver);
        newAddress=new NewAddress(driver);
        shipingAddressPage=new ShipingAddressPage(driver);

        login.webelementPerform();
        home.selectBag();
        pricesort.highPrice();
        pricesort.name();

        Thread.sleep(1000);
        pricesort.addToWishlist();
        pricesort.addToCart();
        pricesort.goingToCart();
        pricesort.proceedToCheckout();
        driver.navigate().refresh();
        newAddress.entryField();
       // Thread.sleep(3000);

        shipingAddressPage.fillShippingAddress();
        shipingAddressPage.cancelAndNextButton();
        shipingAddressPage.placeOrderButton();
        shipingAddressPage.Checkout();




    }
}
