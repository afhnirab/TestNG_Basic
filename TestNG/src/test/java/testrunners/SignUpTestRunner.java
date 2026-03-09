package testrunners;
import com.github.javafaker.Faker;
import config.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utils.Utils;

import java.io.IOException;

public class SignUpTestRunner extends Setup {
    @Test(priority=1, description = "Signup test case")
    public void doRegistration() throws InterruptedException, IOException, ParseException {
        SignUpPage signUpPage = new SignUpPage(driver);
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = "asd15@gmail.com";
        String password = "12345";
        String phoneNumber = "016234";
        String address = faker.address().fullAddress();
        signUpPage.doRegistration(firstName, lastName, email, password, phoneNumber, address);
        Thread.sleep(6000);
        String btnLoginActual = driver.findElement(By.tagName("h1")).getText();
        String btnLoginExpected = "Login";
        Assert.assertEquals(btnLoginActual, btnLoginExpected);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstname", firstName);
        jsonObject.put("lastname", lastName);
        jsonObject.put("email", email);
        jsonObject.put("password", password);
        Utils.saveJsonData(jsonObject, "./src/test/resources/users.json");
        Thread.sleep(6000);
    }
}
