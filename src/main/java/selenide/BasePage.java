package selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    protected void waitForRefresh(){
        SelenideElement element1 = $x("//div[@class='_8v6CF _2KV_b']").should(exist);
        SelenideElement element2 = $x("//div[@class='_8v6CF']").should(exist);
    }
}
