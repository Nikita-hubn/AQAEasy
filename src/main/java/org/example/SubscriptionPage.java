package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubscriptionPage {
    private WebDriver driver;

    // Элементы страницы
    private By emailInput = By.xpath("/html/body/footer/section[1]/div/div/div[1]/div/form/fieldset/div/label[1]/input[1]");
    private By subscribeButton = By.xpath("/html/body/footer/section[1]/div/div/div[1]/div/form/fieldset/div/label[1]/button");
    private By confirmationMessage = By.xpath("/html/body/footer/div[2]/div/div/div/div[1]/p/div/div[1]");

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.sendKeys(email);
    }

    public void clickSubscribe() {
        WebElement button = driver.findElement(subscribeButton);
        button.click();
    }

    public String getConfirmationMessage() {
        WebElement message = driver.findElement(confirmationMessage);
        return message.getText();
    }
}
