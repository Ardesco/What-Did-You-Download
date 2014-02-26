package com.lazerycode.selenium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.lazerycode.selenium.SeleniumBase.getDriverObject;

public class LoginPage extends PageFactory {

    @FindBy(how = How.ID, using = "username")
    WebElement username;
    @FindBy(how = How.ID, using = "password")
    WebElement password;
    @FindBy(how = How.ID, using = "login")
    WebElement login;
    @FindBy(how = How.ID, using = "terms")
    WebElement termsAndConditions;

    public LoginPage() {
        PageFactory.initElements(getDriverObject(), this);
    }

    public SecretFiles logIn(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
        return new SecretFiles();
    }

    public void downloadTermsAndConditions() {
        termsAndConditions.click();
    }

    public String getLinkToTermsAndConditions() {
        return termsAndConditions.getAttribute("href");
    }

}