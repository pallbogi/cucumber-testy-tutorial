package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.preferences.PreferencesWindow;

/**
 * Created by Boglarka_Pall on 7/4/2015.
 */
public class PreferencesSteps extends TestBase {

    private PreferencesWindow preferencesWindow = new PreferencesWindow();

    @Then("^I should see \"([^\"]*)\" message$")
    public void I_should_see_message(String message) throws Throwable {
       // Assert.assertThat(loginPage.errorMessageText(), is(errorValue));
        Utils.sleep(100);
    }

    @When("^I click on Preferences button$")
    public void I_click_on_Preferences_button() throws Throwable {
        preferencesWindow.open();
    }

    @And("^I input current password$")
    public void I_input_current_password() throws Throwable {
        preferencesWindow.typeCurrentPassword(LoginSteps.VALID_PASSWORD);
    }

    @And("^I input new password$")
    public void I_input_new_password() throws Throwable {
        preferencesWindow.typeNewPassword("alma");
    }

    @And("^I confirmed the new password$")
    public void I_confirmed_the_new_password() throws Throwable {
        preferencesWindow.confirmNewPassword("alma");
    }

    @And("^I click on the Save button$")
    public void I_click_on_the_Save_button() throws Throwable {
        preferencesWindow.save();
    }

    @Then("^I can relogin with the new credentials$")
    public void I_can_relogin_with_the_new_credentials() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

}
