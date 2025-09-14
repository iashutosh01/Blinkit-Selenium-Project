Blinkit Automation Test 

This project contains an end-to-end Selenium automation test for the Blinkit grocery platform. It demonstrates a full user journey from opening the website to reaching the payment/OTP page using Java, Selenium, and TestNG.

Features

Opens Blinkit website with a preset Noida address to skip location popup

Logs in with a dummy phone number (OTP skipped)

Searches for a product (e.g., milk)

Selects and adds a product to the cart

Proceeds to checkout

Chooses a payment method (UPI) and enters dummy payment details

Validates navigation till the OTP/confirmation page

JungleWork/
│
├── src/main/java/com/jungleworks/pages/
│   ├── Home.java
│   ├── Login.java
│   ├── Product.java
│   └── Checkout.java
│
├── src/test/java/com/jungleworks/tests/
│   └── BlinkitFlowTest.java
│
├── pom.xml 
└── README.md


ChromeDriver

Maven (if project is configured as Maven)
