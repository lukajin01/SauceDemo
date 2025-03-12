package pages;

import dto.Customer;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutInformationPage {
    WebDriver driver;

    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By FIRST_NAME_FIELD = By.id("first-name");
    private static final By LAST_NAME_FIELD = By.id("last-name");
    private static final By ZIP_CODE_FIELD = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");

    @Step("Заполнение формы данными: имя - {firstName}, фамилия - {lastName}, индекс - {zipCode}")
    public CheckoutInformationPage fillingForm(Customer customer){
        log.info("Заполнение формы данными: имя - {}, фамилия - {}, индекс - {}", customer.getFirstName(), customer.getLastName(), customer.getZipCode());
        driver.findElement(FIRST_NAME_FIELD).sendKeys(customer.getFirstName());
        driver.findElement(LAST_NAME_FIELD).sendKeys(customer.getLastName());
        driver.findElement(ZIP_CODE_FIELD).sendKeys(customer.getZipCode());
        return this;
    }

    @Step("Нажатие на кнопку continue")
    public OverviewPage clickToContinue(){
        log.info("Нажатие на кнопку continue");
        driver.findElement(CONTINUE_BUTTON).click();
        return new OverviewPage(driver);
    }

}
