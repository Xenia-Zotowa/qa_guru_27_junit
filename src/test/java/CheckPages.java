import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class CheckPages extends TestBase {

    static Stream<Arguments> сheckingTheAuthorizationPage() {
        return Stream.of(
                Arguments.of("standard_user", "secret_sauce"),
                Arguments.of("performance_glitch_user", "secret_sauce")
        );
    }

    @MethodSource
    @ParameterizedTest
    @Tag("REGRESSION")
    @DisplayName("Проверка страницы авторизации")
    public void сheckingTheAuthorizationPageTest(String username, String password) {
        open("https://www.saucedemo.com/");
        $("#user-name").setValue(username);
        $("#password").setValue(password);
        $("#login-button").click();

    }

    @ValueSource(strings = {
            "Sergey", "Igor", "Petr"
    })

    @ParameterizedTest
    @DisplayName("Проверка заполнения имени пользователя")
    public void checkingTheUserNameFillingTest(String firstName) {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(firstName);

    }

    @CsvSource(value = {
            "Sergey, Vong",
            "Igor, Ivanov",
            "Petr, Petrov"
    })

    @ParameterizedTest(name = "Проверка заполнения имени {0} и фамилии {1} пользователя")
    public void checkingTheUserFirstAndLastNameTest(String firstName, String lastName) {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
    }


}
