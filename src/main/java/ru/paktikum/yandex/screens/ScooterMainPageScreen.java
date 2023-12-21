package ru.paktikum.yandex.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScooterMainPageScreen {

    private WebDriver driver;
    private By acceptCookieButton = By.id("rcc-confirm-button");
    private By orderTopButton = By.className("Button_Button__ra12g");
    private By orderButton = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    private By questionsList = By.className("accordion");
    private String questionsTitle = "//div[@id='accordion__heading-%s']";
    private String questionsDescription = "//div[@id='accordion__panel-%s']";

    public ScooterMainPageScreen(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAcceptCookieButton(){
        driver.findElement(acceptCookieButton).click();
    }

    public void clickOrderTopButton() {
        driver.findElement(orderTopButton).click();
    }

    public void clickOrderButton() {
        WebElement element = driver.findElement(orderButton);
        ((JavascriptExecutor).driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButton).click();
    }

    public void scrollToQuestions(){
        WebElement element = driver.findElement(questionsList);
        ((JavascriptExecutor).driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getQuestionTitle(String questionTitle){
        return driver.findElement(By.xpath(String.format(questionsTitle, questionTitle))).getText();
    }

    public String getQuestionDescription(String questionDescription){
        driver.findElement(By.xpath(String.format(questionsTitle, questionDescription))).click();
        return driver.findElement(By.xpath(String.format(questionsDescription, questionDescription))).getText();
    }
}
