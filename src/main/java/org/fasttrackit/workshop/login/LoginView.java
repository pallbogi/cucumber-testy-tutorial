package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.WebLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginView {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    private WebLocator loginButton = new WebLocator().setId("loginButton");

    private WebLocator email = new WebLocator().setId("email");

    private WebLocator psswrd = new WebLocator().setId("password");

    private WebLocator error = new WebLocator().setClasses("error-msg");

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void enterCredentials(String emailValue, String psswrdValue) {
        email.sendKeys(emailValue);
        psswrd.sendKeys(psswrdValue);
    }

    public String errorMessageText() {
        return error.getHtmlText();
    }
}
