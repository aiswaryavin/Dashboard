import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class promotions extends Main {

    @Test(priority = 1)
    public void PromotionNavigate(){
        clicked(By.xpath("//button[normalize-space()='Projects']"));
        clicked(By.xpath("//p[normalize-space()='Promotions']"));
        validateURL("https://dashboard.aqaryint.com/dashboard/project/project_management/promotions");
    }
    @Test(priority = 2)
    public void verifyRequiredField(){
        clicked(By.xpath("//button[normalize-space()='Add Promotion Type']"));
        clicked(By.xpath("//input[@id='title']"));
        clicked(By.xpath("//button[normalize-space()='Submit']"));
        InlineErrorValidator(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/div[1]/div/div[3]"),"Please provide a valid promotion type");
    }
    @Test(priority = 3)
   public void verifyAddpromo(){

        enterText(By.xpath("//input[@id='title']"),"newpromo");
        clicked(By.xpath("//button[normalize-space()='Submit']"));
    }

    @Test(priority = 4)

    public void verifyExistPromo(){
        // Add a promotion, assuming the title "newpromo"
        enterText(By.xpath("//input[@id='title']"), "newpromo");
        clicked(By.xpath("//button[normalize-space()='Submit']"));

        // Get the promotion type from the UI after submission
        String actualPromotionType = getPromotionTypeAtSerialNumber(1);

        // Now verify if the promotion type in the first row matches the retrieved one
        verifyFirstPromoTypeMatches(actualPromotionType,
                By.xpath("//td[contains(@class, 'MuiTableCell-root') and text()='1']/parent::tr"),
                By.xpath(".//td[contains(@class, 'MuiTableCell-root') and contains(@class, 'css-1gp8781')]"));
    }

    public String getPromotionTypeAtSerialNumber(int serialNumber) {
        // Locate the row with the specified serial number
        WebElement rowElement = driver.findElement(By.xpath("//td[contains(@class, 'MuiTableCell-root') and text()='" + serialNumber + "']/parent::tr"));

        // Retrieve the promotion type from the row
        WebElement promoTypeElement = rowElement.findElement(By.xpath(".//td[contains(@class, 'MuiTableCell-root') and contains(@class, 'css-1gp8781')]"));

        // Return the text of the promotion type
        return promoTypeElement.getText();
    }



    @Test(priority = 5)
    public void verifyDelete(){
        clicked(By.xpath("//tbody/tr[1]/td[4]/div[1]/button[1]"));
        clicked(By.xpath("//button[normalize-space()='Yes']"));
        SuccessValidator(By.xpath("//div[@class='MuiBox-root css-0']//div[contains(text(),'Promotion Type Deleted successfully.')]"),"Promotion Type Deleted Successfully");
    }




}
