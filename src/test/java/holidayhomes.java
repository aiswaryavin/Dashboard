import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class holidayhomes extends Main {

    @Test(priority = 0)
    public void addHolidayHome() {
        System.out.println("Inside holiday home");
        clicked(By.xpath("//*[@id='__next']/div/nav/div/div/div[2]/ul[12]/button"));
        System.out.println("Clicked on button");
        clicked(By.xpath("//*[@id='__next']/div/nav/div/div/div[2]/ul[12]/div[1]/div/div/a/div"));
        Allure.step("Successfully redirected to the add holiday home page");
    }

    @Test(priority = 1)
    public void experience() {
        drop(By.name("holidayHomeType"), By.xpath("//*[@id='holidayHomeType-option-1']"));
        enterText(By.name("en_title"), "Green Home");
        enterText(By.xpath("//input[@id='ar_title']"), "لقثثى اخةث");
        clicked(By.xpath("//input[@id='experience_category']"));
        clicked(By.xpath("//li[@id='experience_category-option-0']"));
        clicked(By.xpath("//li[@id='experience_category-option-5']"));
        enterText(By.name("no_of_hours"), "5");
        enterText(By.name("price_person"), "5000");

        // Selecting the experience package
        clicked(By.xpath("//input[@id='experience_package']"));
        clicked(By.xpath("//li[@id='experience_package-option-0']"));
        clicked(By.xpath("//li[@id='experience_package-option-1']"));
    }

    @Test(priority = 2)
    public void stay() {
        drop(By.name("holidayHomeType"), By.xpath("//*[@id='holidayHomeType-option-0']"));
        enterText(By.name("en_title"), "Green Home");
        enterText(By.xpath("//input[@id='ar_title']"), "لقثثى اخةثس");

        // Selecting the stay category
        clicked(By.xpath("//input[@id='stay_category']"));
        clicked(By.xpath("//li[@id='stay_category-option-2']"));
        clicked(By.xpath("//li[@id='stay_category-option-3']"));
        enterText(By.name("no_of_room"), "5");
        enterText(By.name("price_night"), "5000");
        enterText(By.name("no_bathroom"), "5");

        // Selecting views
        clicked(By.xpath("//input[@id='no_views']"));
        clicked(By.xpath("//li[@id='no_views-option-0']"));
        clicked(By.xpath("//li[@id='no_views-option-1']"));

        // Selecting stay package
        clicked(By.xpath("//input[@id='stay_package']"));
        clicked(By.xpath("//li[@id='stay_package-option-0']"));
        clicked(By.xpath("//li[@id='stay_package-option-1']"));
    }

    @Test(priority = 3)
    public void location() {
        drop(By.xpath("//input[@id='locationCountrySelect']"), By.xpath("//li[@id='locationCountrySelect-option-0']"));
        drop(By.xpath("//input[@id='locationState']"), By.xpath("//li[@id='locationState-option-0']"));
        drop(By.xpath("//input[@id='locationCitySelector']"), By.xpath("//li[@id='locationCitySelector-option-0']"));
        drop(By.xpath("//input[@id='locationCommunity']"), By.xpath("//li[@id='locationCommunity-option-0']"));
        drop(By.xpath("//input[@id='locationSubCommunity']"), By.xpath("//li[@id='locationSubCommunity-option-0']"));
        clicked(By.xpath("//span[normalize-space()='Visitor parking']"));
        clicked(By.xpath("//span[normalize-space()='Security Staff']"));
        clicked(By.xpath("//button[normalize-space()='Submit']"));
    }

    @Test(priority = 4)
    public void checkMandatoryFields() {
        clicked(By.xpath("//*[@id='__next']/div/nav/div/div/div[2]/ul[12]/div[1]/div/div/a/div"));
        clicked(By.xpath("//button[normalize-space()='Submit']"));

        List<WebElement> validationMessages = driver.findElements(By.cssSelector(".MuiFormHelperText-root.css-1hn95st, .MuiFormHelperText-root.Mui-error"));
        String[] expectedMessages = {
                "please select Holiday Home type",
                "Enter title",
                "Please select a country",
                "Please select a state",
                "Please select a city",
                "Please select a community",
                "Please select a sub community"
        };

        validateErrorMessages(validationMessages, expectedMessages);
    }

    @Test(priority = 5)
    public void stayMandatoryFields() {
        drop(By.name("holidayHomeType"), By.xpath("//*[@id='holidayHomeType-option-0']"));
      //  clicked(By.xpath("//button[normalize-space()='Submit']"));
        System.out.println("Clicked on submit button in the stay category");

        List<WebElement> validationMessages = driver.findElements(By.xpath("//*[contains(@class, 'MuiFormHelperText-root') and (contains(@class, 'css-1hn95st') or contains(@class, 'Mui-error'))]"));
        String[] expectedMessages = {
                "Enter title",
                "please select stay category",
                "Enter Number of rooms",
                "Insert price",
                "Insert no of bathrooms",
                "Enter multiple views",
                "Please select experience package",
                "Please select a country",
                "Please select a state",
                "Please select a city",
                "Please select a community",
                "Please select a sub community"
        };

        validateErrorMessages(validationMessages, expectedMessages);

    }

    @Test(priority = 6)
    public void experienceMandatoryFields() {
        clicked(By.name("holidayHomeType"));
        clicked(By.xpath("//*[@id='holidayHomeType-option-1']"));
        clicked(By.xpath("//button[normalize-space()='Submit']"));
        System.out.println("Clicked on submit button in the experience category");

        List<WebElement> validationMessages = driver.findElements(By.cssSelector(".MuiFormHelperText-root.css-1hn95st, .MuiFormHelperText-root.Mui-error"));
        String[] expectedMessages = {
                "Enter title",
                "please select Experience Category",
                "Insert no of hours",
                "Insert price",
                "Please select experience package",
                "Please select a country",
                "Please select a state",
                "Please select a city",
                "Please select a community",
                "Please select a sub community"
        };

        validateErrorMessages(validationMessages, expectedMessages);
    }
    @Test(priority=7)
    public void managecategory() throws InterruptedException {
        clicked(By.xpath("//p[normalize-space()='Manage Categories']"));
        System.out.println("clicked on manage category");
        Thread.sleep(2000);
        clicked(By.xpath("//button[normalize-space()='Add Category']"));
        System.out.println("clicked on add category");
        Thread.sleep(1000);
        drop(By.xpath("//input[@id='holiday_home_type']"),By.xpath("//li[@id='holiday_home_type-option-1']"));
        System.out.println("Holiday home type");
        Thread.sleep(3000);
        enterText(By.xpath("//input[@id='title']"),"Night ride");
        enterText(By.xpath(" (//input[@id='title_ar'])[1]"),"]ثسسثقف قهيث");
        Thread.sleep(2000);
        clicked(By.xpath("//button[normalize-space()='Submit']"));
        Thread.sleep(2000);
        System.out.println("clicked on submit button");
        Thread.sleep(3000);
        SuccessValidator(By.cssSelector("//div[@class='MuiBox-root css-sqcvv9']//div[contains(text(),'Category Has been created Successfully')]"),"Category Has been created Successfully");
        verifyFirstTitleMatches("Dessert Ride",By.xpath("//td[contains(@class, 'MuiTableCell-root') and text()='1']/parent::tr"),By.xpath(".//td[contains(@class, 'MuiTableCell-root') and contains(@class, 'css-zl296')]"));


    }

    @Test(priority = 8)
   public void deletecategory() throws InterruptedException {
      //  delete(By.xpath("//td[contains(@class, 'MuiTableCell-root') and text()='1']/parent::tr"),By.xpath("//tbody/tr[1]/td[3]"));
        clicked(By.xpath("//tbody/tr[1]/td[5]/div[1]/button[2]"));
        System.out.println("clicked on delete button");
        Thread.sleep(2000);
        Thread.sleep(2000);
        clicked(By.xpath("//button[normalize-space()='Yes']"));
        Thread.sleep(2000);
        SuccessValidator(By.xpath("//div[@class='MuiBox-root css-sqcvv9']//div[@class='Toastify']//div[@role='alert']"),"Category Deleted Successfully");

    }
    @Test(priority =9)
    public void packageinclusions() {
        clicked(By.xpath("//p[normalize-space()='Package Inclusions']"));
        clicked(By.xpath("//button[normalize-space()='Add Package Inclusion']"));
        drop(By.xpath("//input[@id='holidayHome_type']"), By.xpath("//li[@id='holidayHome_type-option-1']"));
        System.out.println("selected the holy home type");
        enterText(By.xpath("//input[@id='title']"), "Dessert Ride");
        enterText(By.xpath("//input[@id='title_ar']"), "]ثسسثقف ٌهيث");
        enterText(By.xpath("//input[@id='icon']"), "C:\\Users\\Aiswarya\\Downloads\\download (12).jpg");
        clicked(By.xpath("//button[normalize-space()='Submit']"));
        SuccessValidator(By.xpath("//div[@class='MuiBox-root css-sqcvv9']//div[contains(text(),'Package Inclusion Created Successfully')]"),"Package Inclusion Created Successfully");
        verifyFirstTitleMatches("Dessert Ride", By.xpath("//td[contains(@class, 'MuiTableCell-root') and text()='1']/parent::tr"), By.xpath(".//td[contains(@class, 'MuiTableCell-root') and contains(@class, 'css-zl296')]"));

    }
    @Test(priority=10)
    public void deletecatepackage() throws InterruptedException {
      //  delete(By.xpath("//td[contains(@class, 'MuiTableCell-root') and text()='1']/parent::tr"),By.xpath(".//button[contains(@class, 'delete-button-class')]"));
        clicked(By.xpath("//tbody/tr[1]/td[6]/div[1]/button[2]"));
        System.out.println("Clicked on delete button");
        Thread.sleep(2000);
        clicked(By.xpath("//button[normalize-space()='Yes']"));
        Thread.sleep(2000);
        SuccessValidator(By.xpath("//div[@class='MuiBox-root css-sqcvv9']//div[contains(text(),'Package Inclusion Deleted Successfully')]"),"Package Inclusion Deleted Successfully");


    }
    @Test(priority = 11)
    public void manageportals() throws InterruptedException{
        Thread.sleep(2000);
        clicked(By.xpath("//p[normalize-space()='Manage Portals']"));
        System.out.println("Clicked on Manage portal menu");
        Thread.sleep(2000);
        clicked(By.xpath("//button[normalize-space()='Add Portal']"));
        System.out.println("clicked on the add portal");
        Thread.sleep(2000);
        enterText(By.name("portal_name"),"dubaijobs");
        enterText(By.xpath("//input[@id='portal_url']"),"https://www.dubaijobs.com");
        enterText(By.xpath("//input[@id='upload_logo']"),"C:\\Users\\Aiswarya\\Downloads\\image 1.jpg");
        clicked(By.xpath("//button[normalize-space()='Submit']"));
        System.out.println("added portal successfully");


    }

    



}
