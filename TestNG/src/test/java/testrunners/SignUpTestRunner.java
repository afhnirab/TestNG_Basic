package testrunners;

import com.github.javafaker.Faker;
import config.Setup;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUpTestRunner extends Setup {
    @Test
    public void doRegistration(){
        SignUpPage signUpPage = new SignUpPage(driver);
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = "asd@gmail.com";
        String password = "12345";
        String phoneNumber = "016234";
        String address = faker.address().fullAddress();
        signUpPage.doRegistration(firstName, lastName, email, password, phoneNumber, address);
    }

}
