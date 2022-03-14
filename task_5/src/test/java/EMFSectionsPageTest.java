import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.EMFSectionsPage;
import page.EpmChrtLoginPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EMFSectionsPageTest{
    private final String SECTION_HEADER_TEXT = "EMF Sections";

    @Test
    void isSectionsPageDisplayedTest() {
        EMFSectionsPage emfSectionsPage = new EpmChrtLoginPage()
                .openPage()
                .openEMFSectionsPage();

        assertThat(emfSectionsPage.getHeaderSectionText(), is(equalTo(SECTION_HEADER_TEXT)));
    }

    @Test
    void isSectionElementInListOfCreatedSectionElementsTest() {
        EMFSectionsPage emfSectionsPage = new EpmChrtLoginPage()
                .openPage()
                .openEMFSectionsPage();

        SelenideElement firstSectionElement = emfSectionsPage.getFirstSectionElement();
        ElementsCollection allSectionElements = emfSectionsPage.getAllSectionElements();
        assertThat(firstSectionElement.text(), is(equalTo(allSectionElements.get(0).text())));
    }

    @AfterMethod
    public void browserTearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
