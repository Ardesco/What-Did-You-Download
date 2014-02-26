package com.lazerycode.selenium.Tests;

import com.lazerycode.selenium.PageObjects.LoginPage;
import com.lazerycode.selenium.PageObjects.SecretFiles;
import com.lazerycode.selenium.SeleniumBase;
import com.lazerycode.selenium.Utility.FileDownloader;
import org.testng.annotations.Test;

import java.io.File;

import static com.lazerycode.selenium.Utility.CheckFileHash.getFileHash;
import static com.lazerycode.selenium.Utility.TypeOfHash.SHA1;
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class LogInGetAFileAndCheckItTest extends SeleniumBase {

    @Test
    public void logInAndDownloadSecretFile() throws Exception {
        getDriverObject().get("http://localhost:8080/downloads/");

        LoginPage loginPage = new LoginPage();
        SecretFiles secretFilesPage = loginPage.logIn("foo", "bar");

        FileDownloader fileDownloader = new FileDownloader(getDriverObject());
        fileDownloader.setURI(secretFilesPage.getSecretFileHREF());
        File secretFile = fileDownloader.downloadFile();
        int httpStatusCode = fileDownloader.getLastDownloadHTTPStatus();

        assertEquals(httpStatusCode, 200);
        assertEquals(getFileHash(secretFile, SHA1), ("781811ab9052fc61e109012acf5f22da89f2a5be"));
    }

    @Test
    public void tryAndDownloadSecretFileWithoutLoggingIn() throws Exception {
        getDriverObject().get("http://localhost:8080");

        FileDownloader fileDownloader = new FileDownloader(getDriverObject());
        fileDownloader.setURI("http://localhost:8080/downloads/secured-files/secret.pdf");
        File secretFile = fileDownloader.downloadFile();
        int httpStatusCode = fileDownloader.getLastDownloadHTTPStatus();

        assertEquals(httpStatusCode, 200);
        assertEquals(getFileHash(secretFile, SHA1), ("781811ab9052fc61e109012acf5f22da89f2a5be"));
    }
}
