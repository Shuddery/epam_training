package pages.login;

import com.codeborne.selenide.*;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import pages.forms.FormWidget;
import utils.EnvironmentConfig;

public class FormsPage extends AbstractPage {

    private static final String URL = EnvironmentConfig.appUrl + "admin/templates/forms";

    private final WebElement newFormButton = Selenide.$x("//button[@type='button']/span[contains(text(),'New')]");
    private final SelenideElement searchField = Selenide.$x("//input[@data-test = 'search-input']");
    private final String formName = "//tbody//td/div[text() = '%s']";

    public FormsPage searchTemplates(String name) {
        searchField.hover().click();
        searchField.sendKeys(name);
        return this;
    }

    public FormWidget clickNewFormButton() {
        newFormButton.click(); return new FormWidget();
    }
    public boolean isFormSuccessfullySaved(String name) {
        return Selenide.$x(String.format(formName, name)).scrollTo().isDisplayed();
    }
}