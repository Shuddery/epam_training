package pages.login;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import utils.EnvironmentConfig;

public class LoginPage extends AbstractPage {

    private static final String URL = EnvironmentConfig.appUrl + "login";

    private final WebElement loginField = Selenide.$x("//input[@name = 'login']");
    private final WebElement passwordField = Selenide.$x("//input[@name='password']");
    private final WebElement enterButton = Selenide.$x("//form/button[@type='submit']");

    public void navigateToPage() {
        open(URL);
    }

    public void fillLoginField(String login) {
        loginField.sendKeys(login);
    }

    public void fillPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public ElementsPage logIn() {
        navigateToPage();
        fillLoginField(EnvironmentConfig.loginAdmin);
        fillPasswordField(EnvironmentConfig.passwordAdmin);
        clickEnterButton();
        return new ElementsPage();
    }

    public void clickEnterButton() {
        enterButton.click();
    }

}