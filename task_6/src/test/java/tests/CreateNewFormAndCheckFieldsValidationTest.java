package tests;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.hamcrest.Matchers;
import org.testng.annotations.*;

import static org.hamcrest.MatcherAssert.assertThat;

import pages.forms.FormWidget;
import pages.forms.FormsDesignerPage;
import pages.login.FormsPage;
import pages.login.LoginPage;
import utils.TestListener;

@Listeners({ReportPortalTestNGListener.class, TestListener.class})
public class CreateNewFormAndCheckFieldsValidationTest {

    private final static String sectionName = "[ANP] Blood group+ Rh";
    private final static String errorMessageUnderEmptyField = "Please fill in the required field";
    private final static String errorMessageUnderVeryLongField = "Please enter at most 250 characters";
    private final static String validName = "Test Form";
    private final static String validTitle = "Patient Data";
    private final static String validDescription = "Short description of a test form";
    private final static String veryLongName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_OK ABCDEFGHIJKLMNOPQRSTUVWXYZ_OK ABCDEFGHIJKLMNOPQRSTUVWXYZ_OK ABCDEFGHIJKLMNOPQRSTUVWXYZ_OK ABCDEFGHIJKLMNOPQRSTUVWXYZ_OK ABCDEFGHIJKLMNOPQRSTUVWXYZ_OK ABCDEFGHIJKLMNOPQRSTUVWXYZ_OK ABCDEFGHIJKLMNOPQRSTUVWXYZ_OK 12345678901";
    private FormWidget formWidget;

    @BeforeClass()
    public void loginAsAdminAndNavigateToFormWidget() {
        formWidget = new LoginPage().logIn()
                .selectEMFFormsOptions()
                .clickNewFormButton();
        new FormsDesignerPage().clickPlusButton(sectionName);
    }

    @Test(priority = 1)
    public void isSaveButtonDisabledWithEmptyFields() {
        assertThat(new FormsDesignerPage().isSaveButtonEnabled(), Matchers.equalTo(false));
    }

    @Test(priority = 2)
    public void isErrorMessageDisplayedWithEmptyField() {
         final String errorMessage = formWidget.clickOnNameField()
                        .clickOnTitleField()
                        .clickOnDescriptionField()
                        .getErrorMessageUnderField();
         assertThat(errorMessage, Matchers.equalTo(errorMessageUnderEmptyField));
    }

    @Test(priority = 3)
    public void isErrorWithEmptyFieldsHighlightedWithRed() {
        assertThat(formWidget.isErrorMessageUnderFieldHighlightedWithRed(), Matchers.equalTo(true));
    }

    @Test(priority = 4)
    public void isErrorMessageDisplayedWithValidField() {
        formWidget.clickOnNameField()
                .fillFormName(validName)
                .clickOnTitleField()
                .fillFormTitle(validTitle);
        assertThat(formWidget.isErrorMessageUnderFieldDisplayed(), Matchers.equalTo(false));
    }

    @Test(priority = 5)
    public void isErrorMessageDisplayedWithVeryLongField() {
        final String errorMessage = formWidget.clickOnNameField()
                .clearNameField()
                .fillFormName(veryLongName)
                .getErrorMessageUnderField();
        assertThat(errorMessage, Matchers.equalTo(errorMessageUnderVeryLongField));
    }

    @Test(priority = 6)
    public void isSaveButtonEnableWithValidFields() {
        formWidget.clickOnNameField()
                .clearNameField()
                .fillFormName(validName)
                .clickOnTitleField()
                .clearTitleField()
                .fillFormTitle(validTitle);
        assertThat(new FormsDesignerPage().isSaveButtonEnabled(), Matchers.equalTo(true));
    }

    @Test(priority = 7)
    public void isFormSuccessfullySavedWithValidFields() {
        formWidget.clickOnNameField()
                .clearNameField()
                .fillFormName(validName)
                .clickOnTitleField()
                .clearTitleField()
                .fillFormTitle(validTitle)
                .clickOnDescriptionField()
                .fillFormDescription(validDescription);
        new FormsDesignerPage().clickSaveButton();
        assertThat(new FormsPage().searchTemplates(validName).isFormSuccessfullySaved(validName), Matchers.equalTo(true));
    }

    @AfterClass
    public void browserTearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
