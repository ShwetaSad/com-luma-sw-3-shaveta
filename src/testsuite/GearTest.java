package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utility;

import java.time.Duration;
import java.util.Locale;

public class GearTest extends Utility {

    String  baseUrl = "https://magento.softwaretestingboard.com/";


    @Before
    public void open(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
        //clicking consent on popup
        clickOnElement(By.xpath("//p[@class='fc-button-label']"));
        //mouse hover on Gear
        mouseHoverToElement(By.xpath("//span[normalize-space()=\"Gear\"]"));
        // mouse hover on bags and click
        mouseHoverToElementAndClick(By.xpath("//span[normalize-space()=\"Bags\"]"));
// click on x popup
        //clickOnElement(By.xpath("//div[@id=\"cbb\"]//*[name()=\"svg\"]"));
        //mouse hover on duffle bag
        mouseHoverToElement(By.xpath("//img[@alt=\"Overnight Duffle\"]"));

        // click on product overnight duffle
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()=\"Overnight Duffle\"]"));


        // verify the text Overnight duffle
        String expectText = "Overnight Duffle";
        String actualText = getTextFromElement(By.xpath("//span[@class=\"base\"]"));
        Assert.assertEquals("Wrong Product",expectText,actualText);
// clear text from qnty field
        driver.findElement(By.xpath("//input[@id=\"qty\"]")).clear();
        // change quantity to 3
        sendTextToAlert("3");
        //click on add to cart
clickOnElement(By.xpath("//span[normalize-space()=\"Add to Cart\"]"));
// verify text you  added Overnight duffle to your shopping cart
        String expectedtext = "You added Overnight Duffle to your shopping cart";
        String actualtext = driver.findElement(By.xpath("//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")).getText();
        Assert.assertEquals("Wrong product",expectedtext,actualtext);
        // click on shopping cart
        clickOnElement(By.xpath("//a[normalize-space()=\"shopping cart\"]"));
        // verify product is Overnight Duffle
        String expectedPoduct = "Overnight Duffle";
        String actualProduct = getTextFromElement(By.cssSelector("td[class=\"col item\"] div[class=\"product-item-details\"] a"));
        Assert.assertEquals("Wrong Product",expectedPoduct,actualProduct);

        //Verify Qty is 3
        String expectedQty ="3" ;
       String actualqty = driver.findElement(By.xpath("td[class=\"col item\"] div[class=\"product-item-details\"] a")).getText();
        int quantity = Integer.parseInt(actualqty);

        Assert.assertEquals("invalid Quantity",expectedQty,quantity);
        // change the qty to 5
        driver.findElement(By.xpath("//input[@id=\"cart-431750-qty\"]")).clear();
        // change quantity to 5
        sendTextToAlert("5");
        // update shopping cart
        clickOnElement(By.xpath("//span[normalize-space()=\"Update Shopping Cart\"]"));
        //Verify the Price is $225

       String expectedPrice = "$225.00";
       String actualPrice = driver.findElement(By.xpath("//span[@class=\"cart-price\"]//span[@class=\"price\"][normalize-space()=\"$225.00\"]")).getText();
       Assert.assertEquals("Incorrect Quantity",expectedPrice,actualPrice);







    }

}
