package com.jungleworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginBtn = By.xpath("//div[text()='Log in' or text()='Login' or text()='Sign in']");
    private By phoneBox = By.xpath("//input[@type='tel']");
    private By contBtn = By.xpath("//button[contains(.,'Continue')]");

    public Login(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openLoginIfPresent() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
            btn.click();
        } catch (Exception ignored) {}
    }

    public void setPhone(String phone) {
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneBox));
        box.clear();
        box.sendKeys(phone);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(contBtn)).click();
    }
}
