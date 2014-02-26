package com.lazerycode.selenium.Utility;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckFileHash {

    /**
     * Performs a expectedFileHash check on a File.
     *
     * @return the hash in the specified format
     * @throws IOException
     */
    public static String getFileHash(File file, TypeOfHash hash) throws IOException{
        if (null == file) throw new FileNotFoundException("File to check has not been set!");
        if (null == hash) throw new NullPointerException("Hash type has not been set!");

        switch (hash) {
            case MD5:
                return DigestUtils.md5Hex(new FileInputStream(file));
            case SHA1:
            default:
                return DigestUtils.sha1Hex(new FileInputStream(file));
        }
    }

}
