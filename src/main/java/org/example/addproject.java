package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.UUID;

import static org.example.Main.driver;


public class addproject {


    @Test(priority = 5)
    public void navigateToUserProfile() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();


        driver.getCurrentUrl();

        clicked(driver,By.xpath("//*[@id=\"__next\"]/div/nav/div/div/div[2]/ul[2]/button"));
        clicked(driver,By.xpath("//*[@id=\"__next\"]/div/nav/div/div/div[2]/ul[2]/div[1]/div/div/a/div"));
        String prjtname = randomString(4);
        String license = UUID.randomUUID().toString();
        String projectno=randomString2(6);
        String des=randomString2(750);
        setInputValue(driver,"projectTitle", prjtname);
        setInputValue(driver,"licenseNumber",  license);
        setInputValue(driver,"projectNumber", projectno);
        drop(driver,"masterDeveloperSelector","//*[@id=\"masterDeveloperSelector-option-0\"]");
        drop(driver,"locationCountrySelect","//*[@id=\"locationCountrySelect-option-0\"]");
        drop(driver,"locationState","//*[@id=\"locationState-option-0\"]");
        drop(driver,"locationCitySelector","//*[@id=\"locationCitySelector-option-0\"]");
        drop(driver,"locationCommunity","//*[@id=\"locationCommunity-option-0\"]");
        drop(driver,"locationSubCommunity","//*[@id=\"locationSubCommunity-option-0\"]");
        drop(driver,"completionStatus","//*[@id=\"completionStatus-option-0\"]");
        String s=setInputValue(driver,"completionPercentage","2000");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div/div[2]/div/div/div[3]/div/div[1]")).click();

        //    Assert.assertEquals(s,"100");

        String s1=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div/div[2]/div/div/div[3]/div/div[2]/div/div/div[2]/div[3]/p")).getText();
        System.out.println(s1);
        Assert.assertEquals(s1,"The value must be less than 100");
        driver.findElement(By.name("completionPercentage")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        setInputValue(driver,"completionPercentage","100");
        selectDate(driver,"completionPercentageDate","/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[2]/div/div[4]/button[3]");
        setInputValue(driver,"plotArea","5000");
        setInputValue(driver,"builtupArea","3000");
        URLValidator.validateURL(driver,"https://dashboard.aqaryint.com/dashboard/project/add_project");
        drop(driver,"furnished","//*[@id=\"furnished-option-1\"]");
        setInputValue(driver,"noOfProperties","10");
        drop(driver,"lifeStyle","//*[@id=\"lifeStyle-option-0\"]");
        drop(driver,"ownership","//*[@id=\"ownership-option-0\"]");
        selectDate(driver,"startDate","/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/button[3]");
        selectDate(driver,"completionDate","/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[2]/div/div[5]/button[5]");
        selectDate(driver,"handoverDate","/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[2]/div/div[5]/button[7]");
        setInputValue(driver,"serviceCharge","5000");
        scrollPage(500);
        //   setInputValue(driver,"description","property description");
        String descriptionText = generateRandomChars(800);
        String arabicDescriptionText = generateRandomChars(800);

        // Enter text into the description box
        Entertext(driver, "//*[@id='description']", descriptionText);

        // Enter text into the Arabic description box
        Entertext(driver, "//*[@id='description_arabic']", arabicDescriptionText);
        Assert.assertEquals(getTextUsingJavaScript(driver, "//*[@id='description']"), descriptionText);
        Assert.assertEquals(getTextUsingJavaScript(driver, "//*[@id='description_arabic']"), arabicDescriptionText);
        selectFacility(driver, "Security Staff");
        selectAmenity(driver, "Balcony or Terrace");
        // Click the submit button
        clicked(driver, By.xpath("//button[@type='submit' and contains(text(), 'Submit')]"));
        // Add a small wait to ensure values are set before submission

        // setInputValue(driver,"description","Vacant now with sea view");
        //setInputValue(driver,"description_arabic","Larger layoutVacant now with sea view");


    }
    public void selectFacility(WebDriver driver, String facilityName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement facility = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + facilityName + "']")));
        facility.click();
    }

    // Method to select an amenity
    public void selectAmenity(WebDriver driver, String amenityName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement amenity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + amenityName + "']")));
        amenity.click();
    }
    public String getTextUsingJavaScript(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].value;", element);
    }
    public String randomString(int length) {
        // String symbols = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String symbols="abcdefghijklmnopqrstuvwxyz123456789";
        Random rnd = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            str.append(symbols.charAt(rnd.nextInt(symbols.length())));
        }
        return str.toString();
    }

    public static String generateRandomChars(int totalChars) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        // Generate the specified number of random characters
        for (int i = 0; i < totalChars; i++) {
            int x = random.nextInt(26) + 65; // Generates a number between 65 and 90 (A-Z)
            stringBuilder.append((char) x);
        }

        return stringBuilder.toString(); // Return the generated string
    }

    public String randomString2(int length) {
        // String symbols = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String symbols="abcdefghijklmnopqrstuvwxyz123456789";
        Random rnd = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append(symbols.charAt(rnd.nextInt(symbols.length())));
        }
        return str.toString();
    }

    public  void Entertext(WebDriver driver,String xpath,String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        // Use JavaScript to set the value directly
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", element, text);
        js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", element);
    }

    public void drop(WebDriver driver,String name, String xpath2){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement drop = driver.findElement(By.name(name));
        drop.click();
        WebElement drop2 = driver.findElement(By.xpath(xpath2));
        drop2.click();
    }
    public String setInputValue(WebDriver driver, String name, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
        element.sendKeys(value);
        return value;
    }

    public  void inputAdd(WebDriver driver,By locator,String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement findElement = driver.findElement(locator);
        findElement.sendKeys(value);
    }

    public void clicked(WebDriver driver,By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement findElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        findElement.click();
    }
    public void SelectDropdowns(WebDriver driver,By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Dropdown.click();
    }
    public void selectDate(WebDriver driver,String name,String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Dropdown = driver.findElement(By.name(name));
        Dropdown.click();
        WebElement Dropdown2 = driver.findElement(By.xpath(xpath));
        Dropdown2.click();
        WebElement ok=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[3]/button[2]"));
        ok.click();
    }

    public static class URLValidator {
        public static void validateURL(WebDriver driver, String expectedURL) {
            String currentURL = driver.getCurrentUrl();
            Assert.assertEquals(currentURL, expectedURL, "The URL is incorrect!");
        }
    }
    public void scrollPage(int pixels) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0," + pixels + ")", "");

    }
}
