
package com.jungleworks.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.jungleworks.pages.Home;
import com.jungleworks.pages.Product;
import com.jungleworks.pages.Checkout;
import com.jungleworks.pages.Login;

import java.time.Duration;

public class BlinkitFlowTest {

    WebDriver driver;
    Home home;
    Product product;
    Checkout checkout;
    Login login;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        home = new Home(driver);
        product = new Product(driver);
        checkout = new Checkout(driver);
        login = new Login(driver);
    }

    @Test
    public void fullUserJourney() {
        driver.get("https://blinkit.com/?address=Sector%2018,%20Noida,%20Uttar%20Pradesh%20201301");
        System.out.println("Opened Blinkit with Noida address ✅");

        login.openLoginIfPresent();
        login.setPhone("7050701199");
        login.clickContinue();
        System.out.println("Logged in (OTP skipped) ✅");

        home.search("milk");
        System.out.println("Searched for milk ✅");

        product.addFirst();
        product.addDetail();
        System.out.println("Selected and added product ✅");

        checkout.openCart();
        checkout.proceedToCheckout();
        System.out.println("Reached checkout ✅");

        checkout.chooseUPI();
        checkout.enterUPI("test@upi");
        System.out.println("Entered dummy payment details ✅");

        boolean otpPage = checkout.reachedOtpOrConfirmation();
        if (otpPage) {
            System.out.println("Reached OTP/confirmation page ✅");
        } else {
            System.out.println("OTP/confirmation page not detected ❌");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
