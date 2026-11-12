package com.experiment4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Automated positive and negative login tests for the local demonstration page.
 * Demo credentials: admin / password123
 */
class LoginTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createChromeDriver();
        URL page = getClass().getClassLoader().getResource("login.html");
        assertNotNull(page, "login.html must exist in src/test/resources");
        driver.get(page.toExternalForm());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Valid login displays the welcome message")
    void validLoginShouldSucceed() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("loginButton")).click();

        WebElement result = driver.findElement(By.id("message"));
        assertEquals("Login successful. Welcome, admin!", result.getText());
        assertEquals("success", result.getAttribute("data-status"));
    }

    @Test
    @DisplayName("Invalid login displays an error and does not authenticate")
    void invalidLoginShouldFail() {
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        driver.findElement(By.id("loginButton")).click();

        WebElement result = driver.findElement(By.id("message"));
        assertEquals("Invalid username or password.", result.getText());
        assertEquals("error", result.getAttribute("data-status"));
    }
}
