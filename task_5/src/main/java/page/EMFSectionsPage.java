package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class EMFSectionsPage{

    private By headerSectionLocator = By.xpath("//h4[text() = 'EMF sections']");
    private By sectionElementsLocator = By.xpath("//tbody/tr/td[1]");

    public String getURL() {
        return WebDriverRunner.url();
    }

    public String getHeaderSectionText() {
        return $(headerSectionLocator).text();
    }

    public EMFDesignerPage clickOnFirstSectionElement() {
        $(sectionElementsLocator).click();
        return new EMFDesignerPage();
    }

    public SelenideElement getFirstSectionElement() {
        return $(sectionElementsLocator);
    }

    public ElementsCollection getAllSectionElements() {
        return $$(sectionElementsLocator);
    }



}
