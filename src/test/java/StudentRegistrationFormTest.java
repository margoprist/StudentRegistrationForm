
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//import java.io.File;

public class StudentRegistrationFormTest {

    @Test
    void successfulFillForm() {
        String firstName = "Dino",
                lastName = "Dinosaurus",
                userEmail = "Dino@Dinosaurussaur.us",
                userNumber = "0123456789",
                monthOfBirth = "March",
                yearOfBirth = "1965",
                hobby = "Sports",
                subjectsInput = "Arts",
                currentAddress = "Dinopark, 12, 172",
                state = "Haryana",
                city = "Karnal";

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--016").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $(byText("Sports")).click();
      //  $("input#uploadPicture").uploadFile(new File("src/test/resources/default_avatar.jpg"));
        $("#uploadPicture").uploadFromClasspath("default_avatar.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $(".modal-content").shouldHave
                (text(firstName),
                        text(userNumber),
                        text(lastName),
                        text(subjectsInput),
                        text(hobby),
                        text(userEmail),
                        text(currentAddress),
                        text(state),
                        text(city),
                        text("default_avatar.jpg"),
                        text("16 March,1965")
                );
    }

}