/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osa.java;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Solaiman
 */
public class PageSearch {

    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new HtmlUnitDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!\n");
        element.submit();

    }
}
