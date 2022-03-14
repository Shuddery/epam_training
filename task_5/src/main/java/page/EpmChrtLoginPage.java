package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.*;

public class EpmChrtLoginPage{

    private final String LOGIN_PAGE_URL = "https://misp-qa.by2.epm-chrt.projects.epam.com/login";
    private final String LOGIN = "auto_misp";
    private final String PASSWORD = "password";

    private By loginInputLocator = By.xpath("//input[@name = 'login']");
    private By passwordInputLocator = By.xpath("//input[@name = 'password']");

    public EpmChrtLoginPage openPage() {
        open(LOGIN_PAGE_URL);
        return this;
    }

    public EMFSectionsPage openEMFSectionsPage() {
        $(loginInputLocator).setValue(LOGIN);
        $(passwordInputLocator).setValue(PASSWORD).pressEnter();
        return new EMFSectionsPage();
    }
}
