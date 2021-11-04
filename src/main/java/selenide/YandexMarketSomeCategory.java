package selenide;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class YandexMarketSomeCategory extends BasePage{

    @Step("Переходим в категорию {subCategory}")
    public YandexMarketSubCategory goSubCategory(String subCategory){
        $x("//a[text()='"+subCategory+"']").click();
        return page(YandexMarketSubCategory.class);
    }
}
