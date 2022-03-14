package page;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class EMFDesignerPage{

    private By navigationButtonLocator = By.xpath("//button[@data-test='open-navigation-btn']");
    private By previewButtonLocator = By.xpath("//button[contains(@class, 'MuiButton-outlined MuiButton-full')]");

    public String getURL() {
        return WebDriverRunner.url();
    }

    public boolean isEMFDesignerPageDisplayed() {
        return $(navigationButtonLocator).isEnabled();
    }

    public boolean isPreviewButtonDisplayed() {
        return $(previewButtonLocator).scrollTo().isDisplayed();
    }


}
