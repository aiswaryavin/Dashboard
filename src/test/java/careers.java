import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.List;
import java.util.List;
public class careers extends Main{

 @Test(priority=0)
    public void addjobs() throws InterruptedException {
    Thread.sleep(2000);

  //  scrollPage(1000);

    WebElement m=driver.findElement(By.xpath("//button[contains(.,'Careers')]"));

    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", m);
    clicked(By.xpath("//button[contains(.,'Careers')]"));
     clicked(By.xpath("//p[normalize-space()='Add Jobs']"));
     enterText(By.xpath("//input[@id='job_title']"),"Data Engineer");
     drop(By.xpath("//input[@id='main_categories']"),By.xpath("//li[@id='main_categories-option-0']"));
     drop(By.xpath("//input[@id='sub_categories']"),By.xpath("//li[@id='sub_categories-option-0']"));
     drop(By.xpath("//input[@id='employement_types']"),By.xpath("//li[@id='employement_types-option-0']"));
     enterText(By.xpath("//input[@id='years_of_experience']"),"5");
     drop(By.xpath("//input[@id='career_level']"),By.xpath("//li[@id='career_level-option-4']"));
     Thread.sleep(2000);
  //   clicked(By.xpath("//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']"));
     enterText(By.xpath("//input[@id='vacancies']"),"5");
     enterText(By.xpath("//input[@id='min_salary']"),"5000");
     enterText(By.xpath("//input[@id='max_salary']"),"10000");
     enterText(By.xpath("//body"),"10000");
     drop(By.xpath("//input[@id='education']"),By.xpath("//li[@id='education-option-3']"));
     drop(By.xpath("//input[@id='fields_of_study']"),By.xpath("//li[@id='fields_of_study-option-0']"));
     drop(By.xpath("//input[@id='specialization']"),By.xpath("//li[@id='specialization-option-0']"));
     drop(By.xpath("//input[@id='nationalities']"),By.xpath("//li[@id='nationalities-option-0']"));
     drop(By.xpath("//input[@id='languages']"),By.xpath("//li[@id='languages-option-0']"));
     drop(By.xpath("//input[@id='gender']"),By.xpath("//li[@id='gender-option-0']"));
     drop(By.xpath("//input[@id='tags']"),By.xpath("//li[@id='tags-option-0']"));
     drop(By.xpath("//input[@id='jobBenefits']"),By.xpath("//li[@id='jobBenefits-option-0']"));
     drop(By.xpath("//input[@id='city_id']"),By.xpath("//li[@id='city_id-option-0']"));
     drop(By.xpath("//input[@id='community_id']"),By.xpath("//li[@id='community_id-option-0']"));
     enterText(By.xpath("//input[@id='job_image']"),"C:\\Users\\Aiswarya\\Downloads\\IMG_0278.mp4");
     enterText(By.xpath("//textarea[@id='job_description']"),"Hi");
     clicked(By.xpath("//button[normalize-space()='Submit']"));

 }
 @Test(priority=1)

 public void manage_categories(){
  clicked(By.xpath("//h5[normalize-space()='Categories']"));
  clicked(By.xpath("//button[normalize-space()='Add Job Category']"));
  enterText(By.xpath("//input[@id='sub_category']"),"ljkjklj");


 }

}
