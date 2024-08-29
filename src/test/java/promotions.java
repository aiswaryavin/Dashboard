import org.openqa.selenium.By;
import org.testng.annotations.Test;

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
        enterText(By.xpath("//input[@id='title']"),"pm002");
        clicked(By.xpath("//button[normalize-space()='Submit']"));
    }
    @Test(priority = 4)
    public void verifyExistPromo(){
        promoChecker(By.xpath("//*[@id=\"__next\"]/div/main/div/div[2]/div[2]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[3]"),"pm002");

    }
    @Test(priority = 5)
    public void verifyDelete(){
        clicked(By.xpath("//tbody/tr[1]/td[4]/div[1]/button[1]"));
        clicked(By.xpath("//button[normalize-space()='Yes']"));
        SuccessValidator(By.xpath("//div[@class='MuiBox-root css-0']//div[contains(text(),'Promotion Type Deleted successfully.')]"),"Promotion Type Deleted Successfully");
    }
}
