package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();

        //Selenium ile radio butonlara tıklama
        WebElement yesRadioButonLabel = driver.findElement(new By.ByCssSelector("label[for='yesRadio']"));
        boolean isEnabled = yesRadioButonLabel.isEnabled();
        if (isEnabled) {
            yesRadioButonLabel.click();
            System.out.println("Clicked Yes radio button!");
        }

        WebElement yesRadioButonInput = driver.findElement(By.id("yesRadio"));
        boolean isSelected = yesRadioButonInput.isSelected();
        if (isSelected){
            System.out.println("Yes radio button is selected!");
        }

        WebElement output = driver.findElement(new By.ByCssSelector("p.mt-3"));
        System.out.println(output.getText());

        //---
        WebElement noRadioButon = driver.findElement(By.id("noRadio"));
        System.out.println(noRadioButon.isEnabled());

    }
}