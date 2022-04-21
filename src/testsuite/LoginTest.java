package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        WebElement userName = driver.findElement(By.name("username"));
        // Sending email to email field element
        userName.sendKeys("Christina");
        //  Find the password field element

        WebElement password = driver.findElement(By.name("password"));
        // Sending Password to password field element
        password.sendKeys("Christina123");
        //find the login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        // click on the login button
        loginButton.click();

        // this is requirement
        String expectedmessage = "Accounts Overview";
        WebElement actualelement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualmessage = actualelement.getText();
        // System.out.println(actualmessage);
        // validate actual and expected message
        Assert.assertEquals("\"Accounts Overview\" message not Display", expectedmessage, actualmessage);


    }


    @Test
    public void verifyTheErrorMessage() {

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        // Sending email to email field element
        userName.sendKeys("Christina");
        //  Find the password field element

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        // Sending Password to password field element
        password.sendKeys("Christina123");
        //find the login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        // click on the login button
        loginButton.click();

        // this is requirement
        String expectedmessage = "The username and password could not be verified.";
        WebElement actualelement = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        String actualmessage = actualelement.getText();
        // System.out.println(actualmessage);
        // validate actual and expected message
        Assert.assertEquals("\"The username and password could not be verified.\"error message not found", expectedmessage, actualmessage);
    }
        @Test
        public void userShouldLogOutSuccessfully(){

            //Find the userName field
            WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
            // Sending email to email field element
            userName.sendKeys("Christina");
            //  Find the password field element

            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            // Sending Password to password field element
            password.sendKeys("christina123");
            //find the login button and click on it
            WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
            // click on the login button
            loginButton.click();
            //find the logout  field element
            WebElement loginout = driver.findElement(By.linkText("Log Out"));
            // click on the logout button
            loginout.click();
            // this is requirement
            String expectedmessage = "Customer Login";
            WebElement actualelement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
            String actualmessage = actualelement.getText();
            // System.out.println(actualmessage);
            // validate actual and expected message
            Assert.assertEquals("\"Customer Login\" message not found", expectedmessage, actualmessage);


        }
    }

