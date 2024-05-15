package com.test_projects;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class TestVWOLogin {


    EdgeDriver edgeDriver;

    @BeforeTest
    void OpenBrowser() {

        edgeDriver = new EdgeDriver();
        edgeDriver.get("https://app.vwo.com");
    }
    @Owner("sneha")

    @Test
    public void testBrowser_positiveTC() {


        WebElement username = edgeDriver.findElement(By.id("login-username"));
        username.sendKeys("mmonicasingh721@gmail.com");

        WebElement password = edgeDriver.findElement(By.id("login-password"));
        password.sendKeys("Arty@789");

        WebElement button_submit = edgeDriver.findElement(By.id("js-login-btn"));
        button_submit.click();

        FluentWait<EdgeDriver> wait1 = new FluentWait<>(edgeDriver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        wait1.until(new Function<EdgeDriver, WebElement>() {

            @Override

            public WebElement apply(EdgeDriver edgeDriver) {
                return edgeDriver.findElement(By.xpath("//span[@data-qa='lufexuloga']"));
            }
        });


        WebElement userName = edgeDriver.findElement(By.xpath("//span[@data-qa='lufexuloga']"));
        System.out.println(userName.getText());
    }
    @AfterTest

    public void closeBrowser() {
        edgeDriver.quit();
    }

}

