package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By USER_FIELD = By.id("user-name");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    @Step("Открытие страницы LoginPage")
    public LoginPage open(){
        log.info("Открытие страницы LoginPage");
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    @Step("Вход в систему с данными пользователя: логин - {user} и пароль - {password}")
    public ProductsPage login(String user, String password){
        log.info("Вход в систему с данными пользователя {} и пароль {}", user, password);
        driver.findElement(USER_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Вход в систему с данными пользователя: логин - {user} и пароль - {password}")
    public LoginPage loginForNegativeData(String user, String password){
        log.info("Вход в систему с данными пользователя {} и пароль {}", user, password);
        driver.findElement(USER_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public String getErrorMessage(){
        log.info("Получение сообщения об ошибке");
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
