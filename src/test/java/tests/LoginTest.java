package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void checkPositiveLoginWithEmptyPassword(){
        loginPage.open();
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    /*
    1. Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение standart_user
    3. Оставить поле password значение secret_sauce
    4. Нажать кнопку Login
    5. Проверить, что на странице есть уникальный элемент Products
    */

    @Test
    public void checkPositiveLoginWithPositivePassword(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isPageOpened());
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
    public void checkEmptyLoginWithPositivePassword(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
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
    public void checkNegativeLoginWithNegativePassword(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("ggg");
        driver.findElement(By.id("password")).sendKeys("ggg");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }
}
