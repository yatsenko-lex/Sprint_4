package ru.praktikum.yandex;

import org.junit.Test;
import ru.paktikum.yandex.screens.OrderScooterScreen;
import ru.paktikum.yandex.screens.ScooterMainPageScreen;

public class OrderScooterTests extends BaseTests {

    ScooterMainPageScreen scooterMainPageScreen = new ScooterMainPageScreen(driver);
    OrderScooterScreen orderScooterScreen = new OrderScooterScreen(driver);

    @Test
    public void orderCompleteFromHeader() {
        scooterMainPageScreen.clickOrderTopButton();
        orderScooterScreen.setOrderDetails("Имя", "Фамилия", "Мира 21", "89111111111", "Заказ выполнен с кнопки 1");
        orderScooterScreen.confirmScooterOrder();
    }

    @Test
    public void orderCompleteFromBody() {
        scooterMainPageScreen.clickOrderButton();
        orderScooterScreen.setOrderDetails("Имя", "Фамилия", "Мира 21", "89111111111", "Заказ выполнен с кнопки 2");
        orderScooterScreen.confirmScooterOrder();
    }
}
