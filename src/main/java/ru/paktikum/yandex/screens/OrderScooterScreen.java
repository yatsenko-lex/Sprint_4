package ru.paktikum.yandex.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderScooterScreen {

    private final WebDriver driver;
    private final WebDriverWait driverWait;

    //Шаг 1
    private By orderBlock = By.className("Order_Header__BZXOb");
    private By firstNameInput = By.xpath("//input[@placeholder='* Имя']");
    private By lastNameInput = By.xpath("//input[@placeholder='* Фамилия']");
    private By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By subwayInput = By.xpath("//input[@placeholder='* Станция метро']");
    private By phoneNumberInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By continueOrderButton = By.className("Button_Middle__1CSJM");

    //Шаг 2
    private By deliveryDatePicker = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By nextMonthButton = By.className("react-datepicker__navigation--next");
    private By dayPicker = By.className("react-datepicker__week");
    private By rentPeriodPicker = By.className("Dropdown-placeholder");
    private By rentPeriodList = By.className("Dropdown-menu");
    private By rentalPeriod = By.xpath(".//div[text()='сутки']");
    private By blackScooterColor = By.id("black");
    private By greyScooterColor = By.id("grey");
    private By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //Модалка
    private By confirmationPopup = By.className("Order_Modal__YZ-d3");
    private By confirmOrderButton = By.xpath("//div[@class='Order_Modal__YZ-d3']/div/button[text()='Да']");
    private By successOrderPopup = By.className("Order_Modal__YZ-d3");
    private By orderStatusButton = By.xpath("//div[@class='Order_Modal__YZ-d3']/div/button");
    private By orderStatusHeader = By.className("Order_ModalHeader__3FDaJ");

    public OrderScooterScreen(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    //методы для работы с элементами блока "Для кого самокат"
    public void waitForLoadOrderPage() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(orderBlock));
    }

    public void fillName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void fillAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void chooseSubway() {
        driver.findElement(subwayInput).click();
        driver.findElement(subwayInput).sendKeys(Keys.DOWN, Keys.ENTER);
    }

    public void fillPhone(String phone) {
        driver.findElement(phoneNumberInput).sendKeys(phone);
    }

    public void clickContinueButton() {
        driver.findElement(continueOrderButton).click();
    }

    //методы для работы с элементами блока "Про аренду"
    public void chooseDeliveryDate() {
        driver.findElement(deliveryDatePicker).click();
        driver.findElement(nextMonthButton).click();
        driver.findElement(dayPicker).click();
    }

    public void chooseRentPeriod() {
        driver.findElement(rentPeriodPicker).click();
        driver.findElement(rentPeriodList).isEnabled();
        driver.findElement(rentalPeriod).click();
    }

    public void chooseBlackColour() {
        driver.findElement(blackScooterColor).click();
    }

    public void fillComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void confirmOrder() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(confirmationPopup));
        driver.findElement(confirmOrderButton).click();
    }

    public void checkOrder() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(successOrderPopup));
        driver.findElement(orderStatusButton).isEnabled();
        String popupText = driver.findElement(orderStatusHeader).getText();
    }

    public void fillInfo(String name, String surname, String address, String phone) {
        fillName(name);
        fillLastName(surname);
        fillAddress(address);
        chooseSubway();
        fillPhone(phone);
        clickContinueButton();
    }

    public void setOrderDetails(String firstName, String lastName, String address, String phone, String comment) {
        waitForLoadOrderPage();
        fillInfo(firstName, lastName, address, phone);
        chooseDeliveryDate();
        chooseRentPeriod();
        chooseBlackColour();
        fillComment(comment);
    }

    public void confirmScooterOrder() {
        clickOrderButton();
        confirmOrder();
        checkOrder();
    }
}
