package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class holidayhomes extends Main {

    @Test(priority = 6)
    public void addholi() {
        System.out.print("inside holiday home");

        // Clicking on the required button
        clicked(By.xpath("//*[@id='__next']/div/nav/div/div/div[2]/ul[12]/button"));
        System.out.print("clicked on button");

        // Clicking on the next item in the list
        clicked(By.xpath("//*[@id='__next']/div/nav/div/div/div[2]/ul[12]/div[1]/div/div/a/div"));

        // Selecting the holiday home type from the dropdown
        drop(driver, "holidayHomeType", "//*[@id='holidayHomeType-option-1']");

        // Entering text in the title field
        enterText(By.name("en_title"), "Greenhome");

        // Continue with the rest of your test code
    }

}
