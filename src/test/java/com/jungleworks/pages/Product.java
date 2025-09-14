package com.jungleworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Product {
    private WebDriver driver;
    private WebDriverWait wait;

    private By addBtns = By.xpath("//button[contains(.,'ADD') or contains(.,'Add')]");
    private By firstProd = By.xpath("(//a[contains(@href,'/p/') or contains(@href,'product')])[1]");

    public Product(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void addFirst() {
        try {
            List<WebElement> btns = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addBtns));
            if (!btns.isEmpty()) {
                btns.get(0).click();
                return;
            }
        } catch (Exception ignored) {}

        try {
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(firstProd));
            link.click();
        } catch (Exception e) {
            throw new RuntimeException("Product not found. Update locators.");
        }
    }

    public void addDetail() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(.,'ADD') or contains(.,'Add') or @id='add-to-cart-button']")));
            btn.click();
        } catch (Exception ignored) {}
    }
}
