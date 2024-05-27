import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static com.codeborne.selenide.Selenide.$;



public class CheckPages extends TestBase {

    static Stream<Arguments> сheckingTheAuthorizationPage(){
        return Stream.of(
                Arguments.of("standard_user", "secret_sauce"),
                Arguments.of("performance_glitch_user", "secret_sauce")
        );
    }

   @MethodSource
   @ParameterizedTest
    @Tag("REGRESSION")
   @DisplayName("Проверка страницы авторизации")
    public void сheckingTheAuthorizationPage(String username, String password) {
       Selenide.open("https://www.saucedemo.com/");
       $("#user-name").setValue(username);
       $("#password").setValue(password);
       $("#login-button").click();
       Selenide.closeWebDriver();


    }


}
