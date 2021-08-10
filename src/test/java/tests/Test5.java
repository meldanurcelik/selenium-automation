package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();

        //Selenium ile çift tıklama, sağ tıklama

        //---Çift tıklama
        WebElement doubleClickButon = driver.findElement(By.id("doubleClickBtn"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickButon).perform();

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        String doubleClickMessageText = doubleClickMessage.getText();
        System.out.println(doubleClickMessageText);

        //---Sağ tıklama
        WebElement rightClickButon = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClickButon).perform();

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        String rightClicktessageText = rightClickMessage.getText();
        System.out.println(rightClicktessageText);

        //--Dinamik elementlere tıklama
        //1. //div/button[starts-with(text(), 'Click Me')]
        //2. //div[last()]/button
        WebElement dynamicClickButon = driver.findElement(By.xpath("//div/button[starts-with(text(), 'Click Me')]"));
        dynamicClickButon.click();

        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        String dynamicClickMessageText = dynamicClickMessage.getText();
        System.out.println(dynamicClickMessageText);
    }
}
