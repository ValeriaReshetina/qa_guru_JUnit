package guru.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CsvSourceTest extends TestBase {

    @CsvSource(value = {
            "RIO ROLLER, SCRIPT PEACH",
            "IMPALA,     HOLOGRAPHIC"
    })
    @DisplayName("Test with using a CsvSource data provider as a homework for lesson #9")
    @ParameterizedTest(name = "В результате поиска отображен {1} по тексту запроса {0}")
    public void searchOfNewRollersWithCsvSource(String value, String searchQuery) {
        open("https://kvady.ru/");
        $x("//span[contains(text(),'Перейти в каталог')]").click();
        $x("//input[contains(@placeholder, 'Поиск по каталогу')]").setValue(value).pressEnter();
        $$x("//div[contains(@class, 'catalog__product column')]").findBy(text(searchQuery)).click();
        $x("//*[@id='products']").shouldHave(text(searchQuery));
    }
}
