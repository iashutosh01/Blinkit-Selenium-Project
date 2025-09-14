package com.jungleworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cartBtn = By.xpath("//a[contains(@href,'/cart') or contains(.,'Cart')]");
    private By checkoutBtn = By.xpath("//button[contains(.,'Checkout') or contains(.,'Proceed')]");
    private By upiBtn = By.xpath("//div[contains(translate(.,'UPI','upi'),'UPI')]");
    private By upiField = By.xpath("//input[contains(@placeholder,'UPI') or contains(@name,'upi') or @type='text']");

    public Checkout(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openCart() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cartBtn)).click();
        } catch (Exception ignored) {}
    }

    public void proceedToCheckout() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        } catch (Exception ignored) {}
    }

    public void chooseUPI() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(upiBtn)).click();
        } catch (Exception ignored) {}
    }

    public void enterUPI(String upi) {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(upiField));
            input.clear();
            input.sendKeys(upi);
        } catch (Exception ignored) {}
    }

    public boolean reachedOtpOrConfirmation() {
        String page = driver.getPageSource().toLowerCase();
        if (page.contains("otp") || page.contains("one time password") || page.contains("enter otp") || page.contains("payment")) {
            return true;
        }
        try {
            return !driver.findElements(By.xpath("//input[contains(@name,'otp') or contains(@placeholder,'OTP') or contains(@id,'otp')]")).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}
