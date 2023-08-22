package guru.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class ValueSourceTest extends TestBase {

    @ValueSource(strings = {"CHAYA - BLISS TURQUOISE",   "MOXI - BEACH BUNNY PERIWINKLE"})
    @DisplayName("Test with using a ValueSource data provider as a homework for lesson #9")
    @ParameterizedTest(name = "В результате поиска отображен {1} по тексту запроса {0}")
    public void searchOfNewRollersWithValueSource(String value) {
        open("https://kvady.ru/");
        $x("//span[contains(text(),'Перейти в каталог')]").click();
        $x("//input[contains(@placeholder, 'Поиск по каталогу')]").setValue(value).pressEnter();
        $$x("//div[contains(@class, 'catalog__product column')]").findBy(text(value)).click();
        $x("//*[@id='products']").shouldHave(text(value));
    }
}
