# Selenium TestNG POM Framework

A UI test automation framework for the [SauceDemo](https://www.saucedemo.com) web app,
built with Selenium WebDriver and TestNG using the Page Object Model.

## Tech Stack

- Java 17
- Maven
- Selenium WebDriver 4.40
- TestNG 7.12

## What It Covers

- **Login** – valid login, plus a data-driven test (`@DataProvider`) covering locked-out,
  wrong-password, empty-username, and empty-password cases, each asserting the exact error.
- **Products** – add an item to the cart and verify the cart badge; sort products by price
  and assert the order is correct.
- **Cart** – verify an added item appears in the cart.
- **Checkout** – complete the full purchase flow and assert the order-confirmation message.
- **Logout** – log out and confirm the session ended.

11 tests across login, products, cart, and checkout suites.

## Key Practices

- Page Object Model – one class per page (`LoginPage`, `ProductsPage`, `CartPage`, `CheckoutPage`)
- Explicit waits with `WebDriverWait` / `ExpectedConditions` – no `Thread.sleep`
- A single shared `WebDriverWait`, created once and passed into page objects
- Data-driven testing with TestNG `@DataProvider`
- Positive and negative test cases
- Meaningful assertions with descriptive failure messages

## Project Structure
src/test/java/com/srabon/
├── base/BaseTest: driver setup/teardown, shared wait
├── pages/Page objects: LoginPage, ProductsPage, CartPage, CheckoutPage
└── tests/Test classes: LoginTest, ProductsTest, CartTest, CheckoutTest

## How to Run
mvn test

Selenium Manager handles the ChromeDriver automatically — no manual driver setup.

## Results

All 9 tests pass.
Please check the screenshot on docs/test-results.png
