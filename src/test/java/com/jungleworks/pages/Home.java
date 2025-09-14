package com.jungleworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.xpath("//input[contains(@placeholder,'Search') or contains(@type,'search')]");

    public Home(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void search(String keyword) {
        WebElement box = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        box.clear();
        box.sendKeys(keyword);
        box.sendKeys(Keys.ENTER);
    }
}
