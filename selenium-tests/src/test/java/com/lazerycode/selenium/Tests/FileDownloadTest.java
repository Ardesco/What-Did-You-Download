package com.lazerycode.selenium.Tests;

import com.lazerycode.selenium.PageObjects.LoginPage;
import com.lazerycode.selenium.SeleniumBase;
import org.testng.annotations.Test;

public class FileDownloadTest extends SeleniumBase {

    @Test
    public void tryToDownloadFile() {
        getDriverObject().get("http://localhost:8080/downloads/");
//        getDriverObject().get("http://localhost:8080/downloads/tampered.html");
        LoginPage loginPage = new LoginPage();
        loginPage.downloadTermsAndConditions();
    }
}