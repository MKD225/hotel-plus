/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.util;

import java.security.MessageDigest;

/**
 *
 * @author vgladky
 */
public class Encryption {

    /**
     * Повертає хеш код для пароля, який є параметром функції
     *
     * @return хеш-код у форматі MD5
     * @throws Exception
     */
    public static String getHash(String pass) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
