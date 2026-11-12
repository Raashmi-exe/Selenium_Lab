package com.experiment4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Creates ChromeDriver instances. Selenium Manager (included in Selenium 4)
 * automatically resolves a compatible driver when one is not configured.
 */
public final class DriverFactory {
    private DriverFactory() { }

    public static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1280,900");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        if (Boolean.getBoolean("headless")) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        return new ChromeDriver(options);
    }
}
