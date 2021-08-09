package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        //Selenium ile web elementleri bulma
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.click();
        fullName.sendKeys("Melda");

        WebElement email = driver.findElement(new By.ByCssSelector(".mr-sm-2[placeholder='name@example.com']"));
        email.click();
        email.sendKeys("melda_celik@hotmail.com");

        WebElement currentAddress = driver.findElement(new By.ByCssSelector(".form-control[id='currentAddress']"));
        currentAddress.click();
        currentAddress.sendKeys("Samsun, Türkiye");

        WebElement permanentAddress = driver.findElement(new By.ByCssSelector("textarea#permanentAddress"));
        permanentAddress.click();
        permanentAddress.sendKeys("Samsun, Türkiye");

        WebElement submitButton = driver.findElement(new By.ByCssSelector("button#submit"));
        submitButton.click();

    }
}
