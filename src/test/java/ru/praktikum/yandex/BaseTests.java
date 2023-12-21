package ru.praktikum.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.paktikum.yandex.screens.ScooterMainPageScreen;

public abstract class BaseTests {

    public WebDriver driver;

    public void setUpBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }
    public void openSite(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void closeBrowser(){
        driver.quit();
    }
}
