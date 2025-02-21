import org.openqa.selenium.WebDriver;
import org.example.WebDriverSingleton;
import org.example.SubscriptionPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubscriptionTest {
    private static WebDriver driver;
    private SubscriptionPage subscriptionPage;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSingleton.getInstance();
        driver.manage().window().maximize();
        driver.get("https://a1.by");
    }

    @Test
    public void testSubscription() {
        subscriptionPage = new SubscriptionPage(driver);

        // Ввод адреса электронной почты и отправка формы
        String testEmail = "test@example.com";
        subscriptionPage.enterEmail(testEmail);
        subscriptionPage.clickSubscribe();

        // Проверка текста всплывающего сообщения
        String expectedMessage = "Вы подписались";
        String qwe=subscriptionPage.getConfirmationMessage();
        System.out.println(qwe);
        assertEquals(expectedMessage, subscriptionPage.getConfirmationMessage());
    }

    @AfterAll
    public static void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}