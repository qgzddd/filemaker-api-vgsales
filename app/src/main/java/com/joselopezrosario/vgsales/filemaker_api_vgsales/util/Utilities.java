package com.joselopezrosario.vgsales.filemaker_api_vgsales.util;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public final class Utilities {

    /**
     * encodeFileMakerCredentials
     * @param accountName the FileMaker account with fmrest privileges
     * @param password the FileMaker account's password
     * @return the Base54 encoded credentials
     */
    public static String encodeFileMakerCredentials(String accountName, String password){
        if ( accountName == null || password == null){
            return null;
        }
        String credentials = accountName + ":" + password;
        String encodedCredentials;
        byte[] credentialBytes;
        try {
            credentialBytes = credentials.getBytes("UTF-8");
            encodedCredentials = Base64.encodeToString(credentialBytes, Base64.DEFAULT).trim();
            return encodedCredentials;
        } catch (UnsupportedEncodingException e) {
            System.out.print("Could not encode credentials: " + e.toString());
            return null;
        }
    }

    @SuppressWarnings("SameParameterValue")
    public static void showToast(Context context, String message, int duration) {
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}