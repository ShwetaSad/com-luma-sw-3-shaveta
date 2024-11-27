package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class womenTest extends Utility {
    String baseUrl="https://magento.softwaretestingboard.com/";

    @Before
    public void open(){
        openBrowser(baseUrl);
    }
@Test
    public void verifyTheSortByProductNameFilter() {
        //clicking consent on popup
        clickOnElement(By.xpath("//p[@class='fc-button-label']"));
        //Mouse Hover on the ‘Women’ Menu
    mouseHoverToElement(By.linkText("Women"));
    //Mouse Hover on the ‘Tops'
    mouseHoverToElement(By.xpath("//a[@id=\"ui-id-9\"]"));
    // clicking on Jackets
    mouseHoverToElementAndClick(By.xpath("//a[@id=\"ui-id-11\"]//span[contains(text(),\"Jackets\")]"));
   //Select Sort by Filter 'Product Name
    selectByValueFromDropDown(By.xpath("//div[@class=\"page-wrapper\"]//div[2]//div[3]//select[1]"), "Product Name");

    List<WebElement> productElements = driver.findElements(By.xpath("//li[@class='item product product-item']"));

    // Extract the text of the product names into a list
    List<String> productNames = new ArrayList<>();
    for (WebElement product : productElements) {
        productNames.add(product.getText());
        System.out.println(productNames);

        // Make a copy of the list and sort it alphabetically
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);

        // Verify if the original list is the same as the sorted list
        if (productNames.equals(sortedProductNames)) {
            System.out.println("Products are displayed in alphabetical order.");
        } else {
            System.out.println("Products are NOT displayed in alphabetical order.");
        }
    }


    }
    @Test
public void verifyTheSortByPriceFilter (){
    //clicking consent on popup
    clickOnElement(By.xpath("//p[@class='fc-button-label']"));
    //Mouse Hover on the ‘Women’ Menu
    mouseHoverToElement(By.linkText("Women"));
    //Mouse Hover on the ‘Tops'
    mouseHoverToElement(By.xpath("//a[@id=\"ui-id-9\"]"));
    // clicking on Jackets
    mouseHoverToElementAndClick(By.xpath("//a[@id=\"ui-id-11\"]//span[contains(text(),\"Jackets\")]"));
    //Select Sort by Filter 'Price filter
    selectByValueFromDropDown(By.xpath("//div[@class=\"page-wrapper\"]//div[2]//div[3]//select[1]"), "Price");



    List<WebElement> priceElements = driver.findElements(By.xpath("//li[@class='item product product-item']"));

    // Extract the price values into a list
    List<Double> productPrices = new ArrayList<>();
    for (WebElement priceElement : priceElements) {
        // Extract the text and remove currency symbols or unwanted characters if needed
        String priceText = priceElement.getText().replace("$", "").trim();

        try{
            // Convert the price text to a numeric value (double)
            double price = Double.parseDouble(priceText);
            productPrices.add(price);
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format: " + priceText);
        }
    }
    // Verify that the product prices are in ascending order using Assert
    for (int i = 1; i < productPrices.size(); i++) {
        // Assert that each price is greater than or equal to the previous price
        Assert.assertTrue("Prices are not in ascending order at index " + i, productPrices.get(i) >= productPrices.get(i - 1));
    }

    System.out.println("Products are displayed in ascending price order.");

    // Close the browser
    driver.quit();

}
@After
    public void close() {
        super.closeBrowser();
    }
}