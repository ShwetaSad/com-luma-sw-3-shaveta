package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;
public class MenTest extends Utility {
  String  baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void open(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
        //clicking consent on popup
        clickOnElement(By.xpath("//p[@class='fc-button-label']"));
//Mouse Hover on the ‘Men’ Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()=\"Men\"]"));
        // mouse hover on the Bottoms tab
        mouseHoverToElement(By.xpath("//a[@id=\"ui-id-18\"]//span[contains(text(),\"Bottoms\")]"));
        // Mouse Hover on the Pants tab and click
        mouseHoverToElementAndClick(By.xpath("//a[@id=\"ui-id-23\"]"));
        //parent window Handle
        String parentWindowHandle= driver.getWindowHandle();
        // mouse hover on the cronus yoga pant
        mouseHoverToElementAndClick(By.xpath("//div[@class='product-item-info']"));

//driver.switchTo().defaultContent();
       // click on size 32
        mouseHoverToElementAndClick(By.xpath("//div[@id=\"option-label-size-143-item-175\"]"));

        // mouse hove again on cronus yoga pant
        //driver.switchTo().window(parentWindowHandle);
     //  mouseHoverToElement(By.xpath("//div[@class='product-item-info']"));
        // click on black

        mouseHoverToElementAndClick(By.xpath("//div[@id=\"option-label-color-93-item-49\"]"));
  //dismissAlert();
  // add to Cart
        mouseHoverToElementAndClick(By.xpath("//span[normalize-space()=\"Add to Cart\"]"));

        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = driver.findElement(By.xpath("//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")).getText();
        Assert.assertEquals("No text displayed",expectedText,actualText);
        // click on Shop Cart Link
        clickOnElement(By.xpath("//a[normalize-space()=\"shopping cart\"]"));

        //Verify the Text Shooping cart
        String expectedText1 = "Shopping Cart.";
        String actualText1 = driver.findElement(By.xpath("//span[@class=\"base\"]")).getText();
        Assert.assertEquals("No text displayed",expectedText1,actualText1);

        //Verify the text Cronus Yoga Pant
        String expectedText2 = "Cronus Yoga Pant";
        String actualText2 = driver.findElement(By.xpath("//td[@class=\"col item\"]//strong[@class=\"product-item-name\"]")).getText();
        Assert.assertEquals("No text displayed",expectedText2,actualText2);

        // Verify the size 32
        String expectedText3 = "32";
        String actualText3 = driver.findElement(By.xpath("//dd[contains(text(),\"32\")]")).getText();
        Assert.assertEquals("No text displayed",expectedText3,actualText3);

        // Verify the colour black
        String expectedText4 = "32";
        String actualText4 = driver.findElement(By.xpath("//dd[contains(text(),\"Black\")]")).getText();
        Assert.assertEquals("No text displayed",expectedText4,actualText4);


    }


}
