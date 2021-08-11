package tests;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Test7 {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();

        //Kırık link bulma
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://demoqa.com/");
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);

        //Kırık görselleri bulma
        WebElement brokenImage = driver.findElement(By.xpath("//div/img[2]"));
        String brokenImageUrl = brokenImage.getAttribute("src");
        System.out.println(brokenImageUrl);

        HttpClient client2 = HttpClientBuilder.create().build();
        HttpGet request2 = new HttpGet("https://demoqa.com/");
        HttpResponse response2 = client2.execute(request2);
        int statusCode2 = response2.getStatusLine().getStatusCode();
        System.out.println(statusCode2);

        if (statusCode2 == 200) {
            System.out.println("Valid image!");
        } else if (statusCode2 == 500) {
            System.out.println("Broken image!");
        }
    }
}
