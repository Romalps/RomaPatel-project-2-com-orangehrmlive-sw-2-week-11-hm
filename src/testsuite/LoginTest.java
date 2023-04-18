package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*2. Create the package ‘testsuite’ and create the
        following classes inside the ‘testsuite’ package.
        1. LoginTest
        2. ForgotPasswordTest
3. Write down the following test into ‘LoginTest’ class
1. userShouldLoginSuccessfullyWithValidCredentials
* Enter “Admin” username
* Enter “admin123 password
* Click on ‘LOGIN’ button
* Verify the ‘Dashboard’ text is display
 */
public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {

        // Find the Username field element and send username element
        driver.findElement(By.name("username")).sendKeys("Admin");
        // Find Password field element and send password element
        driver.findElement(By.name("password")).sendKeys("admin123");

        // Find Login button element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedMessage = "Dashboard";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
        String actualMessage = actualTextElement.getText();

        Assert.assertEquals("Dashboard text displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
