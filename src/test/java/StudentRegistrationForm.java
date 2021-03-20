
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.io.File;

public class StudentRegistrationForm {

    @Test
    void successfulFillForm() {
        String firstName = "Dino";
        String lastName = "Dinosaurus";
        String userEmail = "Dino@Dinosaurussaur.us";
        String userNumber = "0123456789";
        String subjectsInput = "Arts";
        String currentAddress = "Dinopark, 12, 172";
        String state = "Haryana";
        String city = "Karnal";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day.react-datepicker__day--011").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $(byText("Sports")).click();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/default_avatar.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $(".modal-content").shouldHave
                (text(firstName),
                        text(userNumber),
                        text(lastName),
                        text(subjectsInput),
                        text(userEmail),
                        text(currentAddress),
                        text(state),
                        text(city),
                        text("default_avatar.jpg"),
                        text("11 March,2021")
                );
    }

}