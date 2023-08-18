package guru.qa;

import com.codeborne.selenide.Condition;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SampleGitTests {

    @CsvSource(value = {
            "Selenide,   selenide/selenide",
            "JUnit 5,    junit-team/junit5"
    })
    @ParameterizedTest(name = "В результате поиска отображен {1} по тексту запроса {0}")
    void successSearchInGithubJunitSelenide(String value, String searchQuery) {
        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue(value).pressEnter();
        $$("[data-testid=results-list]").first().shouldHave(text(searchQuery));
    }

    @Description("Test for lesson #4 to check that there is example code for JUnit5")
    @Test
    public void gitHubSoftAssertionsTest() {
        open("https://github.com/selenide/selenide");

        $x("//*[@id='wiki-tab']").click();
        $x("//*[@class='Box-row wiki-more-pages-link']//button").click();
        $x("//*[@id='wiki-pages-box']//*[contains(text(), 'SoftAssertions')]")
                .shouldBe(Condition.interactable).scrollTo().click();
        $x("//div[@class='markdown-body']").shouldHave(text("3. Using JUnit5 extend test class:"));
    }

    @Description("First test for lesson #5 to check that necessary page has loaded by it's title")
    @Test
    public void gitHubHoverTest() {
        open("https://github.com/");

        $x("//*[contains(text(), 'Solutions')]").hover();
        $x("//*[contains(text(), 'Enterprise')]").click();
        $x("//*[@class='application-main ']").shouldHave(text("Build like the best"));
    }
}
