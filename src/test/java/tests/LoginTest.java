package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
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
                .loginForNegativeData(user, "");
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
                .login(user, password);
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
                .loginForNegativeData("", password);
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

    @Test
    public void test(){
        log.fatal("fatal");
        log.error("error");
        log.info("info");
        log.debug("debug");
        log.trace("trace");
    }
}
