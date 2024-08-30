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

        enterText(By.xpath("//input[@id='title']"),promotiontype);
        clicked(By.xpath("//button[normalize-space()='Submit']"));
    }

    @Test(priority = 4)

        public void verifyExistPromo(){
            checkIfAdded(By.xpath("//*[@id=\"__next\"]/div/main/div/div[2]/div[2]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[3]"),promotiontype);

            // Locate all table rows
         /*   List<WebElement> tableRows = driver.findElements(By.cssSelector("tr"));

            // Loop through the table rows to check if "phase testing" is present
            for (WebElement row : tableRows) {
                // Locate the cells in the current row
                List<WebElement> cells = row.findElements(By.cssSelector("td.MuiTableCell-root.MuiTableCell-body.MuiTableCell-sizeMedium.css-1gp8781"));

                // Check if any cell contains the text "phase testing"
                for (WebElement cell : cells) {
                    if (cell.getText().equals(promotiontype)){
                        System.out.println("Added promotion type is present in the table");

                    }

                }
            }
            System.out.println("Added promotion is not present in the table.");*/
            // If "phase testing" is not found in any row



    }

    @Test(priority = 5)
    public void verifyDelete(){
        clicked(By.xpath("//tbody/tr[1]/td[4]/div[1]/button[1]"));
        clicked(By.xpath("//button[normalize-space()='Yes']"));
        SuccessValidator(By.xpath("//div[@class='MuiBox-root css-0']//div[contains(text(),'Promotion Type Deleted successfully.')]"),"Promotion Type Deleted Successfully");
    }
}
