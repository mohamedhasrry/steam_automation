# steam_automation
# Steam Store Purchase Automation

An end-to-end (E2E) UI automation test suite built with **Java** and **Selenium WebDriver**, simulating and validating the complete user journey on the Steam online store — from authentication through checkout and payment confirmation.

## Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Technical Features](#technical-features)
- [Test Flow](#test-flow)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Setup & Installation](#setup--installation)
- [Running the Tests](#running-the-tests)
- [Known Limitations & Improvement Areas](#known-limitations--improvement-areas)
- [Disclaimer](#disclaimer)

## Overview

This project automates a real-world e-commerce workflow to test the functional correctness of Steam's storefront, covering critical user paths including login, product search, age-gate verification, cart operations, and the multi-step payment process.

## Architecture

The project follows the **Page Object Model (POM)**, a widely-used design pattern in test automation that separates page-specific element logic from test execution logic, improving maintainability and readability.

Each Page Object class exposes static methods returning `WebElement` references, located via Selenium locator strategies (`By.id`, `By.xpath`, `By.name`, `By.partialLinkText`), keeping locators centralized and easy to update if the UI changes.

## Project Structure

```
Teamproject_1.steam/
├── Test.java        # Main driver class — orchestrates the full end-to-end scenario
├── login.java        # Handles authentication UI elements
├── find.java          # Encapsulates store search and product selection
├── enter.java        # Manages the age-verification gate
├── purchase.java  # Controls "Add to Cart" and "Continue to Payment"
├── payment.java   # Handles payment method selection and card details
└── submit.java     # Finalizes order submission and purchase confirmation
```

| Class | Responsibility |
|---|---|
| `login.java` | Username, password, and submit button interactions |
| `find.java` | Store search bar, search submit, and product result selection |
| `enter.java` | Age-verification day/month/year dropdowns and page continuation |
| `purchase.java` | "Add to Cart" and "Continue to Payment" actions |
| `payment.java` | Payment method selection, card number, expiration date, CVV |
| `submit.java` | Terms acceptance, payment submission, purchase confirmation |
| `Test.java` | End-to-end orchestration of the full purchase scenario |

## Technical Features

- **Explicit & Implicit Waits** — Uses `WebDriverWait` combined with `ExpectedConditions.elementToBeClickable()` to handle dynamic page loads, alongside `Thread.sleep()` for simpler synchronization points.
- **JavaScript Executor** — Uses `JavascriptExecutor` to scroll elements into view and trigger clicks programmatically, useful for elements obscured by overlays or lazy-loaded content.
- **Dropdown Handling** — Uses Selenium's `Select` class for native `<select>` elements (age verification) and custom click-based interaction for non-native dropdown components (payment method, expiration date).
- **Multiple Locator Strategies** — Combines ID-based, name-based, partial link text, and XPath locators depending on element structure and availability.

## Test Flow

The scenario implemented in `Test.java` executes the following steps in sequence:

1. Launch the Chrome browser and navigate to the Steam login page.
2. Authenticate using test credentials.
3. Search for a product (e.g., "Witcher") and select it from the search results.
4. Complete the age-verification gate (day, month, year).
5. Add the product to the cart via a JavaScript-triggered click.
6. Proceed to the payment gateway.
7. Select a payment method (Visa) and enter card details using a standard **test card number**.
8. Set the card expiration month and year via custom dropdown components.
9. Enter the CVV / security code.
10. Accept the terms of sale, submit payment, and confirm the purchase.

## Tech Stack

| Component | Technology |
|---|---|
| Language | Java |
| Automation Framework | Selenium WebDriver |
| Browser Driver | ChromeDriver |
| Design Pattern | Page Object Model (POM) |
| Target Application | Steam Store (store.steampowered.com) |

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Selenium WebDriver library
- Google Chrome browser installed
- ChromeDriver matching your installed Chrome version (or managed via WebDriverManager)
- A Maven or Gradle build setup (recommended) with the Selenium dependency configured

## Setup & Installation

1. Clone or download the project source files.
2. Ensure all `.java` files reside under the package `Teamproject_1.steam`.
3. Add the Selenium WebDriver dependency to your build tool, for example (Maven):

   ```xml
   <dependency>
       <groupId>org.seleniumhq.selenium</groupId>
       <artifactId>selenium-java</artifactId>
       <version>4.x.x</version>
   </dependency>
   ```

4. Ensure ChromeDriver is available on your system `PATH`, or configure its path explicitly via `System.setProperty("webdriver.chrome.driver", "<path>")`.
5. Update test credentials and any environment-specific values in `Test.java` before running.

## Running the Tests

Run the `Test` class directly as a Java application (it contains a `main` method):

```bash
javac -d bin src/Teamproject_1/steam/*.java
java -cp bin Teamproject_1.steam.Test
```

Alternatively, run `Test.java` from your IDE (Eclipse, IntelliJ IDEA) as a standard Java application.

## Known Limitations & Improvement Areas

This suite was built as a learning/demo project and has a few areas that would benefit from hardening before production or CI use:

- **Hardcoded credentials** — Login credentials are currently embedded directly in `Test.java`. These should be externalized to environment variables or a secure configuration file.
- **`Thread.sleep()` usage** — Several steps rely on fixed sleep durations rather than dynamic waits. Migrating fully to `WebDriverWait` / `ExpectedConditions` would make the suite more robust and less flaky.
- **Unused import** — `enter.java` imports `com.sun.org.apache.bcel.internal.generic.Select`, which is unused; the actual `Select` usage in `Test.java` comes from `org.openqa.selenium.support.ui.Select`. This import should be removed.
- **No assertions** — The current flow performs actions but does not assert expected outcomes at each step. Adding assertions (e.g., via JUnit/TestNG) would turn this into a proper automated test rather than a scripted walkthrough.
- **No test framework integration** — Wrapping the flow in JUnit or TestNG would enable structured reporting, retries, and CI/CD integration.

## Disclaimer

This project is intended for **educational and demonstration purposes only** (e.g., learning Selenium WebDriver and the Page Object Model). It uses a **test/dummy payment card number** and interacts with a live third-party website (Steam). Automating interactions with production websites you do not own or control may violate their terms of service — use responsibly and only against test/staging environments where possible.
