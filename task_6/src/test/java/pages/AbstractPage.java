package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class AbstractPage {

    public void clearField(WebElement element) {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
    }

    public String getLettersColor(WebElement element) {
        return element.getCssValue("color");
    }
}
