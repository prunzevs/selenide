package helpers;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.screenshot;

public class Assertions {

    @Step("Проверяем что нет ошибки: '{message}'")
    public static void assertTrue(boolean condition, String message){
        org.junit.jupiter.api.Assertions.assertTrue(condition,message);
        if(!condition){
            String pngFileName = screenshot("my_file_name");
        }
    }
}
