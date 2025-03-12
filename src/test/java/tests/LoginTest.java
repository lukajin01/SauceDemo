package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    /*
    1. Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение standart_user
    3. Оставить поле password пустым (ввести пробел)
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
        Epic sadface: Password is required
    */

    @Test
    public void checkPositiveLoginWithEmptyPassword() {
        loginPage.open()
                .loginForNegativeData("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required");
    }

    /*
    1. Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение standart_user
    3. Оставить поле password значение secret_sauce
    4. Нажать кнопку Login
    5. Проверить, что на странице есть уникальный элемент Products
    */

    @Test
    public void checkPositiveLoginWithPositivePassword() {
        loginPage.open()
                .login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
    }

    /*
    1. Открыть страницу https://www.saucedemo.com/
    2. Оставить поле username пустым (ввести пробел)
    3. Ввести в поле password значение secret_sauce
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
        Epic sadface: Username is required
    */

    @Test
    public void checkEmptyLoginWithPositivePassword() {
        loginPage.open()
                .loginForNegativeData("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required");
    }

    /*
    1. Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение ggg
    3. Ввести в поле password значение ggg
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
       Epic sadface: Username and password do not match any user in this service
    */

    @Test
    public void checkNegativeLoginWithNegativePassword() {
        loginPage.open()
                .loginForNegativeData("ggg", "ggg");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }
}
