package ru.yandex;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import selenide.YandexMainPage;
import selenide.YandexMarket;

import static com.codeborne.selenide.Selenide.open;

public class SelenideTests extends SelenideBaseTest {

    @Feature("Проверка результатов поиска")
    @DisplayName("Проверка результатов поиска c помощью PO")
    @ParameterizedTest(name="{displayName} {arguments}")
    @CsvSource({"iPhone,Apple,12"})
    public void YandexSecondTest(String phoneName, String manufacturer, int n){
        open("https://www.yandex.ru/", YandexMainPage.class)
                .search("яндекс маркет")
                .goLinkByName("Яндекс.Маркет", YandexMarket.class)
                .goCategory("Электроника")
                .goSubCategory("Смартфоны")
                .checkPhoneNamesForManufacturer(phoneName, manufacturer, n);
    }
}
