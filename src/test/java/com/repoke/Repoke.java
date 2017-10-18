package com.repoke;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static com.repoke.credentials.Credentials.*;

public class Repoke {
    private String testUrl;
    private WebDriver driver;

    @Test
    public void prepare() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);

        driver.get("http:\\www.facebook.com");


        WebElement element1 = driver.findElement(By.id("email"));
        element1.sendKeys(email);

        WebElement element2 = driver.findElement(By.id("pass"));
        element2.sendKeys(password);

        WebElement element3 = driver.findElement(By.id("u_0_2"));
        element3.click();

        driver.get("https://www.facebook.com/pokes/");

        List<WebElement> cutuqueDeVolta = null;

        while(1==1){
            try {
                cutuqueDeVolta = driver.findElements(By.xpath("//*[contains(text(), 'Cutuque de volta')]"));
            } catch(NoSuchElementException e){
                System.out.print("No pokes");
            }

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            if(!cutuqueDeVolta.isEmpty()) {
                for (WebElement element : cutuqueDeVolta) {
                    element.click();
                }
            }
            cutuqueDeVolta = null;
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

}
