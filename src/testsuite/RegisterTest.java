package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    // open the browser
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //find Register and click
        WebElement register = driver.findElement(By.xpath("//a[contains(text(),'Register']"));
        register.click();

        //find first name and send value
        WebElement firstName = driver.findElement(By.id("Customer.FirstName"));
        firstName.sendKeys("Christina");
        //find last name and send value
        WebElement lastName = driver.findElement(By.id("Customer.LastName"));
        lastName.sendKeys("George");
        //find date of birth fields and send values to all
        WebElement Address = driver.findElement(By.id("Customer.Address.street"));
        Address.sendKeys("14 Shahibaug Road");
        WebElement City = driver.findElement(By.id("Customer.Address.city"));
        City.sendKeys("Ahmedabad");
        WebElement state = driver.findElement(By.id("Customer.Address.state"));
        state.sendKeys("Gujarat");
        WebElement ZipCode = driver.findElement(By.id("Customer.Address.ZipCode"));
        state.sendKeys("380016");
        WebElement PhoneNumber = driver.findElement(By.id("Customer.PhoneNumber"));
        PhoneNumber.sendKeys("00800866821");
        WebElement ssn = driver.findElement(By.id("Customer.ssn"));
        ssn.sendKeys("6662564");
        //find emailfield and send values
        WebElement username = driver.findElement(By.id("Customer.userName"));
        username.sendKeys("Christina");
        WebElement password = driver.findElement(By.id("Customer.pasword"));
        password.sendKeys("Christina123");
        WebElement Confirmpassword = driver.findElement(By.id("Customer.Confirmpasword"));
        username.sendKeys("Christina123");

        //find Register button and click
        WebElement registerButton = driver.findElement(By.name("register-button"));
        registerButton.click();
        //verify the requirement

        String expectedText = "Your account was created successfully. You are now logged in.";
        //validate actual and expected text
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in')]"));
        String actualText = "Your account was created successfully. You are now logged in.";

        Assert.assertEquals("Your account was created successfully. You are now logged in.", expectedText, actualText);
    }
}


