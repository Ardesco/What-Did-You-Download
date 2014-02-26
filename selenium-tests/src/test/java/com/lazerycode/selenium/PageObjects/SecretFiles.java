package com.lazerycode.selenium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.lazerycode.selenium.SeleniumBase.getDriverObject;

public class SecretFiles extends PageFactory {
    @FindBy(how = How.ID, using = "secret")
    WebElement secretFile;

    public SecretFiles() {
        PageFactory.initElements(getDriverObject(), this);
    }

    public void downloadSecretFile() {
        secretFile.click();
    }

    public String getSecretFileHREF(){
        return secretFile.getAttribute("href");
    }
}
