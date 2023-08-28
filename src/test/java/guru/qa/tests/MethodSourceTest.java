package guru.qa.tests;

import com.codeborne.selenide.CollectionCondition;
import guru.qa.data.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MethodSourceTest extends TestBase {

    static Stream<Arguments> steamLocaleTest() {
        return Stream.of(
                Arguments.of(Locale.ENGLISH, List.of("STORE", "COMMUNITY", "ABOUT", "SUPPORT")),
                Arguments.of(Locale.RUSSIAN, List.of("МАГАЗИН", "СООБЩЕСТВО", "ИНФОРМАЦИЯ", "ПОДДЕРЖКА")),
                Arguments.of(Locale.DEUTSCH, List.of("SHOP", "COMMUNITY", "INFO", "SUPPORT"))
        );
    }

    @MethodSource
    @DisplayName("Test with using a MethodSource data provider as a homework for lesson #9")
    @ParameterizedTest
    public void steamLocaleTest(Locale locale, List<String> expectedButtons) {
        open("https://store.steampowered.com/");
        $x("//*[@id='language_pulldown']").click();
        $$x("//a[@class='popup_menu_item tight']").find(text(locale.getLanguage())).click();
        $$x("//div[@class='supernav_container']//a")
                .filter(visible).should(CollectionCondition.texts(expectedButtons));
    }
}
