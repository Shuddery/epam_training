package pages.login;

import com.codeborne.selenide.*;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import utils.EnvironmentConfig;


public class ElementsPage extends AbstractPage {

    private static final String URL = EnvironmentConfig.appUrl + "admin/templates/sections";

    private final WebElement EMFFormsOption = Selenide.$x("//a[@href='/admin/templates/forms']");

    public FormsPage selectEMFFormsOptions() {
        clickEMFFormsButton();
        return new FormsPage();
    }
    public void clickEMFFormsButton() {
        EMFFormsOption.click();
    }

}