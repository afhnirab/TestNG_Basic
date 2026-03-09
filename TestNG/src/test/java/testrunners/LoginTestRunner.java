package testrunners;

import config.Setup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTestRunner extends Setup {
    @Test
    public void doLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("admin@test.com", "admin123");
        String headerActual = driver.findElement(By.tagName("h2")).getText();
        String headerExpected = "Admin Dashboard";
        Assert.assertTrue(headerActual.contains(headerExpected));
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.btnUserProfileIcon.get(0).isDisplayed());
    }
}
