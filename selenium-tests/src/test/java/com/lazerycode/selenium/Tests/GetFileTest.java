package com.lazerycode.selenium.Tests;

import com.lazerycode.selenium.PageObjects.LoginPage;
import com.lazerycode.selenium.SeleniumBase;
import com.lazerycode.selenium.Utility.FileDownloader;
import org.testng.annotations.Test;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class GetFileTest extends SeleniumBase {

    @Test
    public void downloadAFile() throws Exception {
//        getDriverObject().get("http://localhost:8080/downloads/");
        getDriverObject().get("http://localhost:8080/downloads/tampered.html");

        LoginPage loginPage = new LoginPage();

        FileDownloader fileDownloader = new FileDownloader(getDriverObject());
        fileDownloader.setURI(loginPage.getLinkToTermsAndConditions());
        fileDownloader.downloadFile();
        int httpStatusCode = fileDownloader.getLastDownloadHTTPStatus();

        assertEquals(httpStatusCode, 200);
    }
}
