package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.junit.Assert;
import org.fasttrackit.util.TestBaseNative;
import org.fasttrackit.workshop.pagefactory.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.hamcrest.core.Is.is;

//public class LoginSteps extends TestBaseNative {
public class LoginSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
    public static final String VALID_EMAIL = "eu@fast.com";
    public static String VALID_PASSWORD = "eu.pass";

    //LoginPage loginPage;

   // public void initPage() {
   //     loginPage = PageFactory.initElements(driver, LoginPage.class);
   // }


   // public LoginSteps() {
   //     initPage();
   // }

    private LoginView loginPage = new LoginView();

    @Given("^I access the login page$")
    public void I_access_the_login_page() throws Throwable {
        System.out.println("Access the login page");
        driver.get("http://bit.ly/fasttrackit-automation-app-demo");
    }

    @And("^I insert valid credentials$")
    public void I_insert_valid_credentials() throws Throwable {
        System.out.println("Insert valid credentials");
        I_enter_credentials(VALID_EMAIL, VALID_PASSWORD);
    }

    @And("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() throws Throwable {
        System.out.println("Insert invalid credentials");
        I_enter_credentials("eu@fast.com", "eu.passxxx");
    }

    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_enter_credentials(String emailValue, String psswrdValue) throws Throwable {
        System.out.println("Enter credentials");
        loginPage.enterCredentials(emailValue, psswrdValue);
        Utils.sleep(100);
    }

    @When("^I click on login button$")
    public void I_click_on_login_button() throws Throwable {
        System.out.println("Click on login button");
        loginPage.clickOnLoginButton();
        Utils.sleep(100);
    }



    @Then("^I except successful login message$")
    public void I_except_successful_login_message() throws Throwable {
        //WebElement whatever = driver.findElement(By.className("navbar-brand"));
        //Assert.assertNotNull("Navigation bar doesn't exists on the page", whatever);
        System.out.println("Expect visible Logout button");
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

    @Then("^I expect invalid credentials message$")
    public void I_expect_invalid_credentials_message() throws Throwable {
        System.out.println("I except error message");
        I_expect_message("Invalid user or password!");
    }

    @Then("^I expect \"([^\"]*)\" message$")
    public void I_expect_message(String errorValue) throws Throwable {
        System.out.println("I except error message");
        Assert.assertThat(loginPage.errorMessageText(), is(errorValue));
        Utils.sleep(100);
    }

    @Given("^I successfully login$")
    public void I_successfully_login() throws Throwable {
        I_access_the_login_page();
        I_insert_valid_credentials();
        I_click_on_login_button();
        I_except_successful_login_message();
    }

    @When("^I click on logout button$")
    public void I_click_on_logout_button() throws Throwable {
        System.out.println("Click on logout button");
        WebElement button = driver.findElement(By.linkText("Logout"));
        button.click();
        Utils.sleep(100);
    }

    @Then("^I should be logged out$")
    public void I_should_be_logged_out() throws Throwable {
        System.out.println("Expect visible Login button");
        boolean isDisplayed = false;
        try {
            WebElement login = driver.findElement(By.id("loginButton"));
            isDisplayed = login.isDisplayed();
        }
        catch (Exception e){
            Assert.fail("Login button was not found");
        }
        Assert.assertTrue("Login button is not displayed", isDisplayed);
    }
}
