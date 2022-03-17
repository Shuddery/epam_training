package pages.forms;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import utils.IConstants;

public class FormWidget extends AbstractPage {

    private final WebElement nameField = Selenide.$x("//input[@name = 'name']");
    private final WebElement titleField = Selenide.$x("//input[@name = 'title']");
    private final WebElement descriptionField = Selenide.$x("//input[@name = 'description']");
    private final WebElement errorMessageUnderField = Selenide.$x("//p[contains(@class, 'Mui-error')]");

    public FormWidget fillFormName(String value) {
        nameField.sendKeys(value); return this;
    }

    public FormWidget fillFormTitle(String value) {
        titleField.sendKeys(value); return this;
    }

    public void fillFormDescription(String value) {
        descriptionField.sendKeys(value);
    }

    public FormWidget clickOnNameField() { nameField.click(); return this; }

    public FormWidget clickOnTitleField() { titleField.click(); return this;}

    public FormWidget clickOnDescriptionField() { titleField.click(); return this; }

    public boolean isErrorMessageUnderFieldHighlightedWithRed() {
        return getLettersColor(errorMessageUnderField).equals(IConstants.redFlagButton);
    }

    public String getErrorMessageUnderField() {
        return errorMessageUnderField.getText();
    }

    public boolean isErrorMessageUnderFieldDisplayed() {
        return errorMessageUnderField.isDisplayed();
    }

    public FormWidget clearNameField() { clearField(nameField); return this;}

    public FormWidget clearTitleField() { clearField(titleField); return this; }

}