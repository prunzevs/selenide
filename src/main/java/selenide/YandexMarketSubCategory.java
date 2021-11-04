package selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class YandexMarketSubCategory extends BasePage{

    @Step("Задать параметр «Производитель» {manufacturer}.")
    private void setManufacturer(String manufacturer){
        $x("//input[@name='Производитель "+manufacturer+"']/..").click();

    }

    @Step("Установить количество показываемых элементов на страницу {n}")
    private void setNumberOfElements(int n){
        $x("//button[@class='vLDMf']").click();
        $x("//button[text()='Показывать по "+n+"']").click();
    }

    @Step("Убедится что в выборку попали только {phoneName}")
    public YandexMarketSubCategory checkPhoneNamesForManufacturer(String phoneName, String manufacturer, int n){
        setManufacturer(manufacturer);
        setNumberOfElements(n);

        Boolean isPresent;
        do{
            ElementsCollection elCol=$$x("//a[@aria-label='Следующая страница']");
            isPresent = elCol.size() > 0;
            ElementsCollection table = $$(By.xpath("//h3[not (@class='-KSHF')]"));
            Assertions.assertTrue(table.stream().anyMatch(x->x.getText().contains(phoneName)),"not "+phoneName+" was found");
            if(isPresent==true) {
                $x("//a[@aria-label='Следующая страница']").click();
                //SelenideElement element1 = $x("//div[@class='_8v6CF _2KV_b']").should(exist);
                //SelenideElement element2 = $x("//div[@class='_8v6CF']").should(exist);
                waitForRefresh();
            }
        }while (isPresent==true);

    return this;
    }
}
