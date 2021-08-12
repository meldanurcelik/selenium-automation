package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Test10 {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        //Selenium ile alert testi yapma

        //Click Button to see alert
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();

        //On button click, alert will appear after 5 seconds
        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        //On button click, confirm box will appear - OK
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();

        //On button click, confirm box will appear - Cancel
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();

        //On button click, prompt box will appear
        driver.findElement(By.id("promtButton")).click();
        Alert alert = driver.switchTo().alert();
        driver.switchTo().alert().sendKeys("Hello World!");
        driver.switchTo().alert().accept();

    }
}
