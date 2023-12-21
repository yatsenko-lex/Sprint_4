package ru.praktikum.yandex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.paktikum.yandex.screens.OrderScooterScreen;
import ru.paktikum.yandex.screens.ScooterMainPageScreen;

public class OrderScooterTests extends BaseTests {

    ScooterMainPageScreen scooterMainPageScreen = new ScooterMainPageScreen(driver);
    OrderScooterScreen orderScooterScreen = new OrderScooterScreen(driver);

    @Before
    public void setUp(){
        setUpBrowser();
        openSite();
    }

    @Test
    public void orderCompleteFromHeader() {
        scooterMainPageScreen.clickOrderTopButton();
        setOrderDetails("Имя","Фамилия", "Мира 21", "89111111111", "Заказ выполнен с кнопки 1");
        confirmOrder();
    }

    @Test
    public void orderCompleteFromBody() {
        scooterMainPageScreen.clickOrderButton();
        setOrderDetails("Имя","Фамилия", "Мира 21", "89111111111", "Заказ выполнен с кнопки 2");
        confirmOrder();
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

    public void setOrderDetails(String firstName, String lastName, String address, String phone, String comment){
        orderScooterScreen.waitForLoadOrderPage();
        orderScooterScreen.fillInfo(firstName, lastName, address, phone);
        orderScooterScreen.chooseDeliveryDate();
        orderScooterScreen.chooseRentPeriod();
        orderScooterScreen.chooseBlackColour();
        orderScooterScreen.fillComment(comment);
    }

    public void confirmOrder(){
        orderScooterScreen.clickOrderButton();
        orderScooterScreen.confirmOrder();
        orderScooterScreen.checkOrder();
    }
}
