package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By CHECKOUT_BUTTON = By.id("checkout");

    @Step("Нажатие на кнопку checkout")
    public CheckoutInformationPage clickToCheckout(){
        log.info("Нажатие на кнопку checkout");
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutInformationPage(driver);
    }
}
