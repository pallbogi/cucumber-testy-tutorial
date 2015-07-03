package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.fasttrackit.util.TestBaseNative;
import org.fasttrackit.workshop.pagefactory.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    @Given("^I aaccess the login page$")
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

        Utils.sleep(4000);
    }

    @When("^I click on login button$")
    public void I_click_on_login_button() throws Throwable {

        System.out.println("I_click_on_login_button");
        WebElement button = driver.findElement(By.id("loginButton"));
        button.click();

        Utils.sleep(4000);
    }

    @Then("^I except successful login message$")
    public void I_except_successful_login_message() throws Throwable {

        System.out.println("I_except_successful_login_message");

        //WebElement whatever = driver.findElement(By.className("navbar-brand"));
        //Assert.assertNotNull("Navigation bar doesn't exists on the page", whatever);

        try {
            WebElement logout = driver.findElement(By.linkText("Logoutxx"));
        }
        catch (Exception e){
            Assert.fail("Logout button was not found");
        }

    }

    @Given("^I access the login page$")
    public void I_access_the_login_page() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I expect invalid credentials message$")
    public void I_expect_invalid_credentials_message() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
