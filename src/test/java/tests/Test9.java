package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test9 {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/browser-windows");
        //driver.manage().window().maximize();

        //Window/Tab ile etkileşim oluşturma
        WebElement tabButon = driver.findElement(By.id("tabButton"));
        tabButon.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles()); //kaç pencere var ona bakar
        System.out.println(tabs.size());

        driver.switchTo().window(tabs.get(1)); //belirtilen taba geçer
        System.out.println(driver.getCurrentUrl());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close(); //sayfayı kapatır, driver kill edilmiyor. (quit driver'ı kill eder)
    }
}

