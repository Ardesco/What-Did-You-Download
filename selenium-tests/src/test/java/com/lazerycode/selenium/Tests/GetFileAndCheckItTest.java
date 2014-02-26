package com.lazerycode.selenium.Tests;

import com.lazerycode.selenium.PageObjects.LoginPage;
import com.lazerycode.selenium.SeleniumBase;
import com.lazerycode.selenium.Utility.FileDownloader;
import org.testng.annotations.Test;

import java.io.File;

import static com.lazerycode.selenium.Utility.CheckFileHash.getFileHash;
import static com.lazerycode.selenium.Utility.TypeOfHash.SHA1;
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class GetFileAndCheckItTest extends SeleniumBase {

    @Test
    public void downloadAFile() throws Exception {
//        getDriverObject().get("http://localhost:8080/downloads/");
        getDriverObject().get("http://localhost:8080/downloads/tampered.html");

        LoginPage loginPage = new LoginPage();

        FileDownloader fileDownloader = new FileDownloader(getDriverObject());
        fileDownloader.setURI(loginPage.getLinkToTermsAndConditions());
        File termsAndConditions = fileDownloader.downloadFile();
        int httpStatusCode = fileDownloader.getLastDownloadHTTPStatus();

        assertEquals(httpStatusCode, 200);
        assertEquals(getFileHash(termsAndConditions, SHA1), ("bfbc857f1496a126f1703273e3d62a35cffdd34c"));
    }
}
