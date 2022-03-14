import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.EMFDesignerPage;
import page.EMFSectionsPage;
import page.EpmChrtLoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EMFDesignerPageTest{

    @Test
    void isEMFDesignerPageDisplayedTest() {

        EMFDesignerPage emfDesignerPage = new EpmChrtLoginPage()
                .openPage()
                .openEMFSectionsPage()
                .clickOnFirstSectionElement();

        assertThat(emfDesignerPage.isEMFDesignerPageDisplayed(), is(true));
    }

    @Test
    void isPreviewButtonDisplayedTest() {
        EMFDesignerPage emfDesignerPage = new EpmChrtLoginPage()
                .openPage()
                .openEMFSectionsPage()
                .clickOnFirstSectionElement();

        assertThat(emfDesignerPage.isPreviewButtonDisplayed(), is(true));
    }

    @AfterMethod
    public void browserTearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
