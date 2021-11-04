package selenide;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YandexMainPage extends BasePage{

    @Step("Ищу слово {query}")
    public YandexWithSearch search(String query){
        $(By.name("text")).setValue(query).pressEnter();
        return page(YandexWithSearch.class);
    }
}
