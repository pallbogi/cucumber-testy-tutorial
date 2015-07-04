package org.fasttrackit.workshop.preferences;

import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLButtonElement;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

/**
 * Created by Boglarka_Pall on 7/4/2015.
 */
public class PreferencesWindow {


    private WebLocator window = new WebLocator().setId("preferences-win");

    private Button preferencesButton = new Button().setText("Preferences");
    //private TextField currentPassword = new TextField().setLabel("Current Password");
    private TextField currentPassword = new TextField().setElPath("//label[text()='Current Password']//following-sibling::*//input");
    private TextField newPassword = new TextField().setElPath("//label[text()='New Password']//following-sibling::*//input");
    private TextField confirmNewPassword = new TextField().setElPath("//label[text()='Repeat Password']//following-sibling::*//input");
    private Button saveButton = new Button().setText("Save").setContainer(window);
    private Button closeButton = new Button().setText("Close").setContainer(window);

    public static void main(String[] args) {
        PreferencesWindow preferencesWindow = new PreferencesWindow();
        System.out.println(preferencesWindow.window.getPath());
        System.out.println(preferencesWindow.saveButton.getPath());
    }


    public void open() {
        preferencesButton.click();
    }

    public void typeCurrentPassword(String validPassword) {
        Utils.sleep(500);
        currentPassword.setValue(validPassword);
    }

    public void typeNewPassword(String newPasswordValue) {
        newPassword.setValue(newPasswordValue);
    }

    public void confirmNewPassword(String confirmNewPasswordValue) {
        confirmNewPassword.setValue(confirmNewPasswordValue);
    }

    public void save() {
        saveButton.click();
        Utils.sleep(500);
    }
}
