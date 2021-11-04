package selenide;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class YandexMarket extends BasePage{

    @Step("Переходим в категорию {category}")
    public YandexMarketSomeCategory goCategory(String category){
        $x("//span[text()='Каталог']/../../..").click();
        $x("//li[@class='_1hPrb cia-cs']//span[text()='"+category+"']").click();
        return page(YandexMarketSomeCategory.class);
    }


}
