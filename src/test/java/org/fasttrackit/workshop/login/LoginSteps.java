package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.fasttrackit.util.TestBaseNative;
import org.fasttrackit.workshop.pagefactory.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.hamcrest.core.Is.is;

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    @Given("^I access the login page$")
    public void I_aaccess_the_login_page() throws Throwable {

        System.out.println("I aaccess the login page");
        driver.get("http://bit.ly/fasttrackit-automation-app-demo");

    }

    @And("^I insert valid credentials$")
    public void I_insert_valid_credentials() throws Throwable {

        System.out.println("I_insert_valid_credentials");
        /*
        //Test with java ROBOT

        Robot robot = new Robot();

        // SET THE MOUSE X Y POSITION
        robot.mouseMove(200, 150);
        // LEFT CLICK
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyPress(KeyEvent.VK_I);

        robot.mouseMove(200, 200);
        // LEFT CLICK
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyPress(KeyEvent.VK_I);

        robot.mouseMove(180, 230);
        // LEFT CLICK
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        Thread.sleep(4000);
        */

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("eu@fast.com");

        WebElement psswrd = driver.findElement(By.id("password"));
        psswrd.sendKeys("eu.pass");

        Utils.sleep(2000);
    }

    @When("^I click on login button$")
    public void I_click_on_login_button() throws Throwable {

        System.out.println("I_click_on_login_button");
        WebElement button = driver.findElement(By.id("loginButton"));
        button.click();

        Utils.sleep(2000);
    }

    @Then("^I except successful login message$")
    public void I_except_successful_login_message() throws Throwable {

        System.out.println("I_except_successful_login_message");

        //WebElement whatever = driver.findElement(By.className("navbar-brand"));
        //Assert.assertNotNull("Navigation bar doesn't exists on the page", whatever);

        boolean isDisplayed = false;
        try {
            WebElement logout = driver.findElement(By.linkText("Logout"));
            isDisplayed = logout.isDisplayed();
        }
        catch (Exception e){
            Assert.fail("Logout button was not found");
        }

        Assert.assertTrue("Logout button is not displayed", isDisplayed);

    }

    @And("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() throws Throwable {
        System.out.println("I_insert_invalid_credentials");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("eu@fast.com");

        WebElement psswrd = driver.findElement(By.id("password"));
        psswrd.sendKeys("eu.passxxx");

        Utils.sleep(2000);

    }

    @Then("^I expect invalid credentials message$")
    public void I_expect_invalid_credentials_message() throws Throwable {

        System.out.println("I_except_error_message");

        WebElement error = driver.findElement(By.className("error-msg"));
        Assert.assertThat(error.getText(), is("Invalid user or password!"));

        Utils.sleep(2000);

    }
}
