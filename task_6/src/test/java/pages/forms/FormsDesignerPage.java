package pages.forms;


import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;


public class FormsDesignerPage extends AbstractPage {

    private final WebElement saveButton = Selenide.$x("//button[@data-test='sidebar-footer-save-button']");
    final String plusButton = "//div[./h6[text()='All Sections']]//li[.//div[text() = '%s']]/button";

    public boolean isSaveButtonEnabled() {
        return saveButton.isEnabled();
    }

    public void clickPlusButton(String selectedSectionName) {
        Selenide.$x(String.format(plusButton, selectedSectionName)).hover().click();
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}