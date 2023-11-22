package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //Find the Sign link on home page and click on it.
        WebElement signLink = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signLink.click();

        String expectedMessage = "Welcome Back!";

        WebElement displayedMessage = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualMessage =displayedMessage.getText();

        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(5000);
    }
    @Test
    public void verifyTheErrorMessage() throws InterruptedException {


        WebElement signLink1 = driver.findElement(By.partialLinkText("Sign"));
        signLink1.click();

        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("jit123@gmail.com");
        WebElement passField = driver.findElement(By.name("user[password]"));
        passField.sendKeys("Pass12");

        WebElement loginLink1 = driver.findElement(By.xpath("(//button[@type='submit'])"));
        loginLink1.click();
        Thread.sleep(10000);
        Thread.sleep(10000);

        String expectedMessage = "Invalid email or password.";

        WebElement actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));

        String actualMessage = actualText.getText();

        Assert.assertEquals(expectedMessage,actualMessage);
    }


    @After
    public void tearDown(){
        closedBrowser();
    }
}
